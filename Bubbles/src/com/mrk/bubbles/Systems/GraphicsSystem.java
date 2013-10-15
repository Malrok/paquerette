package com.mrk.bubbles.Systems;

import java.util.UUID;

import com.mrk.entitysystem.interfaces.SubSystem;
import com.mrk.framework.basecomponents.TextureComponent;

public class GraphicsSystem extends SubSystem {
	
	@Override
	public void processOneGameTick(long lastFrameTime) {
		for (UUID entity : entityManager.getAllEntitiesPossessingComponent(TextureComponent.class)) {
			
		}
	}

	@Override
	public String getSimpleName() {
		return null;
	}

}
