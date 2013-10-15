package com.mrk.oglext.tools;

import android.os.Handler;
import android.os.Message;

public class GameTick extends Handler {
	
	private int delayMillis;
	
	public GameTick(int refresh) {
		delayMillis = refresh;
	}
	
	@Override
	public void handleMessage(Message msg) {
		doOnTick();
		sendMessageDelayed(obtainMessage(0), delayMillis);
	}
	
	protected void doOnTick() {};
}
