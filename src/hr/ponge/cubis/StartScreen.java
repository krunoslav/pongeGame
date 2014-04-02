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
import com.jme3.math.Vector2f;
import com.jme3.renderer.RenderManager;
import com.jme3.ui.Picture;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kruno
 */
public class StartScreen extends Component {

    private static final Logger logger = Logger.getLogger(StartScreen.class.getName());
    private boolean active = false;
     private float xHudKoef = 1;
    private float yHudKoef = 1;

    public StartScreen(Main main) {
        super(main);
    }

    @Override
    public void update(float tpf) {
        if (!active) {
            return;
        }
    }

    @Override
    public void render(RenderManager rm) {
        if (!active) {
            return;
        }
    }

    @Override
    public void activate() {
        initKeys();
        setupHUD();
        active = true;
    }

    @Override
    public void deactivate() {
        active = false;
         app.getGuiNode().detachAllChildren();
         rootNode.detachAllChildren();
        relaseKeys();
    }

    private void relaseKeys() {
        // You can map one or several inputs to one named action
        inputManager.deleteMapping("SHOOT_1");
        inputManager.removeListener(actionListener);


    }

    private void initKeys() {
        // You can map one or several inputs to one named action

        inputManager.addMapping("SHOOT_1", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));


        // Add the names to the action listener.
        inputManager.addListener(actionListener, "SHOOT_1");


    }
    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            long now = System.currentTimeMillis();
            // detectGesture(name, keyPressed);

            boolean buttonsPushed = handlePushingButtons();


        }

        private boolean handlePushingButtons() {
            Vector2f click2d = inputManager.getCursorPosition();
            logger.log(Level.FINE, "MOUSE CORDS PUSH " + click2d);
            float norm_x = click2d.x * xHudKoef;
            float norm_y = click2d.y * yHudKoef;
           
            if (norm_x >= 243 && norm_x <= 396
                    && norm_y >= 172 && norm_y <= 207) {
                
                transition("START_GAME");
            }
                if (norm_x >= 268 && norm_x <= 370
                    && norm_y >= 100 && norm_y <= 134) {
                
                transition("EXIT");
            }

            return false;

        }
    };
    
    
      private void setupHUD() {

        Picture pic = new Picture("HUD Picture");
        pic.setImage(assetManager, "Textures/hud/start_screen.png", true);
        pic.setWidth(app.getSettings().getWidth());
        pic.setHeight(app.getSettings().getHeight());
        pic.setPosition(0, 0);
        app.getGuiNode().attachChild(pic);
        xHudKoef = 640f / (float) app.getSettings().getWidth();
        yHudKoef = 480f / (float) app.getSettings().getHeight();
       
//         BitmapFont font=  assetManager.loadFont("Interface/Fonts/Default.fnt");
//        
//        BitmapText hudText = new BitmapText(font, false);
//        hudText.setSize(font.getCharSet().getRenderedSize());      // font size
//        hudText.setColor(ColorRGBA.Black);                             // font color
//        hudText.setText("AB");    
//        
//        hudText.setLocalTranslation((app.getSettings().getWidth() / 2) - (hudText.getLineWidth() / 2), app.getSettings().getHeight() * 0.979166667f, 0); // position
//        app.getGuiNode().attachChild(hudText);

    } 
}
