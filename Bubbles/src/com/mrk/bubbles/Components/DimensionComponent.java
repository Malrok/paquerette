package com.mrk.bubbles.Components;

import com.mrk.entitysystem.interfaces.Component;
import com.mrk.oglext.components.Dimension;

public class DimensionComponent implements Component {

	private static final long serialVersionUID = -4749503983075038940L;

	public Dimension dimension;
	
	public DimensionComponent(float width, float height) {
		dimension = new Dimension(width, height);
	}
}
