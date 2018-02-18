//Milan Singh 260654803
package comp557.a1;

public class CharacterCreator {

	static public String name = "MARIO-MILAN_SINGH-260654803";
	
	/** 
	 * Creates a character.
	 * @return root DAGNode
	 */
	static public DAGNode create() {
		// TODO: use for testing, and ultimately for creating a character
		// Here we just return null, which will not be very interesting, so write
		// some code to create a charcter and return the root node.
		
		
		FreeJoint root = new FreeJoint( "body" );
		
		GeometryTorso torso = new GeometryTorso( "torso", -22.5f, 90, -45, 45, 0.f, 0.5f, 0.f );
		root.add( torso );
		
		GeometryHead head = new GeometryHead( "head", 1, 0.0f, 1.25f, 0.0f );
		torso.add( head );
		
		//Create Left Arm
		BallJoint lShoulder = new BallJoint( "leftShoulder", 0.8f, 0.6f, 0, 1, 0, 0, -180, 180, -45, 135, 0, 0 );
		torso.add( lShoulder );

 		GeometryLimb lUpperArm = new GeometryLimb( "leftUpperArm", 1, 0, 0,  0.35f, 0.7f, 5, 5 );
 		lShoulder.add( lUpperArm );
 		
 		HingeJoint lElbow = new HingeJoint( "leftElbow", 0, 0, 0.75f, 1, 0, 0, -135, 0, 1, 0, 0 );
 		lUpperArm.add( lElbow );

 		GeometryLimb lForearm = new GeometryLimb( "leftForearm", 1, 0, 0, 0.35f, 0.7f, 5, 5 );
 		lElbow.add( lForearm );
 		
 		GeometryHand lHand = new GeometryHand( "leftHand", 1.0f, 0, 0, 0.92f );
 		lForearm.add( lHand );

		//Create Right Arm 		
		BallJoint rShoulder = new BallJoint( "rightShoulder", -0.8f, 0.6f, 0, 1, 0, 0, -180, 180, -135, 45, 0, 0 );
		torso.add( rShoulder );
 		
 		GeometryLimb rUpperArm = new GeometryLimb( "rightUpperArm", 1, 0, 0, 0.35f, 0.7f, 5, 5 );
 		rShoulder.add( rUpperArm );
		
 		HingeJoint rElbow = new HingeJoint( "rightElbow", 0, 0, 0.75f, 1, 0, 0, -135, 0, 1, 0, 0 );
 		rUpperArm.add( rElbow );

 		GeometryLimb rForearm = new GeometryLimb( "rightForearm", 1, 0, 0, 0.35f, 0.7f, 5, 5 );
 		rElbow.add( rForearm );
 		
 		GeometryHand rHand = new GeometryHand( "rightHand", 1.0f, 0, 0, 0.92f );
 		rForearm.add( rHand );
 		
 		//Create Left Leg
		BallJoint lHipJoint = new BallJoint( "leftHipJoint", 0.45f, -0.7f, 0, 0, 0, 1, 0, 180, -15, 90, 0, 0 );
		root.add( lHipJoint );

 		GeometryLimb lThigh = new GeometryLimb( "leftThigh", 0, 0, 1,  0.4f, 0.5f, 5, 5 );
 		lHipJoint.add( lThigh );
 		
 		HingeJoint lKnee = new HingeJoint( "leftKnee", 0, 0, 0.45f, 0, 0, 1, 0, 135, 1, 0 ,0 );
 		lThigh.add( lKnee );

 		GeometryLimb lShin = new GeometryLimb( "leftShin", 0, 0, 1, 0.4f, 0.5f, 5, 5 );
 		lKnee.add( lShin );
 		
 		GeometryFoot lFoot = new GeometryFoot( "leftFoot", 1, 0.0f, 0.2f, .5f );
 		lShin.add( lFoot );
 		
 		//Create Left Leg
		BallJoint rHipJoint = new BallJoint( "rightHipJoint", -0.45f, -0.7f, 0, 0, 0, 1, 0, 180, -90, 15, 0, 0 );
		root.add( rHipJoint );

 		GeometryLimb rThigh = new GeometryLimb( "rightThigh", 0, 0, 1,  0.4f, 0.5f, 5, 5 );
 		rHipJoint.add( rThigh );
 		
 		HingeJoint rKnee = new HingeJoint( "rightKnee", 0, 0, 0.45f, 0, 0, 1, 0, 135, 1, 0, 0 );
 		rThigh.add( rKnee );

 		GeometryLimb rShin = new GeometryLimb( "rightShin", 0, 0, 1, 0.4f, 0.5f, 5, 5 );
 		rKnee.add( rShin );
 		
 		GeometryFoot rFoot = new GeometryFoot( "rightFoot", 1, 0.0f, 0.2f, .5f );
 		rShin.add( rFoot );

 		
		return root;
	}
}
