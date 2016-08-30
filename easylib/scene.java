package easylib;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AHMAD F on 8/27/2016.
 */
public class scene {
    SpriteBatch sb = new SpriteBatch();
    object2d obj = new object2d();
    List<object2d> objlist = new ArrayList<object2d>();
    ShaderProgram sp;
    boolean bsp = false;
    public void begin(){
        sb.begin();
    }
    public void add(object2d a){
        if(!this.objlist.contains(a)) {
            this.objlist.add(a);
        }
    }
    public void remove(object2d a){
        if(this.objlist.contains(a)) {
            this.objlist.remove(a);
        }
    }
    public void update(){
        float dt = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        if(bsp){
            sb.setShader(this.sp);
        }
        for(object2d a : objlist) {
            /*if(a.isBounds) {
                for (object2d b : objlist) {
                    if (b != a && a.getBounds().overlaps(b.getBounds())) {

                    }
                }
            }*/
            if(a.gravity) {
                a.velocity = a.velocity + 9.8f * dt / 2.0f;
                a.position = a.position + a.velocity * dt * (this.getHeight()/4)*a.mass;
            }
            a.bounds.setPosition(a.x,a.y);
            sb.draw(a.texture(),a.x,a.y-(float)a.position,a.w,a.h);
        }
        sb.end();
    }
    public void end(){
        sb.end();
    }
    public void dispose(){
        sb.dispose();
    }
    public float getWidth(){
        return Gdx.graphics.getWidth();
    }
    public float getHeight(){
        return Gdx.graphics.getHeight();
    }
    public void setShader(String vertexLink, String pixelLink){
        //String vertexShader = Gdx.files.internal(vertexLink);
        //String fragmentShader = Gdx.files.internal(pixelLink);
        //Gdx.app.log("a",vertexShader);
        this.sp = new ShaderProgram(Gdx.files.internal(vertexLink),Gdx.files.internal(pixelLink));
        this.bsp = true;
    }
}
