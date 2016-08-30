package easylib;

/**
 * Created by ahmadf on 8/30/16.
 */
public class Render {
    Scene scene;
    public void setScene(Scene scn){
        this.scene = scn;
    }
    public void update(){
        this.scene.update();
    }
}
