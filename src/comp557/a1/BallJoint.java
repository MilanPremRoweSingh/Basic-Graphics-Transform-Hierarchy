//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class BallJoint extends DAGNode {
	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
	float tx, ty, tz;
	float cr, cg, cb;
	
	BallJoint( 	String name,
				float _tx, float _ty, float _tz,
				float _cr, float _cg, float _cb,
				float rxMin, float rxMax,
				float ryMin, float ryMax,
				float rzMin, float rzMax )
	{
		super(name);

		dofs.add( rx = new DoubleParameter( name+" rx", 0, rxMin, rxMax ) );		
		dofs.add( ry = new DoubleParameter( name+" ry", 0, ryMin, ryMax ) );
		dofs.add( rz = new DoubleParameter( name+" rz", 0, rzMin, rzMax ) );
		
		tx = _tx;
		ty = _ty;
		tz = _tz;

		cr	= _cr;
		cg	= _cg;
		cb	= _cb;
	}	

	@Override
	public void display(GLAutoDrawable drawable)
	{
		GL2 gl = drawable.getGL().getGL2();

		gl.glColor3f( cr, cg, cb );
		
		gl.glPushMatrix();
		
		gl.glTranslatef( tx, ty, tz );
		
        gl.glRotatef( rx.getFloatValue(), 1, 0, 0);
        gl.glRotatef( ry.getFloatValue(), 0, 1, 0);
        gl.glRotatef( rz.getFloatValue(), 0, 0, 1);
           
		// Draw something interesting
        glut.glutSolidSphere( 0.25f, 10, 10 );
    
		super.display(drawable);
		
		gl.glPopMatrix();
	}
}
