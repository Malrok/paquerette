package com.mrk.oglext.helpers;

import javax.microedition.khronos.opengles.GL10;

import com.mrk.oglext.components.Dimension;
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
	public static void drawTexture(GL10 gl, Texture texture, Dimension dimension, float x, float y, float z, float rx, float ry, float rz) {
//		// Counter-clockwise winding.
//		gl.glFrontFace(GL10.GL_CCW);
//		// Enable face culling.
//		gl.glEnable(GL10.GL_CULL_FACE);
//		// What faces to remove with the face culling.
//		gl.glCullFace(GL10.GL_BACK);
//		// Enabled the vertices buffer for writing and to be used during
//		// rendering.
//		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//		
//		// Specifies the location and data format of an array of vertex
//		// coordinates to use when rendering.
//		MRKOGL.getInstance().gl.glVertexPointer(3, GL10.GL_FLOAT, 0, texture.getVerticesBuffer());
//		// Set flat color
//		MRKOGL.getInstance().gl.glColor4f(texture.r(), texture.g(), texture.b(), texture.a());
//		// Smooth color
//		if (texture.getColorBuffer() != null) {
//			// Enable the color array buffer to be used during rendering.
//			MRKOGL.getInstance().gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//			MRKOGL.getInstance().gl.glColorPointer(4, GL10.GL_FLOAT, 0, texture.getColorBuffer());
//		}
//
////				if (mShouldLoadTexture) {
////					loadGLTexture(gl);
////					mShouldLoadTexture = false;
////				}
////				if (mTextureId != -1 && mTextureBuffer != null) {
//		if (texture.mShouldLoadTexture) texture.loadGLTexture(MRKOGL.getInstance().gl);
//		
//		if (texture.getTextureId() != -1 && texture.getTextureBuffer() != null) {
//			Log.d("GraphicsHelper.drawTexture", "has texture");
//			
//			MRKOGL.getInstance().gl.glEnable(GL10.GL_TEXTURE_2D);
//			// Enable the texture state
//			MRKOGL.getInstance().gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
//
//			// Point to our buffers
//			MRKOGL.getInstance().gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texture.getTextureBuffer());
////					MRKOGL.gl10.glBindTexture(GL10.GL_TEXTURE_2D, mTextureId);
//			MRKOGL.getInstance().gl.glBindTexture(GL10.GL_TEXTURE_2D, texture.getTextureId());
//		}
//
//		MRKOGL.getInstance().gl.glLoadIdentity();
//		
//		MRKOGL.getInstance().gl.glTranslatef(x, y, z);
//		MRKOGL.getInstance().gl.glRotatef(rx, 1, 0, 0);
//		MRKOGL.getInstance().gl.glRotatef(ry, 0, 1, 0);
//		MRKOGL.getInstance().gl.glRotatef(rz, 0, 0, 1);
//
//		// Point out the where the color buffer is.
//		MRKOGL.getInstance().gl.glDrawElements(GL10.GL_TRIANGLES, texture.getNumOfIndices(),
//				GL10.GL_UNSIGNED_SHORT, texture.getIndicesBuffer());
//		// Disable the vertices buffer.
//		MRKOGL.getInstance().gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//
////				if (mTextureId != -1 && mTextureBuffer != null) {
//		if (texture.getTextureId() != -1 && texture.getTextureBuffer() != null) {
//			MRKOGL.getInstance().gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
//		}
//
//		// Disable face culling.
//		MRKOGL.getInstance().gl.glDisable(GL10.GL_CULL_FACE);
		
		// Point to our buffers
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		
		// Set the face rotation
		gl.glFrontFace(GL10.GL_CW);
		
		// Point to our vertex buffer
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, dimension.getVertexBuffer());
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texture.getTextureBuffer());
		
		// bind the previously generated texture
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture.getTexturePointer());

		gl.glLoadIdentity();
		
		gl.glTranslatef(x, y, z);
		gl.glRotatef(rx, 1, 0, 0);
		gl.glRotatef(ry, 0, 1, 0);
		gl.glRotatef(rz, 0, 0, 1);
		
		// Draw the vertices as triangle strip
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, dimension.getVertices().length / 3);

		//Disable the client state before leaving
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}
}
