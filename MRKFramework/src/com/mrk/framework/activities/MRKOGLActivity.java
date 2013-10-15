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

import com.mrk.framework.R;
import com.mrk.oglext.tools.GameTick;
import com.mrk.oglext.views.GLView;

public class MRKOGLActivity extends Activity implements MRKOGLActivityInterface {

	private GLView glView;
	private GameTick gameTick;
	
	public MRKOGLActivity() {
		create();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* force fullscreen */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.display_activity_layout);
        
        /* create GL View */
        glView = (GLView)findViewById(R.id.glsurface);
        glView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
        	
        });
        
        gameTick = new GameTick(42) { // 25 frames per second
        	
        	@Override
        	public void doOnTick() {
        		drawFrame();
        		glView.requestRender();
        	}
        	
        }; 
        gameTick.sendMessage(new Message());
        
        
	}
	
	@Override
	public void onResume() {
		super.onResume();
		glView.onResume();
	}
	
	@Override 
	public void onPause() {
		super.onPause();
		glView.onPause();
	}

	@Override
	public void create() { };
	
	@Override
	public void drawFrame() { }

	@Override
	public void render(GL10 gl) {
		
	}

}
