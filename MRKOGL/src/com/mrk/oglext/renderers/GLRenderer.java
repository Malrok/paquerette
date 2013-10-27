package com.mrk.oglext.renderers;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.mrk.oglext.MRKOGL;
import com.mrk.oglext.tools.MatrixGrabber;

public class GLRenderer implements GLSurfaceView.Renderer {

	private GLRendererInterface itf;
	
    private int screenW;
    private int screenH;
    
    public float[] topLeft;
    public float[] bottomRight;
    
    private float[] worldPos = new float[2];
	
	public GLRenderer(Context context) {
		DisplayMetrics displayMetrics = new DisplayMetrics();
		WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(displayMetrics);
		screenW = displayMetrics.widthPixels;
		screenH = displayMetrics.heightPixels;
	}
	
	public void setInterface(GLRendererInterface itf) {
		this.itf = itf;
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		MRKOGL.getInstance().gl = gl;
		
		gl.glEnable(GL10.GL_TEXTURE_2D);			//Enable Texture Mapping ( NEW )
		gl.glShadeModel(GL10.GL_SMOOTH); 			//Enable Smooth Shading
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); 	//Black Background
		gl.glClearDepthf(1.0f); 					//Depth Buffer Setup
		gl.glEnable(GL10.GL_DEPTH_TEST); 			//Enables Depth Testing
		gl.glDepthFunc(GL10.GL_LEQUAL); 			//The Type Of Depth Testing To Do
		
		//Really Nice Perspective Calculations
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
		if (itf != null) itf.createGL(gl);
	}

	
	public void onDrawFrame(GL10 gl) {
//		MRKOGL.getInstance().gl10 = gl;
		// Clears the screen and depth buffer.
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		// Replace the current matrix with the identity matrix
//		gl.glLoadIdentity();
		// Translates 4 units into the screen.
//		gl.glTranslatef(0, 0, -4);
		// Draw our scene.

		// Enables alpha on textures
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		gl.glEnable(GL10.GL_BLEND);
		
//		topLeft = GetWorldCoords(new float[]{0,0});
//		bottomRight = GetWorldCoords(new float[]{screenW ,screenH});
		
//		scene.draw(gl);
		if (itf != null) itf.render(gl);
	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// Sets the current view port to the new size.
		gl.glViewport(0, 0, width, height);
		// Select the projection matrix
		gl.glMatrixMode(GL10.GL_PROJECTION);
		// Reset the projection matrix
		gl.glLoadIdentity();
		// Calculate the aspect ratio of the window
		GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
				100.0f);
		// Select the modelview matrix
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		// Reset the modelview matrix
		gl.glLoadIdentity();
	}

	//  touch[0] = x
	//  touch[1] = y
    public float[] GetWorldCoords(float[] touch) {  
        // Initialize auxiliary variables.
//        Vec2 worldPos = new Vec2();
        // SCREEN height & width (ej: 320 x 480)
//        float screenW = cam.GetScreenWidth();
//        float screenH = cam.GetScreenHeight();
               
        // Auxiliary matrix and vectors
        // to deal with ogl.
        float[] invertedMatrix, transformMatrix,
            normalizedInPoint, outPoint;
        invertedMatrix = new float[16];
        transformMatrix = new float[16];
        normalizedInPoint = new float[4];
        outPoint = new float[4];
        
        // Invert y coordinate, as android uses
        // top-left, and ogl bottom-left.
        int oglTouchY = (int) (screenH - touch[1]); //y
        
        /* Transform the screen point to clip
        space in ogl (-1,1) */       
        normalizedInPoint[0] =
         (float) ((touch[0]) * 2.0f / screenW - 1.0);
        normalizedInPoint[1] =
         (float) ((oglTouchY) * 2.0f / screenH - 1.0);
        normalizedInPoint[2] = - 1.0f;
        normalizedInPoint[3] = 1.0f;

        MatrixGrabber mg = new MatrixGrabber();  
        
		//and them, call the getCurrentModelView() for the ModelView matrix:  
		mg.getCurrentModelView(MRKOGL.getInstance().gl);  
		//values are stored at the mg.mModelView array, so:  
//		Log.i("Translation Z value", Float.toString(mg.mModelView[14]));//prints the current translation z value  
		    
		//to get the current Projection matrix:  
		mg.getCurrentProjection(MRKOGL.getInstance().gl);  
		//values are stored at the mProjection, so:  
//		Log.i("First projection matrix value", Float.toString(mg.mProjection[0]));//prints the first projection matrix value  
        
        /* Obtain the transform matrix and
        then the inverse. */
//        Print("Proj", getCurrentProjection(gl));
//        Print("Model", getCurrentModelView(gl));
        Matrix.multiplyMM(
            transformMatrix, 0,
//            getCurrentProjection(gl), 0,
//            getCurrentModelView(gl), 0);
            mg.mProjection, 0,
            mg.mModelView, 0);
        Matrix.invertM(invertedMatrix, 0,
            transformMatrix, 0);       
  
        /* Apply the inverse to the point
        in clip space */
        Matrix.multiplyMV(
            outPoint, 0,
            invertedMatrix, 0,
            normalizedInPoint, 0);
        
        if (outPoint[3] == 0.0)
        {
            // Avoid /0 error.
            Log.e("World coords", "ERROR!");
            return worldPos;
        }
        
        // Divide by the 3rd component to find
        // out the real position.
        worldPos[0] = outPoint[0] / outPoint[3];
        worldPos[1] = outPoint[1] / outPoint[3];
          
        return worldPos;       
    }

//    /**
//     * Record the current modelView matrix
//     * state. Has the side effect of
//     * setting the current matrix state
//     * to GL_MODELVIEW
//     * @param gl context
//     */
//    public float[] getCurrentModelView(GL10 gl)
//    {
//         float[] mModelView = new float[16];
//         MatrixTrackingGL gl2 = (MatrixTrackingGL) gl;
//         IntBuffer matrixMode = IntBuffer.allocate(1);
//         gl2.glGetIntegerv(GL10.GL_MODELVIEW, matrixMode);
//         getMatrix(gl, GL10.GL_MODELVIEW, mModelView);
//         gl2.glMatrixMode(matrixMode.get(0));
//         return mModelView;
//    }
//  
//    /**
//     * Record the current projection matrix
//     * state. Has the side effect of
//     * setting the current matrix state
//     * to GL_PROJECTION
//     * @param gl context
//     */
//    public float[] getCurrentProjection(GL10 gl)
//    {
//        float[] mProjection = new float[16];
//        MatrixTrackingGL gl2 = (MatrixTrackingGL) gl;
//        IntBuffer matrixMode = IntBuffer.allocate(1);
//        gl2.glGetIntegerv(GL10.GL_PROJECTION, matrixMode);
//        getMatrix(gl, GL10.GL_PROJECTION, mProjection);
//        gl2.glMatrixMode(matrixMode.get(0));
//        return mProjection;
//    }
//  
//    /**
//     * Fetches a specific matrix from opengl
//     * @param gl context
//     * @param mode of the matrix
//     * @param mat initialized float[16] array
//     * to fill with the matrix
//     */
//    private void getMatrix(GL10 gl, int mode, float[] mat)
//    {
////        MatrixTrackingGL gl2 = (MatrixTrackingGL) gl;
////        gl2.glMatrixMode(mode);
////        gl2.getMatrix(mat, 0);
//        MatrixTrackingGL gl2 = (MatrixTrackingGL) gl;
//        gl2.glMatrixMode(mode);
//        gl2.getMatrix(mat, 0);     
//    }
}
