/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ponge.cubis;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;
import hr.ponge.cubis.grec.model.GrecMesh;
import hr.ponge.cubis.objects.Cube;
import hr.ponge.cubis.objects.Ground;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kruno
 */
public class Game extends Component {

    private static final Logger logger = Logger.getLogger(Game.class.getName());
    Ground ground = null;
    public static long screenWidth;
    public static long screenHeight;
    private long firstClick = 0l;
    private boolean doubleClick = false;
    private boolean leftMouseDown = false;
    private List<Cube> cubes = new ArrayList<Cube>();
    private List<int[]> points = new ArrayList<int[]>();
    private GrecMesh grecMesh = null;
    private String word = "";
    private String winWord = "";
    private float xHudKoef = 1;
    private float yHudKoef = 1;
    Node masterGameNode;
    private boolean active = false;
    private long startTime = 0;
    private BitmapFont font;
    private BitmapText hudTaskText;
    private BitmapText hudTimeText;
    private int wordWin = 0;
    private int wordLost = 0;
    private boolean winScreen = false;
    private BitmapText hudScoreText;
    private Picture hud;
    private Picture hudWin;
    private long endTime = 0;

    public Game(Main application) {
        super(application);


    }

    @Override
    public void update(float tpf) {
        if (!active) {
            return;
        }
        eventHandler(tpf);


        //reslove cube transitions
        for (Cube c : cubes) {

            c.resolveTransitions(tpf);

        }
        boolean changeHappend = false;
        // update cube positions
        for (Cube c : cubes) {

            boolean cubeChangeHappend = c.updateScene(tpf);
            if (cubeChangeHappend) {
                changeHappend = true;
                c.changeHappend(tpf);
            }

        }

        if (changeHappend) {
            resolveWinConditions();
        }



        updateHud(tpf);
    }

    @Override
    public void render(RenderManager rm) {
        if (!active) {
            return;
        }
    }

    @Override
    public void activate() {
        masterGameNode = new Node("MASTER_GAME_NODE");
        screenWidth = app.getSettings().getWidth();
        screenHeight = app.getSettings().getHeight();
        initKeys();
        ground = new Ground(assetManager);
        masterGameNode.attachChild(ground.getNode());
        resetCubes();



        winWord = WordDb.convertForScreen(WordDb.getRandomWord());

        startTime = System.currentTimeMillis();

        wordWin = 0;
        wordLost = 0;
        winScreen = false;
        endTime = 0;
        setupHUD();
        rootNode.attachChild(masterGameNode);
        active = true;

    }

    public String getTimeElapsed() {
        long timeElapsed = 0;
        if (!winScreen) {
            timeElapsed = System.currentTimeMillis() - startTime;
        } else {
            timeElapsed = endTime - startTime;
        }

        long sec = timeElapsed / 1000;

        long min = sec / 60;
        long s = sec - (min * 60);



        return String.format("%02d:%02d", min, s);

    }

    @Override
    public void deactivate() {
        active = false;
        cubes.clear();
        points.clear();
        relaseKeys();
        app.getGuiNode().detachAllChildren();



        rootNode.detachChild(masterGameNode);
        ground = null;
        masterGameNode = null;

    }

    public Cube getSelectedCube() {
        for (Cube c : cubes) {
            if (c.isSelected()) {
                return c;

            }

        }
        return null;
    }

    protected void eventHandler(float tpf) {
        if (leftMouseDown) {
            Vector2f click2d = inputManager.getCursorPosition();
            points.add(new int[]{(int) click2d.x, (int) click2d.y});
        }


    }

