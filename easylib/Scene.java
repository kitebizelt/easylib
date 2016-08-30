package easylib;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AHMAD F on 8/27/2016.
 */
public class Scene {
    SpriteBatch sb = new SpriteBatch();
    //Object2d obj;
    public List<Object2d> objlist = new ArrayList<Object2d>();
    //Object2d a = objlist.get(0);
    ShaderProgram sp;
    boolean bsp = false;
    public float gravity = 9.8f;
    public float maxGravitySpeed = 9.8f;
    public void begin(){
        sb.begin();
    }
    public void add(Object2d a){
        if(!this.objlist.contains(a)) {
            this.objlist.add(a);
        }
        //a.scn = this;
    }
    public void remove(Object2d a){
        if(this.objlist.contains(a)) {
            this.objlist.remove(a);
        }
    }
    public void update(){
        String vertexShader = Gdx.files.internal("vertex.glsl").readString();
        String fragmentShader = Gdx.files.internal("fragment.glsl").readString();
        ShaderProgram shaderProgram = new ShaderProgram(vertexShader,fragmentShader);
        float dt = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        if(bsp){
            sb.setShader(this.sp);
        }
        for(Object2d a : objlist) {
            if(a.gravity) {
                a.gVelocity = a.gVelocity + this.gravity * dt*a.mass / 2.0f;
                a.gPosition = a.gPosition + a.gVelocity * dt * (this.getHeight())/100f;
                //Gdx.app.log("Scene",a.velocity+""+a.y);
            }
            if(a.isBounds) {
                for (Object2d b : objlist) {
                    if (b != a && a.getBounds().overlaps(b.getBounds())) {
                        if(a.mass != 0) {
                            a.gPosition = 0;
                            //a.velocity = -50f;
                        }
                    }
                }
            }
            //Gdx.app.log("force",a.force.isZero()+"");
            if(a.force.y != 0){
                a.y = (a.y + a.force.y);// * dt / dt;
                a.force.y /= 2f;
            }
            a.y = a.y - a.gPosition;
            if(a.isBounds)
                a.bounds.setPosition(a.x,a.y);
            if(a.isHitBox)
                a.hitBox.setPosition(a.x,a.y);
            //if(a.hitBox.y < 11){
            //    sb.draw(a.texture(),a.x,a.y+a.position,a.w,a.h);
            //}// else {
            //    sb.draw(a.texture(),a.x,a.y,a.w,a.h);
            //}

            //Gdx.app.log("hitbox",(a.x+a.position)+"");
            sb.draw(a.texture(),a.x,a.y,a.w,a.h);
        }
        sb.setShader(shaderProgram);
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
    public void setGravity(float a){
        this.gravity = a;
    }
    public void setShader(String vertexLink, String pixelLink){
        //String vertexShader = Gdx.files.internal(vertexLink);
        //String fragmentShader = Gdx.files.internal(pixelLink);
        //Gdx.app.log("a",vertexShader);
        this.sp = new ShaderProgram(Gdx.files.internal(vertexLink),Gdx.files.internal(pixelLink));
        this.bsp = true;
    }

    public static float clamp(float val, float min, float max) {
        return Math.max(min, Math.min(max, val));
    }
}
