package com.mrk.oglext.components;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Dimension {

	private FloatBuffer vertexBuffer;	// buffer holding the vertices
	
	private float[] vertices;
	
	public Dimension(float width, float height) {
		vertices = new float[]{
				-width / 2, -height / 2,  0.0f,		// V1 - bottom left
				-width / 2,  height / 2,  0.0f,		// V2 - top left
				 width / 2, -height / 2,  0.0f,		// V3 - bottom right
				 width / 2,  height / 2,  0.0f		// V4 - top right
		};
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4); 
		byteBuffer.order(ByteOrder.nativeOrder());
		vertexBuffer = byteBuffer.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
	}

	public FloatBuffer getVertexBuffer() {
		return vertexBuffer;
	}

	public float[] getVertices() {
		return vertices;
	}
}
