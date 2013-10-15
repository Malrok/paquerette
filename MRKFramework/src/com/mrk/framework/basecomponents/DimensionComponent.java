package com.mrk.framework.basecomponents;

import com.mrk.entitysystem.interfaces.Component;

public class DimensionComponent implements Component {

	private static final long serialVersionUID = -4749503983075038940L;

	public float width;
	public float height;
	
	public DimensionComponent(float width, float height) {
		this.width = width;
		this.height = height;
	}
}
