package com.mrk.oglext.components;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.Bitmap;
import android.opengl.GLUtils;

public class Texture {
	// Our vertex buffer.
	private FloatBuffer verticesBuffer = null;

	// Our index buffer.
	private ShortBuffer indicesBuffer = null;

	// The number of indices.
	private int numOfIndices = -1;

	// Flat Color
	private float[] rgba = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };

	// Smooth Colors
	private FloatBuffer colorBuffer = null;

	// Our UV texture buffer.
	private FloatBuffer mTextureBuffer;

	// Our texture id.
	private int mTextureId = -1; // New variable.

	// The bitmap we want to load as a texture.
	private Bitmap mBitmap;
	
	// Indicates if we need to load the texture.
	public boolean mShouldLoadTexture = true;
	
	
	public Texture(Bitmap bitmap, GL10 gl) {
		mBitmap = bitmap;
		setDimensions(1f, 1f);
	}
	
	public void setDimensions(float width, float height) {
    	float w = width / 2;
    	float h = height / 2;
		float textureCoordinates[] = { 
									   0.0f, 1.0f,
									   1.0f, 1.0f,
									   0.0f, 0.0f,
									   1.0f, 0.0f,
									 };

		short[] indices = new short[] { 0, 1, 2, 1, 3, 2 };

		float[] vertices = new float[] { 
										-w, -h, 0,
										 w, -h, 0,
										-w,  h, 0,
										 w,  h, 0
									   };

		setIndices(indices);
		setVertices(vertices);
		setTextureCoordinates(textureCoordinates);
    }
	
	/**
	 * Loads the texture.
	 *
	 * @param gl
	 */
	public void loadGLTexture(GL10 gl) {
		// Generate one texture pointer...
		int[] textures = new int[1];
		gl.glGenTextures(1, textures, 0);
		mTextureId = textures[0];
	 
		// ...and bind it to our array
		gl.glBindTexture(GL10.GL_TEXTURE_2D, mTextureId);
	 
		// Create Nearest Filtered Texture
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_LINEAR);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_LINEAR);
	 
		// Different possible texture parameters, e.g. GL10.GL_CLAMP_TO_EDGE
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S,
				GL10.GL_CLAMP_TO_EDGE);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T,
				GL10.GL_REPEAT);
	 
		// Use the Android GLUtils to specify a two-dimensional texture image
		// from our bitmap
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, mBitmap, 0);
		
		mShouldLoadTexture = false;
	}
	
	public int getTextureId() {
		return mTextureId;
	}
	
	public FloatBuffer getColorBuffer() {
		return colorBuffer;
	}
	
	public float r() {
		return rgba[0];
	}
	
	public float g() {
		return rgba[1];
	}
	
	public float b() {
		return rgba[2];
	}
	
	public float a() {
		return rgba[3];
	}

	public FloatBuffer getVerticesBuffer() {
		return verticesBuffer;
	}
	
	public FloatBuffer getTextureBuffer() {
		return mTextureBuffer;
	}
	
	public int getNumOfIndices() {
		return numOfIndices;
	}
	
	public ShortBuffer getIndicesBuffer() {
		return indicesBuffer;
	}
	
	protected void setVertices(float[] vertices) {
		// a float is 4 bytes, therefore we multiply the number if
		// vertices with 4.
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		verticesBuffer = vbb.asFloatBuffer();
		verticesBuffer.put(vertices);
		verticesBuffer.position(0);
	}

	protected void setIndices(short[] indices) {
		// short is 2 bytes, therefore we multiply the number if
		// vertices with 2.
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indicesBuffer = ibb.asShortBuffer();
		indicesBuffer.put(indices);
		indicesBuffer.position(0);
		numOfIndices = indices.length;
	}

	protected void setColor(float red, float green, float blue, float alpha) {
		// Setting the flat color.
		rgba[0] = red;
		rgba[1] = green;
		rgba[2] = blue;
		rgba[3] = alpha;
	}

	protected void setColors(float[] colors) {
		// float has 4 bytes.
		ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
		cbb.order(ByteOrder.nativeOrder());
		colorBuffer = cbb.asFloatBuffer();
		colorBuffer.put(colors);
		colorBuffer.position(0);
	}
	
	protected void setTextureCoordinates(float[] textureCoords) {
		// float is 4 bytes, therefore we multiply the number if
		// vertices with 4.
		ByteBuffer byteBuf = ByteBuffer.allocateDirect(
	                                           textureCoords.length * 4);
		byteBuf.order(ByteOrder.nativeOrder());
		mTextureBuffer = byteBuf.asFloatBuffer();
		mTextureBuffer.put(textureCoords);
		mTextureBuffer.position(0);
	}
	
//	public void loadBitmap(Bitmap bitmap) {
//		this.mBitmap = bitmap;
//		mShouldLoadTexture = true;
//	}
}
