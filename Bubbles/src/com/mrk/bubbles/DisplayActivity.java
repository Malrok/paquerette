package com.mrk.bubbles;

import javax.microedition.khronos.opengles.GL10;

import com.mrk.framework.activities.MRKOGLActivity;
import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.renderers.GLRendererInterface;


public class DisplayActivity extends MRKOGLActivity implements GLRendererInterface {

	private GameWorld world;
	
	@Override
	public void create() {
		world = new GameWorld();
	}
	
	@Override
	public void createGL(GL10 gl) {
		MRKOGL.getInstance().gl = gl;
		
		world.init(this);
	}
	
	@Override
	public void render(GL10 gl) { 
		world.processOneGameTick(0);
	}
}