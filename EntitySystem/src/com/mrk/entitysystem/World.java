package com.mrk.entitysystem;

import java.util.ArrayList;
import java.util.List;

import com.mrk.entitysystem.interfaces.SubSystem;

public class World {

	private List<SubSystem> systems;
	private EntityManager entityManager;
	
	public World() {
		systems = new ArrayList<SubSystem>();
		entityManager = new EntityManager();
	}
	
	public <T extends SubSystem> void addSystem(T system) {
		synchronized (systems) {
			if (SubSystem.entityManager == null) SubSystem.entityManager = entityManager;
			systems.add(system);
		}
	}
	
	public void processOneGameTick(long lastFrameTime) {
		synchronized (systems) {
			for (SubSystem system : systems)
				system.processOneGameTick(lastFrameTime);
		}
	}
	
	protected void init() {};
}
