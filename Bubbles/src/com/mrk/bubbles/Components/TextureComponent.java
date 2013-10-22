package com.mrk.bubbles.Components;

import android.graphics.Bitmap;

import com.mrk.entitysystem.interfaces.Component;
import com.mrk.oglext.MRKOGL;

public class TextureComponent implements Component {

	private static final long serialVersionUID = -1819869086279505436L;
	
	public int texture;
	
	public TextureComponent(Bitmap bitmap) {
		texture = MRKOGL.graphics.loadTexture(bitmap);
	}
}
