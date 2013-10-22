package com.mrk.oglext;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;

import com.mrk.oglext.renderers.GLRenderer;
import com.mrk.oglext.resources.Graphics;

public class MRKOGL {

	private static MRKOGL instance = new MRKOGL();
	
	public static GLRenderer renderer;
	public static GL10 gl10;
	public static Graphics graphics;
	
	public static MRKOGL getInstance() {
		return instance;
	}
	
	private MRKOGL() { }
	
	public void init(Context context) {
		renderer = new GLRenderer(context);
	}
}
