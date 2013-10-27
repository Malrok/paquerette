package com.mrk.framework.activities;

import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.tools.GameTick;
import com.mrk.oglext.views.GLView;

public class MRKOGLActivity extends Activity implements MRKOGLActivityInterface {

	private GLView glView;
	private GameTick gameTick;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* force fullscreen */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* create GL View */
        glView = new GLView(this);
        
        setContentView(glView);
        
        glView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
        	
        });
        
		MRKOGL.getInstance().renderer.setInterface(this);
        
        gameTick = new GameTick(42) { // 25 frames per second
        	
        	@Override
        	public void doOnTick() {
        		glView.requestRender();
        	}
        	
        }; 
        gameTick.sendMessage(new Message());
        
        create();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		glView.onResume();
		gameTick.resume();
	}
	
	@Override 
	public void onPause() {
		super.onPause();
		glView.onPause();
		gameTick.pause();
	}

	@Override
	public void create() { };

	@Override
	public void createGL(GL10 gl) { }
	
	@Override
	public void render(GL10 gl) { }

}
