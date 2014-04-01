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
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kruno
 */
public class Ground {

    private static final Logger logger = Logger.getLogger(Ground.class.getName());
    private Spatial spatial;
    private Vector3f colidePosition = null;
    private Node node;
    public Ground(AssetManager assetManager) {
         node = new Node("GROUND");
        spatial = assetManager.loadModel("Models/tepih/tepih.mesh.j3o");
       // spatial.setShadowMode(RenderQueue.ShadowMode.Receive);
 Material mat = assetManager.loadMaterial("Materials/tepih.j3m");
   TextureKey mainTexture = new TextureKey("Textures/tepih/ground1.png", false);
           mat.setTexture("DiffuseMap", assetManager.loadTexture(mainTexture));
 
        spatial.setMaterial(mat);
//        
//          Material mat2 = new Material(assetManager,
//                "Common/MatDefs/Misc/Unshaded.j3md");
//        mat2.setColor("Color", ColorRGBA.Blue);
//          spatial.setMaterial(mat2);
        spatial.scale(25);
        spatial.setName("tepih");
        node.attachChild(spatial);
        Vector3f center = spatial.localToWorld(Vector3f.ZERO, null);
        Vector3f worldYaxis = center.add(Vector3f.UNIT_Y);
        Vector3f localYAxis = spatial.worldToLocal(worldYaxis, null);
        Quaternion quaternion = new Quaternion();

        spatial.rotate(quaternion.fromAngleAxis((float) Math.toRadians(-90),
                localYAxis));
        spatial.setLocalTranslation(10, 0, 0);
    }

    public Vector3f getColidePosition() {
        return colidePosition;
    }

    public boolean colide(Ray ray) {
        CollisionResults results = new CollisionResults();
        spatial.collideWith(ray, results);


        if (results.size() > 0) {
            colidePosition = results.getClosestCollision().getContactPoint();
            logger.log(Level.FINE, "CLOIDE POSITION "+colidePosition);
            return true;

        } else {
            colidePosition = null;
            return false;
        }
    }

    public Node getNode() {
        return node;
    }
    
    
   
}
