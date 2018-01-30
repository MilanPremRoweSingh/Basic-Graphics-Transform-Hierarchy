//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class FreeJoint extends DAGNode {

	DoubleParameter tx;
	DoubleParameter ty;
	DoubleParameter tz;
	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
		
	public FreeJoint( String name ) 
	{
		super(name);
		dofs.add( tx = new DoubleParameter( name+" tx", 0, -2, 2 ) );		
		dofs.add( ty = new DoubleParameter( name+" ty", 0, -2, 2 ) );
		dofs.add( tz = new DoubleParameter( name+" tz", 0, -2, 2 ) );
		dofs.add( rx = new DoubleParameter( name+" rx", 0, -180, 180 ) );		
		dofs.add( ry = new DoubleParameter( name+" ry", 0, -180, 180 ) );
		dofs.add( rz = new DoubleParameter( name+" rz", 0, -180, 180 ) );
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glTranslatef( tx.getFloatValue(), ty.getFloatValue(), tz.getFloatValue() );
		
        gl.glRotatef( rx.getFloatValue(), 1, 0, 0);
        gl.glRotatef( ry.getFloatValue(), 0, 1, 0);
        gl.glRotatef( rz.getFloatValue(), 0, 0, 1);
        
        gl.glColor3f( 0.0f, 0.0f, 1.0f );
        glut.glutSolidSphere( 0.85f, 10, 10);

		super.display(drawable);

	}

	
}
