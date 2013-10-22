package com.mrk.bubbles;

import com.mrk.framework.activities.MRKOGLActivity;


public class DisplayActivity extends MRKOGLActivity {

	private GameWorld world;
	
	@Override
	public void create() {
		world = new GameWorld();
		world.init(this);
	}
	
	@Override
	public void drawFrame() {
		world.processOneGameTick(0);
	}
}