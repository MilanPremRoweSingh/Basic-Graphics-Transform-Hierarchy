//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class GeometryHead extends DAGNode {
	float uniformScale;
	float tx, ty, tz;
	
	
	GeometryHead( String name, float _uniformScale, float _tx, float _ty, float _tz )
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

	    //Draw Head
        gl.glColor3f( 253.f/255.f, 235.f/255.f, 189.f/255.f ); 
        glut.glutSolidSphere( 0.85f, 8, 8 );	
        
        //Draw Nose
        gl.glPushMatrix();
        gl.glTranslatef( 0, 0, 1.1f ); 
        glut.glutSolidSphere( 0.4f, 6, 6 );	
        gl.glPopMatrix();
        
        //Draw Hat part - Visor
        gl.glPushMatrix();
        gl.glColor3f( 1, 0, 0 ); 
        gl.glRotatef( -15f, 1, 0, 0.f );
        gl.glTranslatef( 0, .35f, 0.2f ); 
        gl.glScalef( 2.5f, 0.55f, 3.5f ); 
        glut.glutSolidCube( 0.6f );	
        gl.glPopMatrix();
        
       //Draw Hat part - Hat
        gl.glPushMatrix();
        gl.glColor3f( 1, 0, 0 ); 
        gl.glRotatef( -15f, 1, 0, 0.f );
        gl.glTranslatef( 0, .65f, -0.1f ); 
        gl.glScalef( 2.5f, 1.3f, 2.5f ); 
        //glut.glutSolidSphere( 0.4f, 6, 6 );	
        glut.glutSolidCube( 0.6f );	
        gl.glPopMatrix();
      	
		super.display(drawable);
	
		gl.glPopMatrix();
	}
}
