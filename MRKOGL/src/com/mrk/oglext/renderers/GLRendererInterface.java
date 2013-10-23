package com.mrk.oglext.renderers;

import javax.microedition.khronos.opengles.GL10;

public interface GLRendererInterface {

	public void createGL(GL10 gl);
	
	public void render(GL10 gl);
	
}
