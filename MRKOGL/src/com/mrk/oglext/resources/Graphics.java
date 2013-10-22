package com.mrk.oglext.resources;

import android.graphics.Bitmap;
import android.util.SparseArray;

import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.components.Texture;

public class Graphics {

	private static SparseArray<Texture> textures = new SparseArray<Texture>();
	
	private static short rank = 0;
	
	public int loadTexture(Bitmap bitmap) {
		int newKey = getNewKey();
		textures.append(newKey, new Texture(bitmap, MRKOGL.getInstance().gl10));
		return newKey;
	}
	
	public Texture getTexture(int key) {
		return textures.get(key);
	}
	
	private int getNewKey() {
		rank++;
		if (rank==255) return 0;
		return rank;
	}
}