    private void resolveWinConditions() {
        String word = "";
        List<Cube> cubesInArea = new ArrayList<Cube>();
        for (Cube c : cubes) {
            float x = c.getWorldLoaction().x;
            float z = c.getWorldLoaction().z;
            if (x < -7.12f && x > -11f && z > -12 && z < 4.7) {
                if (!c.isSelected()) {
                    cubesInArea.add(c);
                }
            }

        }


        Collections.sort(cubesInArea, new Comparator<Cube>() {
            @Override
            public int compare(Cube c1, Cube c2) {
                Float z1 = c1.getWorldLoaction().z;
                Float z2 = c2.getWorldLoaction().z;
                return z1.compareTo(z2);
            }
        });

        for (Cube c : cubesInArea) {
            word = word.concat(c.getLetter());
        }
        this.word = word;
        String testWord = WordDb.convertBackFromScreen(winWord);
        logger.log(Level.INFO, "WORD IS {0} AND WIN WORD IS {1}", new String[]{word, testWord});
        if (word != null && word.equals(testWord)) {

            if (!winScreen) {
                wordWin++;
                nextWord();
            }


        }


    }

    private void relaseKeys() {
        // You can map one or several inputs to one named action
        inputManager.deleteMapping("SHOOT");
        inputManager.removeListener(actionListener);


    }

    /**
     * Custom Keybinding: Map named actions to inputs.
     */
    private void initKeys() {
        // You can map one or several inputs to one named action

        inputManager.addMapping("SHOOT", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));


