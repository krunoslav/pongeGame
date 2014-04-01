/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ponge.cubis;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;

/**
 *
 * @author kruno
 */
public abstract class Component {

    protected AssetManager assetManager = null;
    protected Node rootNode = null;
    protected Main app = null;
    protected InputManager inputManager=null;
    
    private TransitionListener listener;
    
    

    public Component(Main application) {

        this.app = application;
        this.assetManager = app.getAssetManager();
        this.rootNode = app.getRootNode();
        this.inputManager=app.getInputManager();
    }

    public abstract void update(float tpf);

    public abstract void render(RenderManager rm);
    
    
    public abstract void activate();
    
    
    public abstract void deactivate();
    
    public void transition(String transition){
        if(listener!=null){
            listener.transition(transition);
        }
    }

    public TransitionListener getListener() {
        return listener;
    }

    public void setListener(TransitionListener listener) {
        this.listener = listener;
    }
    
    
    
}
