//--------------------------------------------------------------//
import java.awt.Graphics;
//--------------------------------------------------------------//

public class Room1 extends Room
{		
	//----------------------------------------------------------//

	public Room1()
	{
		super("Hall 1 Door wide low.png");
	}

	//----------------------------------------------------------//

	public void inGameLoop()
	{		
		backDoor(240, -20, 20, 40, new Room2());


		leftWall(-85);
		rightWall(85);

		backWall(240);			
	}

	//----------------------------------------------------------//

}
