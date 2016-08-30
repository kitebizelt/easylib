package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

import easylib.*;

public class MyGdxGame extends EasylibAdapter {
	Texture img;
	Scene scene;
    //Scene scene1;
	Object2d obj = new Object2d();
    //List<Object2d> objlist = new ArrayList<Object2d>();
	
	@Override
	public void create () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        setupEvents();
		scene = new Scene();
		obj.setTexture(new Texture("badlogic.jpg"));
        //obj.
        obj.addCollisionBox();
        obj.setFallSpeed(5.0f);
        //obj.force.y = 10;
		scene.add(obj);
        scene.setGravity(9.8f);
        render.setScene(scene);
	}

	@Override
	public void render () {
		render.update();
        obj.force.y = 10;
	}

	@Override
	public void dispose () {
		scene.dispose();
		img.dispose();
	}

    @Override
    public void eventDown(int x, int y, int pointer, int button){
        obj.setForceY(10,3);
    }
    @Override
    public void eventUp(int x, int y, int pointer, int button){
        print("Up",x+","+y);
    }
    @Override
    public void eventDrag(int x, int y, int pointer){
        print("Drag",x+","+y);
    }

}
