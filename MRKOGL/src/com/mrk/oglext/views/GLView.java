package com.mrk.oglext.views;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.mrk.oglext.MRKOGL;

public class GLView extends GLSurfaceView {
    public float touchX;
    public float touchY;
    
    public GLView(Context context) {
        super(context);

        MRKOGL.getInstance().init(context);
        setRenderer(MRKOGL.getInstance().renderer);
        // Render the view only when there is a change
        setRenderMode(GLView.RENDERMODE_WHEN_DIRTY);
    }

    public GLView(Context context, AttributeSet attributes) {
    	super(context, attributes);

    	MRKOGL.getInstance().init(context);
        setRenderer(MRKOGL.getInstance().renderer);
        // Render the view only when there is a change
        setRenderMode(GLView.RENDERMODE_WHEN_DIRTY);
    }
}
