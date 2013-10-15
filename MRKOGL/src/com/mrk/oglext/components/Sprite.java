package com.mrk.oglext.components;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class Sprite extends Plane {
	private float height;
	private float width;
	private RectF rect;
	
	public Sprite() {
		super();
	}
	
	public Sprite(Bitmap bitmap) {
		super();
		setTextureBitmap(bitmap);
	}
	
	public void setTextureBitmap(Bitmap bitmap) {
		super.setDimensions(bitmap.getWidth(), bitmap.getHeight());
		this.height = bitmap.getHeight();
		this.width = bitmap.getWidth();
		loadBitmap(bitmap);
	}
	
	public void setRect() {
		this.rect = new RectF(this.x - this.width / 2,  // left
							  this.y - this.height / 2, // top
							  this.x + this.width / 2,  // right
							  this.y + this.height / 2  // bottom
							  );
	}
	
	public void setPosition(float posx, float posy) {
		this.x = posx;
		this.y = posy;
		
		setRect();
	}
	
	public float getWidth() {
		return this.width;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public RectF getRect() {
		return this.rect;
	}
}
