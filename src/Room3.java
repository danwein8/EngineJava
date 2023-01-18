//--------------------------------------------------------------//
import java.awt.Graphics;
//--------------------------------------------------------------//

public class Room3 extends Room
{
	//----------------------------------------------------------//

	public Room3()
	{
		super("Hall 4 Left Window Right Door wide low.png");
	}

	//----------------------------------------------------------//

	public void inGameLoop()
	{
		rightDoor(100, 200, 240, -200, new Room2());

		leftWall(-100);
		rightWall(100);

		backWall(320);
	}

	//----------------------------------------------------------//
}

