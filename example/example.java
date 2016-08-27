package com.mygdx.example;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import easylib.*;

public class example extends ApplicationAdapter {
	scene scene;
	Texture img;
	object2d obj = new object2d();
    event ev = new event();
	
	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
		scene = new scene();
		img = new Texture("badlogic.jpg");
		Gdx.gl.glClearColor(1, 0, 0, 1);

		obj.setTexture(img);
		obj.setXY(0,scene.getHeight()-obj.h);
		obj.addCollisionBox();
		obj.addMass(1.0f);

		scene.add(obj);
        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean touchDown (int x, int y, int pointer, int button) {
                // your touch down code here
                Gdx.app.log("hi","Down");
                return true; // return true to indicate the event was handled
            }

            @Override
            public boolean touchUp (int x, int y, int pointer, int button) {
                // your touch up code here
                Gdx.app.log("hi","Up");
                return true; // return true to indicate the event was handled
            }

            @Override
            public boolean touchDragged  (int x, int y, int pointer) {
                // your touch up code here
                Gdx.app.log("hi","Drag");
                return true; // return true to indicate the event was handled
            }
        });
	}

	@Override
	public void render() {
		scene.update();
	}
	@Override
	public void dispose () {
		scene.dispose();
		img.dispose();
	}
}
