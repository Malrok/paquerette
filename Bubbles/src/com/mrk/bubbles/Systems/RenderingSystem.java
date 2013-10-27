package com.mrk.bubbles.Systems;

import java.util.UUID;

import com.mrk.bubbles.Components.DimensionComponent;
import com.mrk.bubbles.Components.PositionComponent;
import com.mrk.bubbles.Components.TextureComponent;
import com.mrk.entitysystem.interfaces.SubSystem;
import com.mrk.entitysystem.metas.MetaEntity;
import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.helpers.GraphicsHelper;

public class RenderingSystem extends SubSystem {
	
	private MetaEntity meta;
	
	@Override
	public void processOneGameTick(long lastFrameTime) {
		for (UUID entity : entityManager.getAllEntitiesPossessingComponent(TextureComponent.class)) {
			meta = MetaEntity.loadFromEntityManager(entity);
			if (meta.has(PositionComponent.class) && meta.has(DimensionComponent.class))
				GraphicsHelper.drawTexture(MRKOGL.getInstance().gl, MRKOGL.getInstance().graphics.getTexture(meta.get(TextureComponent.class).texture), meta.get(PositionComponent.class).x, meta.get(PositionComponent.class).y, -4, 0, 0, 0);
		}
	}

	@Override
	public String getSimpleName() {
		return "RenderingSystem";
	}

}
