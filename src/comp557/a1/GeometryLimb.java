//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class GeometryLimb extends DAGNode {
	float radius, height; 
	int slices, stacks;
	float cr, cg, cb;
	
	
	GeometryLimb( 	String name,
					//float _tx, float _ty, float _tz,
					float _cr, float _cg, float _cb,
					float _radius, float _height,
					int _slices, int _stacks )
	{	
		super(name);
		
		radius = _radius;
		height = _height;
		slices = _slices;
		stacks = _stacks;
	
		this.cr	= _cr;
		this.cg	= _cg;
		this.cb	= _cb;
	}	

	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();

		gl.glColor3f( cr, cg, cb );
		
		gl.glPushMatrix();

		
	       
		// Draw something interesting
	    glut.glutSolidCylinder( radius, height, slices, stacks );
	
	
		super.display(drawable);
	
		gl.glPopMatrix();
	}
}
