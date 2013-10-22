package com.mrk.bubbles;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.mrk.bubbles.Components.DimensionComponent;
import com.mrk.bubbles.Components.PositionComponent;
import com.mrk.bubbles.Components.TextureComponent;
import com.mrk.bubbles.Systems.RenderingSystem;
import com.mrk.entitysystem.World;
import com.mrk.entitysystem.metas.MetaEntity;

public class GameWorld extends World {
	
	public void init(Context context) {
		/* add systems */
		addSystem(new RenderingSystem());
		
		/* add entities */
		MetaEntity entity1 = new MetaEntity();
		entity1.add(new PositionComponent(0,0));
		entity1.add(new TextureComponent(BitmapFactory.decodeResource(context.getResources(), R.drawable.canardage_lapin)));
		entity1.add(new DimensionComponent(1,1));
	}
	
}
