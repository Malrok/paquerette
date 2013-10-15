package com.mrk.framework.basecomponents;

import android.graphics.Bitmap;

import com.mrk.entitysystem.interfaces.Component;
import com.mrk.oglext.components.Sprite;

public class TextureComponent implements Component {

	private static final long serialVersionUID = -1819869086279505436L;
	
	public Sprite texture;
	
	public TextureComponent(Bitmap bitmap) {
		texture = new Sprite(bitmap);
	}
}
