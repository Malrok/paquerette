package com.mrk.oglext.tools;

import android.os.Handler;
import android.os.Message;

public class GameTick extends Handler {
	
	private int delayMillis;
	private boolean paused = false;
	
	public GameTick(int refresh) {
		delayMillis = refresh;
	}
	
	@Override
	public void handleMessage(Message msg) {
		doOnTick();
		if (!paused) sendMessageDelayed(obtainMessage(0), delayMillis);
	}
	
	public void pause() {
		paused = true;
	}
	
	public void resume() {
		paused = false;
		sendMessageDelayed(obtainMessage(0), delayMillis);
	}
	
	protected void doOnTick() {};
}
