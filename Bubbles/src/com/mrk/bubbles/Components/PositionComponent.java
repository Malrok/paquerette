package com.mrk.bubbles.Components;

import com.mrk.entitysystem.interfaces.Component;

public class PositionComponent implements Component {

	private static final long serialVersionUID = 8178121999939885686L;

	public float x, y;
	
	public PositionComponent(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
