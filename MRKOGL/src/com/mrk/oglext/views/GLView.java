package com.mrk.oglext.views;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.mrk.oglext.MRKOGL;

public class GLView extends GLSurfaceView {
//    private static final String LOG_TAG = GLView.class.getSimpleName();
//    public GLRenderer renderer;
 
    public float touchX;
    public float touchY;
//    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    
    public GLView(Context context) {
        super(context);
        
//        setGLWrapper(new GLView.GLWrapper()  
//        {  
//        	@Override
//			public GL wrap(GL gl) {
//        		return new MatrixTrackingGL(gl);  
//			}  
//        });
        
//        renderer = new GLRenderer(context);
        MRKOGL.getInstance().init(context);
        setRenderer(MRKOGL.renderer);
        // Render the view only when there is a change
        setRenderMode(GLView.RENDERMODE_WHEN_DIRTY);
    }

    public GLView(Context context, AttributeSet attributes) {
    	super(context, attributes);
//        renderer = new GLRenderer(context);
//        setRenderer(renderer);
    	MRKOGL.getInstance().init(context);
        setRenderer(MRKOGL.renderer);
        // Render the view only when there is a change
        setRenderMode(GLView.RENDERMODE_WHEN_DIRTY);
    }
    
//    public GLRenderer getRenderer() {
//    	return renderer;
//    }
    
//    @Override 
//    public boolean onTouchEvent(MotionEvent event) {
//    	
//    	float[] XY = renderer.GetWorldCoords(new float[]{event.getX(), event.getY()});
//    	
//    	touchX = XY[0];
//    	touchY = XY[1];
//    	
//    	Log.d("GLView.onTouchEvent", "X=" + event.getX() + " Y=" + event.getY());
//    	
//    	switch (event.getAction()) {
//    	case MotionEvent.ACTION_DOWN:
//    		renderer.getScene().getPlayer().setMoving(touchX, touchY);
//    		break;
//    	case MotionEvent.ACTION_UP:
//    		renderer.getScene().getPlayer().setStatic();
//    		break;
//    	case MotionEvent.ACTION_MOVE:
//    		break;
//    	}
//    	return true;
//    }
        
//    public void setScene(Scene scene) {
//    	renderer.setScene(scene);
//    }
}
