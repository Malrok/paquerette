package com.mrk.bubbles.Components;

import android.graphics.Bitmap;

import com.mrk.entitysystem.interfaces.Component;
import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.components.Texture;

public class TextureComponent implements Component {

	private static final long serialVersionUID = -1819869086279505436L;
	
	public Texture texture;
	
	public TextureComponent(Bitmap bitmap) {
		texture = new Texture(bitmap, MRKOGL.gl10);
	}
}
