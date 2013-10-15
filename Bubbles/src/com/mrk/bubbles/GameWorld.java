package com.mrk.bubbles;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.mrk.bubbles.Systems.GraphicsSystem;
import com.mrk.entitysystem.World;
import com.mrk.entitysystem.metas.MetaEntity;
import com.mrk.framework.basecomponents.DimensionComponent;
import com.mrk.framework.basecomponents.PositionComponent;
import com.mrk.framework.basecomponents.RenderableComponent;
import com.mrk.framework.basecomponents.TextureComponent;

public class GameWorld extends World {
	
	public void init(Context context) {
		/* add systems */
		addSystem(new GraphicsSystem());
		
		/* add entities */
		MetaEntity entity1 = new MetaEntity();
		entity1.add(new PositionComponent(0,0));
		entity1.add(new TextureComponent(BitmapFactory.decodeResource(context.getResources(), R.drawable.canardage_lapin)));
		entity1.add(new DimensionComponent(1,1));
		entity1.add(new RenderableComponent(true));
	}
	
}
