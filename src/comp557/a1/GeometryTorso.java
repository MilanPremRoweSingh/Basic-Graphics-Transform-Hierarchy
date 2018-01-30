//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class GeometryTorso extends DAGNode {
	DoubleParameter rx, ry;
	float tx, ty, tz;
	
	
	GeometryTorso(	String name,
					float rxMin, float rxMax,
					float ryMin, float ryMax,
					float _tx, float _ty, float _tz ) 
	{
		super(name);


		dofs.add( rx = new DoubleParameter( name+" rx", 0, rxMin, rxMax ) );		
		dofs.add( ry = new DoubleParameter( name+" ry", 0, ryMin, ryMax ) );
		
		tx = _tx;
		ty = _ty;
		tz = _tz;
	}
	
	@Override
	public void display(GLAutoDrawable drawable) 
	{
		GL2 gl = drawable.getGL().getGL2();

        gl.glColor3f( 0.0f, 0.0f, 1.0f );
        
		gl.glPushMatrix();
		
        gl.glRotatef( rx.getFloatValue(), 1, 0, 0);
        gl.glRotatef( ry.getFloatValue(), 0, 1, 0);

		gl.glTranslatef( tx, ty, tz );
        
        // Draw something interesting
        gl.glPushMatrix(); //Push so we only scale the Torso 
        
        gl.glScalef( 0.9f, 1.1f, 0.85f);
        glut.glutSolidSphere( 1.f, 10, 10);

        gl.glPopMatrix();
        
        gl.glPushMatrix(); //Draw Left Button
        gl.glColor3f( 1.0f, 215.f/255.f, 0.0f );
		gl.glTranslatef( 0.25f, 0.45f, 0.775f );
        gl.glScalef( 1.0f, 1.0f, 0.1f );
        glut.glutSolidSphere( 0.2f, 6, 6);
        gl.glPopMatrix();
        
        gl.glPushMatrix(); //Draw Right Button
		gl.glTranslatef( -0.25f, 0.45f, 0.775f );
        gl.glScalef( 1.0f, 1.0f, 0.1f );
        glut.glutSolidSphere( 0.2f, 6, 6);
        gl.glPopMatrix();
        
		super.display(drawable);

		gl.glPopMatrix();
	}
}
