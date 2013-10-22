package com.mrk.oglext.resources;

import android.graphics.Bitmap;
import android.util.SparseArray;

public class Graphics {

	private static SparseArray<Bitmap> textures = new SparseArray<Bitmap>();
	
	public static int loadTexture(Bitmap bitmap) {
		int newKey = getNewKey();
		textures.append(newKey, bitmap);
		return newKey;
	}
	
	private static int getNewKey() {
		return 0;
	}
}
