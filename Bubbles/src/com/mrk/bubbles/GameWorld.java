package com.mrk.bubbles;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.mrk.bubbles.Components.DimensionComponent;
import com.mrk.bubbles.Components.PositionComponent;
import com.mrk.bubbles.Components.SpeedComponent;
import com.mrk.bubbles.Components.TextureComponent;
import com.mrk.bubbles.Systems.MovementSystem;
import com.mrk.bubbles.Systems.RenderingSystem;
import com.mrk.entitysystem.World;
import com.mrk.entitysystem.metas.MetaEntity;

public class GameWorld extends World {
	
	public void init(Context context) {
		/* add systems */
		addSystem(new RenderingSystem());
		addSystem(new MovementSystem());
		
		/* init MetaEntity */
		MetaEntity.defaultEntityManager = entityManager;
		
		/* add entities */
		MetaEntity entity1 = new MetaEntity();
		entity1.add(new PositionComponent(-1,0));
		entity1.add(new TextureComponent(BitmapFactory.decodeResource(context.getResources(), R.drawable.ship)));
		entity1.add(new DimensionComponent(1,1));
		entity1.add(new SpeedComponent(.5f,0));
		
		entity1 = new MetaEntity();
		entity1.add(new PositionComponent(1,0));
		entity1.add(new TextureComponent(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy)));
		entity1.add(new DimensionComponent(2,2));
	}
	
}
