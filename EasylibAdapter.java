package easylib;

/**
 * Created by ahmadf on 8/30/16.
 */

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

import java.util.List;

/** Convenience implementation of {@link ApplicationListener}. Derive from this and only override what you need.
 * @author mzechner */
public abstract class EasylibAdapter implements ApplicationListener {
    //public List<Object2d> objlistG;
    public Render render = new Render();
    @Override
    public void create () {
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void render () {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose () {
    }

    public void setupEvents() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int x, int y, int pointer, int button) {
                eventDown(x,y,pointer,button);
                return true; // return true to indicate the event was handled
            }

            @Override
            public boolean touchUp(int x, int y, int pointer, int button) {
                eventUp(x,y,pointer,button);
                return true; // return true to indicate the event was handled
            }

            @Override
            public boolean touchDragged(int x, int y, int pointer) {
                eventDrag(x,y,pointer);
                return true; // return true to indicate the event was handled
            }
        });
    }

    public void eventDown(int x, int y, int pointer, int button){

    }

    public void eventUp(int x, int y, int pointer, int button){

    }

    public void eventDrag(int x, int y, int pointer){

    }

    public void print(String tag, String msg){
        Gdx.app.log(tag,msg);
    }

    public void print(String msg){
        Gdx.app.log("EasylibAdapter",msg);
    }
}
