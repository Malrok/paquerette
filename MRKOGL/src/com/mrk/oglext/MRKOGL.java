package com.mrk.oglext;

import javax.microedition.khronos.opengles.GL10;

import android.content.Context;

import com.mrk.oglext.tools.GLRenderer;
import com.mrk.oglext.tools.Graphics;

public class MRKOGL {

	private static MRKOGL instance = new MRKOGL();
	
	public GLRenderer renderer;
	public GL10 gl;
	public Graphics graphics = new Graphics();
	
	public static MRKOGL getInstance() {
		return instance;
	}
	
	private MRKOGL() { }
	
	public void init(Context context) {
		renderer = new GLRenderer(context);
	}
}
