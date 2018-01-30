//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class GeometryFoot extends DAGNode {
	float uniformScale;
	float tx, ty, tz;
	
	
	GeometryFoot( String name, float _uniformScale, float _tx, float _ty, float _tz )
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

        gl.glColor3f( 153.f/255.f, 38.f/255.f, 20.f/255.f );  //Foot is brown 
        
	    gl.glPushMatrix();// Create Cuff
	    gl.glScalef( 0.7f, 1.0f, 0.35f );
	    glut.glutSolidCube( 1 );
        gl.glPopMatrix(); 	
         
        gl.glColor3f(1, 0, 0);  //Reset Colour
		super.display(drawable);
	
		gl.glPopMatrix();
	}
}
