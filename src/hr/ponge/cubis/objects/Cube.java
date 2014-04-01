/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ponge.cubis.objects;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Line;
import com.jme3.texture.Texture;
import hr.ponge.cubis.Constants;
import hr.ponge.cubis.grec.model.GrecMesh;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kruno
 */
public class Cube {

    private static final Logger logger = Logger.getLogger(Cube.class.getName());
    public static final String AXIS_X = "x";
    public static final String AXIS_Y = "y";
    public static final String AXIS_Z = "z";
    private Spatial spatial = null;
    private boolean selected = false;
    private Vector3f transitionToPoint = null;
    private Vector3f finalTransitionPoint = null;
    private Vector3f startPosition = null;
    private float rotationAngleX = 0;
    private float currentRotatAngleX = 0;
    private float rotateSignX = 1;
    private float rotationAngleY = 0;
    private float currentRotatAngleY = 0;
    private float rotateSignY = 1;
    private float rotationAngleZ = 0;
    private float currentRotatAngleZ = 0;
    private float rotateSignZ = 1;
    Vector3f localYAxis = null;
    Vector3f localXAxis = null;
    Vector3f localZAxis = null;
    AssetManager assetManager;
    private String name;
    Material material;
   // private final Texture glowText;
    private int sideUp = 1;
    private boolean letterOK = false;
    private Node node;
    String[] maping = null;

    public Cube(AssetManager assetManager, String name, String[] maping) {
        this.maping = maping;
        Material mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Red);
 
        node = new Node(name);
        this.assetManager = assetManager;
        spatial = assetManager.loadModel("Models/kocka_new/kocka.mesh.j3o");
        material = assetManager.loadMaterial("Materials/kocka.j3m");
        TextureKey mainTexture = new TextureKey("Textures/kocke/" + name + "/kocka.JPG", false);
        //TextureKey normalTexture = new TextureKey("Textures/kocke/" + name + "/kocka_normal.JPG", false);
        material.setTexture("DiffuseMap", assetManager.loadTexture(mainTexture));
        //material.setTexture("NormalMap", assetManager.loadTexture(normalTexture));
//
//        TextureKey glowTk = new TextureKey("Textures/kocke/kocka_bloom.JPG", false);
//        glowText = assetManager.loadTexture(glowTk);

        spatial.setMaterial(material);
      //spatial.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        node.attachChild(spatial);
       
        Vector3f center = node.getWorldTranslation();


        //1 ploha
        Line line = new Line(center.add(-0.95f, 0.95f, 0f), center.add(0.95f, 0.95f, 0f));
        Geometry line1 = new Geometry("l1", line);
        line1.setMaterial(mat2);
        node.attachChild(line1);


        // 2 ploha
        line = new Line(center.add(-0.95f, 0.0f, -0.95f), center.add(0.95f, 0.0f, -0.95f));
        line1 = new Geometry("l2", line);
        line1.setMaterial(mat2);
        node.attachChild(line1);



        // 3 ploha
        line = new Line(center.add(-0.95f, -0.95f, 0f), center.add(0.95f, -0.95f, 0f));
        line1 = new Geometry("l3", line);
        line1.setMaterial(mat2);
        node.attachChild(line1);

        // 4 ploha
        line = new Line(center.add(-0.95f, 0.0f, 0.95f), center.add(0.95f, 0.0f, 0.95f));
        line1 = new Geometry("l4", line);
        line1.setMaterial(mat2);
        node.attachChild(line1);


        // 5 ploha
        line = new Line(center.add(0.95f, 0.95f, 0f), center.add(0.95f, -0.95f, 0f));
        line1 = new Geometry("l5", line);
        line1.setMaterial(mat2);
        node.attachChild(line1);

        // 6 ploha
        line = new Line(center.add(-0.95f, 0.95f, 0f), center.add(-0.95f, -0.95f, 0f));
        line1 = new Geometry("l6", line);
        line1.setMaterial(mat2);
        node.attachChild(line1);