        // Add the names to the action listener.
        inputManager.addListener(actionListener, "SHOOT");


    }
    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            long now = System.currentTimeMillis();
            // detectGesture(name, keyPressed);
            boolean buttonsPushed = false;
            if (name.equals("SHOOT") && keyPressed) {
                buttonsPushed = handlePushingButtons();
            }

            if (name.equals("SHOOT") && keyPressed && !buttonsPushed && !winScreen) {
                detectDoubleClick(now);


                Ray ray = getMouseRay();
                boolean selected = false;
                if (true) {
                    Cube selectedCube = getSelectedCube();
                    for (Cube c : cubes) {
                        if (c.colide(ray)) {
                            // If cube is already selected do not do any thing 
                            // this would mean that you can select two cubes at once 
                            // or that you can put two cubes at same place
                            if (selectedCube == null) {
                                c.selected();
                            }
                            selected = true;
                            break;
                        }
                    }

                    if (!selected) {
                        if (ground.colide(ray)) {
                            moveSelectedObject();
                        }
                    }
                } else {
                }
                doubleClick = false;

            }


        }

        private void detectDoubleClick(long now) {
            if ((now - firstClick) < Constants.DOUBLE_CLICK_MS) {
                doubleClick = true;
                firstClick = now;

            } else {
                firstClick = now;
                doubleClick = false;
            }
        }

        private Ray getMouseRay() {
            Vector2f click2d = inputManager.getCursorPosition();
            Vector3f click3d = app.getCamera().getWorldCoordinates(
                    new Vector2f(click2d.x, click2d.y), 0f).clone();
            Vector3f dir = app.getCamera().getWorldCoordinates(
                    new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d).normalizeLocal();
            Ray ray = new Ray(click3d, dir);
            return ray;
        }

        private void moveSelectedObject() {
            for (Cube c : cubes) {
                if (c.isSelected()) {
                    c.setSelected(false);
                    c.moveTo(ground.getColidePosition());

                }
            }
        }

        protected void detectGesture(String name, boolean keyPressed) {
            if (name.equals("SHOOT")) {

                leftMouseDown = keyPressed;
                if (keyPressed) {
                    points.clear();
                }
                // less than 10 mouse points do not consider command
                if (!keyPressed && points.size() > 0 && points.size() < 10) {
                    points.clear();
                }

                //more than 9 mouse points try to recognize command
                if (!keyPressed && points.size() > 0) {
                    // transalte to III kvadrant
                    int maxY = 0;
                    for (int[] a : points) {
                        if (a[1] > maxY) {
                            maxY = a[1];
                        }
                    }
                    for (int[] a : points) {
                        a[1] = Math.abs(a[1] - maxY);
                    }


                    grecMesh.clearMash();
                    grecMesh.mapRequest(points);
                    String gesture = grecMesh.analize();

                    Cube c = getSelectedCube();
                    if (c != null) {
                        c.doAction(gesture);
                    }
                    grecMesh.clearMash();
                    points.clear();
                }
            }
        }

        private boolean handlePushingButtons() {
            Vector2f click2d = inputManager.getCursorPosition();
            logger.log(Level.FINE, "MOUSE CORDS PUSH " + click2d);
            float norm_x = click2d.x * xHudKoef;
            float norm_y = click2d.y * yHudKoef;
            if (winScreen) {
                //new game
                if (norm_x >= 221 && norm_x <= 417
                        && norm_y >= 213 && norm_y <= 240) {
                    deactivate();
                    activate();
                    return true;
                }

                //exit
                if (norm_x >= 281 && norm_x <= 358
                        && norm_y >= 133 && norm_y <= 159) {
                    transition("END_GAME");
                    return true;
                }

                return false;
            }

            //detect roll CW;
            if (norm_x >= 540 && norm_x <= 573
                    && norm_y >= 348 && norm_y <= 384) {
                Cube c = getSelectedCube();
                if (c != null) {
                    c.doAction(Constants.CIRCLE_CW);
                    return true;
                }
            }
            //detect roll CCW;
            if (norm_x >= 540 && norm_x <= 573
                    && norm_y >= 96 && norm_y <= 132) {
                Cube c = getSelectedCube();
                if (c != null) {
                    c.doAction(Constants.CIRCLE_CCW);
                    return true;
                }
            }

            //detect roll left;
            if (norm_x >= 505 && norm_x <= 537
                    && norm_y >= 222 && norm_y <= 258) {
                Cube c = getSelectedCube();
                if (c != null) {
                    c.doAction(Constants.LEFT_MOVE);
                    return true;
                }
            }

            //detect roll right;
            if (norm_x >= 574 && norm_x <= 606
                    && norm_y >= 222 && norm_y <= 258) {
                Cube c = getSelectedCube();
                if (c != null) {
                    c.doAction(Constants.RIGHT_MOVE);
                    return true;
                }
            }

            //detect roll up;
            if (norm_x >= 537 && norm_x <= 573
                    && norm_y >= 258 && norm_y <= 290) {
                Cube c = getSelectedCube();
                if (c != null) {
                    c.doAction(Constants.UP_MOVE);
                    return true;
                }
            }
            //detect roll down;
            if (norm_x >= 537 && norm_x <= 573
                    && norm_y >= 189 && norm_y <= 221) {
                Cube c = getSelectedCube();
                if (c != null) {
                    c.doAction(Constants.DOWN_MOVE);
                    return true;
                }
            }

            // SKIP
            if (norm_x >= 501 && norm_x <= 610
                    && norm_y >= 27 && norm_y <= 63) {
                logger.log(Level.FINE, "SKIP WORD " + (wordLost + wordWin));


                wordLost++;
                logger.log(Level.FINE, "LOST WORD +1  " + wordLost);
                nextWord();

                return true;
            }

            // this is to forbide moving cube on command area
            if (norm_x >= 505) {
                return true;
            }

            return false;

        }
    };

    private void setupHUD() {

        hud = new Picture("HUD Picture");
        hud.setImage(assetManager, "Textures/hud/hud.png", true);
        hud.setWidth(app.getSettings().getWidth());
        hud.setHeight(app.getSettings().getHeight());
        hud.setPosition(0, 0);
        app.getGuiNode().attachChild(hud);

        hudWin = new Picture("HUD WIN Picture");
        hudWin.setImage(assetManager, "Textures/hud/hud_win.png", true);
        hudWin.setWidth(app.getSettings().getWidth());
        hudWin.setHeight(app.getSettings().getHeight());
        hudWin.setPosition(0, 0);


        xHudKoef = 640f / (float) app.getSettings().getWidth();
        yHudKoef = 480f / (float) app.getSettings().getHeight();

//
//        Picture win = new Picture("WIN Picture");
//win.setImage(assetManager, "Textures/hud/win.png", true);
//win.setWidth(640);
//win.setHeight(480);
//win.setPosition(0, 0);
//guiNode.attachChild(win);
//        
//        
        font = assetManager.loadFont("Interface/Fonts/ponge.fnt");

        hudTaskText = new BitmapText(font, false);
        hudTaskText.setSize(font.getCharSet().getRenderedSize());      // font size
        hudTaskText.setColor(ColorRGBA.Black);                             // font color
        hudTaskText.setText(winWord);

        hudTaskText.setLocalTranslation((app.getSettings().getWidth() / 2) - (hudTaskText.getLineWidth() / 2), app.getSettings().getHeight() * 0.979166667f, 0); // position
        app.getGuiNode().attachChild(hudTaskText);


        hudTimeText = new BitmapText(font, false);
        hudTimeText.setSize(font.getCharSet().getRenderedSize());      // font size
        hudTimeText.setColor(ColorRGBA.Black);                             // font color
        hudTimeText.setText("0:00");

        hudTimeText.setLocalTranslation((app.getSettings().getWidth() / 2) + (app.getSettings().getWidth() * 0.2f) - (hudTimeText.getLineWidth() / 2), app.getSettings().getHeight() * 0.979166667f, 0); // position
        app.getGuiNode().attachChild(hudTimeText);

        hudScoreText = new BitmapText(font, false);
        hudScoreText.setSize(font.getCharSet().getRenderedSize());      // font size
        hudScoreText.setColor(ColorRGBA.Black);                             // font color
        hudScoreText.setText("SCORE 0:0");

        hudScoreText.setLocalTranslation((app.getSettings().getWidth() / 2) + (app.getSettings().getWidth() * -0.23f) - (hudScoreText.getLineWidth() / 2), app.getSettings().getHeight() * 0.979166667f, 0); // position
        app.getGuiNode().attachChild(hudScoreText);



    }

    private void updateHud(float tpf) {

        hudTimeText.setText(getTimeElapsed());
        hudScoreText.setText("SCORE " + wordWin + ":" + wordLost);


        if (!winScreen && (wordLost + wordWin) >= 10) {
            endTime = System.currentTimeMillis();
            winScreen = true;
            app.getGuiNode().detachChild(hud);
            app.getGuiNode().attachChildAt(hudWin, 0);
            for (Cube c : cubes) {
                masterGameNode.detachChild(c.getNode());
            }
            cubes.clear();

        }

    }

    private void resetCubes() {
        // FIRST ROW
        Cube kocka = new Cube(assetManager, "1", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(10, 1, -6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "2", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(10, 1, -3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "3", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(10, 1, 0);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        kocka = new Cube(assetManager, "4", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(10, 1, 3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "5", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(10, 1, 6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        // SECOND ROW
        kocka = new Cube(assetManager, "6", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(7, 1, -6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "7", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(7, 1, -3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "8", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(7, 1, 0);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        kocka = new Cube(assetManager, "9", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(7, 1, 3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "10", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(7, 1, 6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        // THIRD ROW

        kocka = new Cube(assetManager, "11", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(4, 1, -6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "12", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(4, 1, -3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "13", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(4, 1, 0);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        kocka = new Cube(assetManager, "14", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(4, 1, 3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "15", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(4, 1, 6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        // FOURTH ROW

        kocka = new Cube(assetManager, "16", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(1, 1, -6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "17", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(1, 1, -3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "18", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(1, 1, 0);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());


        kocka = new Cube(assetManager, "19", Util.cubeMap1);
        kocka.getNode().setLocalTranslation(1, 1, 3);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());

        kocka = new Cube(assetManager, "20", Util.cubeMap2);
        kocka.getNode().setLocalTranslation(1, 1, 6);
        cubes.add(kocka);
        masterGameNode.attachChild(kocka.getNode());
    }

    private void nextWord() {

        for (Cube c : cubes) {
            masterGameNode.detachChild(c.getNode());

        }
        cubes.clear();
        resetCubes();
        winWord = WordDb.convertForScreen(WordDb.getRandomWord());
        hudTaskText.setText(winWord);

    }
}
