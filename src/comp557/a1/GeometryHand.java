//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class GeometryHand extends DAGNode {
	float uniformScale;
	float tx, ty, tz;
	
	
	GeometryHand( String name, float _uniformScale, float _tx, float _ty, float _tz )
	{
		super(name);
		
		tx = _tx; 
		ty = _ty; 
		tz = _tz;
		
		uniformScale = _uniformScale;
	}
	
	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();

	    gl.glScalef( uniformScale, uniformScale, uniformScale ); 
	    gl.glTranslatef( tx, ty, tz ); 
		// Draw something interesting

        gl.glColor3f(1, 1, 1);  //Hand is white 
        
	    gl.glPushMatrix();// Create Cuff
	    gl.glScalef(1.0f, 1.0f, 0.35f);
	    glut.glutSolidSphere( 0.45f, 5, 5 );
        gl.glPopMatrix(); 	
        
        gl.glPushMatrix();// Create Fist
	    gl.glScalef(1.0f, 1.0f, 0.75f);
        gl.glTranslatef( 0.0f, 0.0f, 0.5f );
	    glut.glutSolidSphere( 0.5f, 5, 5 );
        gl.glPopMatrix(); 	
      	
		super.display(drawable);
	
		gl.glPopMatrix();
	}
}
