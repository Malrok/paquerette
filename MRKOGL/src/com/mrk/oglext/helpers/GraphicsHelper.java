package com.mrk.oglext.helpers;

import javax.microedition.khronos.opengles.GL10;

import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.components.Texture;

public class GraphicsHelper {
	
	/**
	 * Draws a texture at specified position, with given rotation
	 * @param {@link Texture}
	 * @param x - posx
	 * @param y - posy
	 * @param z - poz
	 * @param rx - rotatex
	 * @param ry - rotatey
	 * @param rz - rotatez
	 */
	public static void drawTexture(Texture texture, float x, float y, float z, float rx, float ry, float rz) {
		init();
		
		// Specifies the location and data format of an array of vertex
		// coordinates to use when rendering.
		MRKOGL.gl10.glVertexPointer(3, GL10.GL_FLOAT, 0, texture.getVerticesBuffer());
		// Set flat color
		MRKOGL.gl10.glColor4f(texture.r(), texture.g(), texture.b(), texture.a());
		// Smooth color
		if (texture.getColorBuffer() != null) {
			// Enable the color array buffer to be used during rendering.
			MRKOGL.gl10.glEnableClientState(GL10.GL_COLOR_ARRAY);
			MRKOGL.gl10.glColorPointer(4, GL10.GL_FLOAT, 0, texture.getColorBuffer());
		}

//				if (mShouldLoadTexture) {
//					loadGLTexture(gl);
//					mShouldLoadTexture = false;
//				}
//				if (mTextureId != -1 && mTextureBuffer != null) {
		if (texture.getTextureId() != -1 && texture.getTextureBuffer() != null) {
			MRKOGL.gl10.glEnable(GL10.GL_TEXTURE_2D);
			// Enable the texture state
			MRKOGL.gl10.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

			// Point to our buffers
			MRKOGL.gl10.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texture.getTextureBuffer());
//					MRKOGL.gl10.glBindTexture(GL10.GL_TEXTURE_2D, mTextureId);
			MRKOGL.gl10.glBindTexture(GL10.GL_TEXTURE_2D, texture.getTextureId());
		}

		MRKOGL.gl10.glLoadIdentity();
		
		MRKOGL.gl10.glTranslatef(x, y, z);
		MRKOGL.gl10.glRotatef(rx, 1, 0, 0);
		MRKOGL.gl10.glRotatef(ry, 0, 1, 0);
		MRKOGL.gl10.glRotatef(rz, 0, 0, 1);

		// Point out the where the color buffer is.
		MRKOGL.gl10.glDrawElements(GL10.GL_TRIANGLES, texture.getNumOfIndices(),
				GL10.GL_UNSIGNED_SHORT, texture.getIndicesBuffer());
		// Disable the vertices buffer.
		MRKOGL.gl10.glDisableClientState(GL10.GL_VERTEX_ARRAY);

//				if (mTextureId != -1 && mTextureBuffer != null) {
		if (texture.getTextureId() != -1 && texture.getTextureBuffer() != null) {
			MRKOGL.gl10.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		}

		// Disable face culling.
		MRKOGL.gl10.glDisable(GL10.GL_CULL_FACE);
	}
	
	private static void init() {
		// Counter-clockwise winding.
		MRKOGL.gl10.glFrontFace(GL10.GL_CCW);
		// Enable face culling.
		MRKOGL.gl10.glEnable(GL10.GL_CULL_FACE);
		// What faces to remove with the face culling.
		MRKOGL.gl10.glCullFace(GL10.GL_BACK);
		// Enabled the vertices buffer for writing and to be used during
		// rendering.
		MRKOGL.gl10.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	}
}