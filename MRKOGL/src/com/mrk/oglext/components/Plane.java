package com.mrk.oglext.components;


public class Plane extends Mesh {

    public Plane() {
    	this(1, 1);
    }
 
    public Plane(float width, float height) {
    	setDimensions(width, height);
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
}