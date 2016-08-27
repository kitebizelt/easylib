package easylib;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AHMAD F on 8/27/2016.
 */
public class object2d {
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
    protected float velocity = 0f;
    protected float position = 0f;
    protected float mass;

    //Texture
    public void setTexture(Texture a){
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
    public void addMass(float a){
        this.gravity = true;
        this.mass = a;
    }
    public Rectangle getBounds(){
        return this.bounds;
    }
}
