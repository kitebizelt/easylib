package easylib;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.reflect.Method;
import com.sun.org.apache.xpath.internal.functions.Function;

/**
 * Created by AHMAD F on 8/27/2016.
 */
public class Object2d {
    private Texture tex;
    private Vector2 xy = new Vector2(0,0);
    private Vector2 wh = new Vector2(0,0);
    public float x = 0;
    public float y = 0;
    public float w = 0;
    public float h = 0;
    protected Rectangle bounds = new Rectangle();
    public boolean isBounds = false;
    protected boolean gravity = false;
    public float gVelocity = 0f;
    public float gPosition = 0f;
    protected float mass = 0f;

    event ev = new event();
    //Class noparams[] = {};
    public Rectangle hitBox;
    public boolean isHitBox;
    public Vector2 force = new Vector2(0f,0f);

    //Scene scn;

    //Texture
    public void setTexture(Texture a){
        //g = scn.objlist.get(scn.objlist.indexOf(a));
        this.tex = a;
        this.setWH(a.getWidth(), a.getHeight());
        this.w = a.getWidth();
        this.h = a.getHeight();
    }
    public Texture texture(){
        return this.tex;
    }
    //Scale
    public void setScale(float w, float h){
        this.wh = new Vector2(w,h);
        this.w = w;
        this.h = h;
    }
    public void setWH(float w,float h){
        this.wh = new Vector2(w,h);
        this.w = w;
        this.h = h;
    }
    public void setW(float w){
        this.wh.x = w;
        this.w = w;
    }
    public void setH(float h){
        this.wh.y = h;
        this.h = h;
    }
    public Vector2 wh(){
        return this.wh;
    }
    //Coordinate
    public void setCoordinates(float x,float y){
        this.xy = new Vector2(x,y);
        this.x = x;
        this.y = y;
    }
    public void setXY(float x,float y){
        this.xy = new Vector2(x,y);
        this.x = x;
        this.y = y;
    }
    public Vector2 xy(){
        return this.xy;
    }
    public void setX(float x){
        this.wh.x = x;
        this.x = x;
    }
    public void setY(float y){
        this.wh.y = y;
        this.y = y;
    }
    //Collisions
    public void addCollisionBox(){
        this.bounds = new Rectangle(this.x,this.y,this.w,this.h);
        this.isBounds = true;
    }
    public void addHitBox(){
        this.hitBox = new Rectangle(this.x,this.y,this.w,this.h);
        this.isHitBox = true;
    }
    public void setFallSpeed(float m){
        this.gravity = true;
        this.mass = m;
    }
    public Rectangle getBounds(){
        return this.bounds;
    }

    public void onDowned(String function, Class cls) {
        ev.add(0,cls,function,this);
    }
    public void onUpped(String function,Class cls){
        ev.add(1,cls,function,this);
    }
    public void onDragged(String function,Class cls){
        ev.add(2,cls,function,this);
    }

    public void setForceY(float force, float modificationSensitivity){
        //this.force.y = force;
        this.gPosition = 0;
        this.gVelocity = -0.5f;
    }
}
