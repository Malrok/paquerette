package com.mrk.oglext.components;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.Bitmap;
import android.opengl.GLUtils;

public class Texture {
//	private FloatBuffer vertexBuffer;	// buffer holding the vertices
//	
//	private float vertices[] = {
//			-1.0f, -1.0f,  0.0f,		// V1 - bottom left
//			-1.0f,  1.0f,  0.0f,		// V2 - top left
//			 1.0f, -1.0f,  0.0f,		// V3 - bottom right
//			 1.0f,  1.0f,  0.0f			// V4 - top right
//	};
	
	private FloatBuffer textureBuffer;	// buffer holding the texture coordinates
	private float texture[] = {    		
			// Mapping coordinates for the vertices
			0.0f, 1.0f,		// top left		(V2)
			0.0f, 0.0f,		// bottom left	(V1)
			1.0f, 1.0f,		// top right	(V4)
			1.0f, 0.0f		// bottom right	(V3)
	};
	
	/** The texture pointer */
	private int texturePointer = -1;

	public Texture(GL10 gl, Bitmap bitmap) {
//		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4); 
//		byteBuffer.order(ByteOrder.nativeOrder());
//		vertexBuffer = byteBuffer.asFloatBuffer();
//		vertexBuffer.put(vertices);
//		vertexBuffer.position(0);

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(texture.length * 4);
		byteBuffer.order(ByteOrder.nativeOrder());
		textureBuffer = byteBuffer.asFloatBuffer();
		textureBuffer.put(texture);
		textureBuffer.position(0);
		
		loadGLTexture(gl, bitmap);
	}
	
	public void loadGLTexture(GL10 gl, Bitmap bitmap) {
		// generate one texture pointer
		int[] textures = new int[1];
		gl.glGenTextures(1, textures, 0);
		texturePointer = textures[0];
		
		// ...and bind it to our array
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texturePointer);
		
		// create nearest filtered texture
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
		
		// Use Android GLUtils to specify a two-dimensional texture image from our bitmap 
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
		
		// Clean up
		bitmap.recycle();
	}	
	
	public int getTexturePointer() {
		return texturePointer;
	}
	
//	public FloatBuffer getVertexBuffer() {
//		return vertexBuffer;
//	}
	
	public FloatBuffer getTextureBuffer() {
		return textureBuffer;
	}
	
//	public float[] getVertices() {
//		return vertices;
//	}
}
