package com.mrk.bubbles.Components;

import com.mrk.entitysystem.interfaces.Component;

public class SpeedComponent implements Component {

	private static final long serialVersionUID = 7212589528254099863L;

	public float speedx, speedy;
	
	public SpeedComponent(float speedx, float speedy) {
		this.speedx = speedx;
		this.speedy = speedy;
	}
	
}