        this.name = name;
    }

    public Node getNode() {
        return node;
    }

    public boolean isSelected() {
        return selected;

    }

    public String getName() {
        return name;

    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void selected() {
        this.selected = true;
        startPosition = node.getWorldTranslation();
        finalTransitionPoint = startPosition.clone();
        finalTransitionPoint.y = 2f;

       // material.setTexture("GlowMap", glowText);
    }

    public void moveTo(Vector3f pos) {
        pos.setY(1f);
        finalTransitionPoint = pos;
        startPosition = node.getWorldTranslation();
        setSelected(false);


      //  material.setTexture("GlowMap", null);
    }

    public void resolveTransitions(float tpf) {


        //handles moving of cube
        if (finalTransitionPoint != null) {
            logger.log(Level.FINE, "FINAL TRANSITION POINT {0}  STEP IS {2}", new Object[]{finalTransitionPoint, Constants.TRANSITION_STEP});
            // interChangeAmt = interChangeAmt + Constants.TRANSITION_STEP;
            transitionToPoint = startPosition.interpolate(finalTransitionPoint, Constants.TRANSITION_STEP);
            Vector3f current = node.getWorldTranslation();
            float dist = current.distance(finalTransitionPoint);
            logger.log(Level.FINE, "Distance from final point {0}", new Object[]{dist});
            if (dist <= Constants.MINIMUM_DISTANCE_APROX) {
                transitionToPoint = finalTransitionPoint;
                logger.log(Level.FINE, "REACHED FINAL TRANSITION POINT");
                finalTransitionPoint = null;
            }

        }
        // handles rotation of cube
        float ang = 150f * tpf;
        if (rotationAngleX != 0) {
            if ((rotationAngleX - ang) < 0) {
                ang = rotationAngleX;
                rotationAngleX = 0;
            } else {
                rotationAngleX = rotationAngleX - ang;
            }
            ang = ang * rotateSignX;
            currentRotatAngleX = ang;
        }

        if (rotationAngleY != 0) {
            if ((rotationAngleY - ang) < 0) {
                ang = rotationAngleY;
                rotationAngleY = 0;
            } else {
                rotationAngleY = rotationAngleY - ang;
            }
            ang = ang * rotateSignY;
            currentRotatAngleY = ang;
        }

        if (rotationAngleZ != 0) {
            if ((rotationAngleZ - ang) < 0) {
                ang = rotationAngleZ;
                rotationAngleZ = 0;
            } else {
                rotationAngleZ = rotationAngleZ - ang;
            }
            ang = ang * rotateSignZ;
            currentRotatAngleZ = ang;
        }

    }

    public boolean updateScene(float tpf) {

        boolean changeHappend = false;
        if (transitionToPoint != null) {
            logger.log(Level.FINE, "CUBE {0} TRANSITION TO POINT {1}", new Object[]{name, transitionToPoint});
            node.setLocalTranslation(transitionToPoint);
            transitionToPoint = null;
            if (finalTransitionPoint == null) {
                changeHappend = true;
            }
        }


        if (currentRotatAngleX != 0) {
            if (rotationAngleX == 0) {
                changeHappend = true;
            }
            Quaternion quaternion = new Quaternion();

            node.rotate(quaternion.fromAngleAxis((float) Math.toRadians(currentRotatAngleX),
                    localXAxis));
            currentRotatAngleX = 0;
        }
        if (currentRotatAngleY != 0) {
            if (rotationAngleY == 0) {
                changeHappend = true;
            }
            Quaternion quaternion = new Quaternion();

            node.rotate(quaternion.fromAngleAxis((float) Math.toRadians(currentRotatAngleY),
                    localYAxis));
            currentRotatAngleY = 0;
        }

        if (currentRotatAngleZ != 0) {
            if (rotationAngleZ == 0) {
                changeHappend = true;
            }
            Quaternion quaternion = new Quaternion();

            node.rotate(quaternion.fromAngleAxis(
                    (float) Math.toRadians(currentRotatAngleZ),
                    localZAxis));
            currentRotatAngleZ = 0;
        }
        return changeHappend;


    }

    public boolean colide(Ray ray) {
        CollisionResults results = new CollisionResults();
        node.collideWith(ray, results);


        if (results.size() > 0) {
            return true;

        }
        return false;
    }

    public void doAction(String command) {

        logger.log(Level.FINE, " DO ACTION COMMAND:{0}", command);



        if (command == null || command.trim().equals("")
                || rotationAngleX != 0
                || rotationAngleY != 0
                || rotationAngleZ != 0) {
            return;
        }
        Vector3f center = node.localToWorld(Vector3f.ZERO, null);

        Vector3f worldYaxis = center.add(Vector3f.UNIT_Y);
        localYAxis = node.worldToLocal(worldYaxis, null);
        Vector3f worldXaxis = center.add(Vector3f.UNIT_X);
        localXAxis = node.worldToLocal(worldXaxis, null);
        Vector3f worldZaxis = center.add(Vector3f.UNIT_Z);
        localZAxis = node.worldToLocal(worldZaxis, null);

        if (command.equals(Constants.RIGHT_MOVE)) {

            rotationAngleX = 90f;
            rotateSignX = 1;
        } else if (command.equals(Constants.LEFT_MOVE)) {

            rotateSignX = -1;
            rotationAngleX = 90f;

        } else if (command.equals(Constants.UP_MOVE)) {

            rotateSignZ = -1;
            rotationAngleZ = 90f;

        } else if (command.equals(Constants.DOWN_MOVE)) {

            rotateSignZ = 1;
            rotationAngleZ = 90f;

        } else if (command.startsWith(Constants.CIRCLE_CCW)) {

            rotateSignY = 1;
            rotationAngleY = 90f;

        } else if (command.startsWith(Constants.CIRCLE_CW)) {
            rotateSignY = -1;
            rotationAngleY = 90f;


        }

    }

    private void updateSide() {

        int planeUp = 0;
        boolean letterOK = false;
        float ySize = 0;

        for (int i = 1; i <= 6; i++) {
            Geometry lg = (Geometry) node.getChild("l" + i);
            Line line = (Line) lg.getMesh();
            Vector3f startW = lg.localToWorld(line.getStart(), null);
            Vector3f endW = lg.localToWorld(line.getEnd(), null);
            float y1 = Math.round(startW.y * 100) / 100;
            float y2 = Math.round(endW.y * 100) / 100;
            logger.log(Level.FINEST, "Y1={0}   Y2={1}", new Object[]{y1, y2});
            if (y1 != y2) {
                continue;
            }
            logger.log(Level.FINEST, "startW.y={0}   YSIZE={1}", new Object[]{startW.y, ySize});
            if (startW.y > ySize) {
                ySize = startW.y;
                planeUp = i;
            }

        }

        logger.log(Level.FINEST, "PLANE UP IS={0}", planeUp);
        if (planeUp == 0) {
            return;
        }

        Geometry lg = (Geometry) node.getChild("l" + planeUp);
        Line line = (Line) lg.getMesh();
        Vector3f startW = lg.localToWorld(line.getStart(), null);
        Vector3f endW = lg.localToWorld(line.getEnd(), null);

        if (startW.x > endW.x) {
            letterOK = true;
        } else {
            letterOK = false;
        }
        this.letterOK = letterOK;
        this.sideUp = planeUp;

        logger.log(Level.FINE, "UP SIDE IS={0}  LETTER OK={1}", new Object[]{planeUp, letterOK});


    }

    public int getSideUp() {
        return sideUp;
    }

    public boolean isLetterOK() {
        return letterOK;
    }

    public String getLetter() {
        if (!letterOK) {
            return "";

        }
        return maping[sideUp-1];
    }

    public Vector3f getWorldLoaction() {
        return node.getWorldTranslation();
    }

    public void changeHappend(float tpf) {
        logger.log(Level.FINE, "CHANGE HAPPEND");
        updateSide();
    }
}
