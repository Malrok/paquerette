package com.mrk.entitysystem.interfaces;

import com.mrk.entitysystem.EntityManager;


public abstract class SubSystem {
	public static EntityManager entityManager;
	
	public abstract void processOneGameTick(long lastFrameTime);

	/**
	 * Mostly used for debugging - check which system is firing, what order
	 * systems are firing in, etc
	 * 
	 * @return the human-readable name of this system
	 */
	public abstract String getSimpleName();
}