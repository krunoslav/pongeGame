package hr.ponge.cubis;

import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;

import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;

import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.system.AppSettings;


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Logger log = Logger.getLogger("hr.ponge");
        log.setLevel(Level.FINE);
        ConsoleHandler handler = new ConsoleHandler();

        handler.setLevel(Level.FINE);
        handler.setFormatter(new SimpleFormatter());
        log.addHandler(handler);


        Main app = new Main();
        AppSettings settings = new AppSettings(true);
        settings.setFullscreen(false);
        settings.setWidth(640);
        settings.setHeight(480);
        app.setSettings(settings);
        app.setShowSettings(false);
        app.setDisplayFps(false);
        app.setDisplayStatView(false);
        app.start();


        logger.log(Level.INFO, "AFTER START");


    }
    protected Game game;
    
    protected StartScreen startScreen;

    @Override
    public void simpleInitApp() {
        getStateManager().getState(StatsAppState.class).setDisplayFps(false);
        getStateManager().getState(StatsAppState.class).setDisplayStatView(false);

        rootNode.setShadowMode(RenderQueue.ShadowMode.Off);

        flyCam.setEnabled(false);
        setupCameraAndLight();
        game = new Game(this);
        game.setListener(gameListener);
        startScreen=new StartScreen(this);
        startScreen.setListener(startScreenListener);
        startScreen.activate();
        
       // game.activate();

    }

    @Override
    public void simpleUpdate(float tpf) {
        game.update(tpf);
    }

    @Override
    public void simpleRender(RenderManager rm) {
        game.render(rm);
    }

    private void setupCameraAndLight() {
        // You must add a light to make the model visible

//         /** A white ambient light source. */ 
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White.mult(0.7f));
        rootNode.addLight(ambient);
        getCamera().setLocation(new Vector3f(-20f, 20f, 0f));
        final Vector3f lookAtLocation = new Vector3f(0f, 0f, 0f).normalizeLocal().multLocal(1000);
        getCamera().lookAt(lookAtLocation, Vector3f.UNIT_Y);

        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White.mult(0.5f));
        sun.setDirection(new Vector3f(5f, -3f, -3f).normalizeLocal());
        rootNode.addLight(sun);

        /* this shadow needs a directional light */
        DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(assetManager, 256, 2);

        dlsr.setLight(sun);
        viewPort.addProcessor(dlsr);

//        FilterPostProcessor fpp = new FilterPostProcessor(assetManager);
//        BloomFilter bloom = new BloomFilter(BloomFilter.GlowMode.Objects);
//        fpp.addFilter(bloom);
//        viewPort.addProcessor(fpp);
    }

    public AppSettings getSettings() {
        return settings;
    }
    private TransitionListener gameListener = new TransitionListener() {
        @Override
        public void transition(String transitionInfo) {
            if(transitionInfo!=null && transitionInfo.equals("END_GAME")){
               game.deactivate();
               startScreen.activate();
           }



        }
    };
    
     private TransitionListener startScreenListener = new TransitionListener() {
        @Override
        public void transition(String transitionInfo) {
           if(transitionInfo!=null && transitionInfo.equals("START_GAME")){
               startScreen.deactivate();
               game.activate();
           }
            if(transitionInfo!=null && transitionInfo.equals("EXIT")){
             System.exit(0);
           }


        }
    };
}
