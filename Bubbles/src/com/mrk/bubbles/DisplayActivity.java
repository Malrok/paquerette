package com.mrk.bubbles;

import javax.microedition.khronos.opengles.GL10;

import com.mrk.framework.activities.MRKOGLActivity;


public class DisplayActivity extends MRKOGLActivity {

	private GameWorld world;
	
	@Override
	public void create() {
		world = new GameWorld();
	}
	
	@Override
	public void drawFrame() {
		world.processOneGameTick(0);
	}
	
	@Override
	public void createGL(GL10 gl) {
		world.init(this);
	}
}