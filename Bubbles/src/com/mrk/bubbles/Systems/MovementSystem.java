package com.mrk.bubbles.Systems;

import java.util.UUID;

import com.mrk.bubbles.Components.PositionComponent;
import com.mrk.bubbles.Components.SpeedComponent;
import com.mrk.entitysystem.interfaces.SubSystem;
import com.mrk.entitysystem.metas.MetaEntity;

public class MovementSystem extends SubSystem {

	private MetaEntity meta;
	
	@Override
	public void processOneGameTick(long lastFrameTime) {
		for (UUID entity : entityManager.getAllEntitiesPossessingComponent(SpeedComponent.class)) {
			meta = MetaEntity.loadFromEntityManager(entity);
			if (meta.has(PositionComponent.class)) {
				meta.get(PositionComponent.class).x += meta.get(SpeedComponent.class).speedx * lastFrameTime / 1000;
				meta.get(PositionComponent.class).y += meta.get(SpeedComponent.class).speedy * lastFrameTime / 1000;
			}
		}
	}

	@Override
	public String getSimpleName() {
		return "MovementSystem";
	}

}
