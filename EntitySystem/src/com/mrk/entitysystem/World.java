package com.mrk.entitysystem;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.mrk.entitysystem.interfaces.SubSystem;

public class World {

	private List<SubSystem> systems;
	protected EntityManager entityManager;
	
	public World() {
		systems = new ArrayList<SubSystem>();
		entityManager = new EntityManager();
	}
	
	public <T extends SubSystem> void addSystem(T system) {
		synchronized (systems) {
			Log.d("World.addSystem", "adding system " + system.getSimpleName());
			if (SubSystem.entityManager == null) SubSystem.entityManager = entityManager;
			systems.add(system);
		}
	}
	
	public void processOneGameTick(long lastFrameTime) {
		synchronized (systems) {
			for (SubSystem system : systems) {
				Log.d("World.processOneGameTick", "one game tick on system " + system.getSimpleName());
				system.processOneGameTick(lastFrameTime);
			}
		}
	}
	
	protected void init() {};
}
