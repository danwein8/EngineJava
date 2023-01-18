//--------------------------------------------------------------//
import java.awt.Graphics;
//--------------------------------------------------------------//	

public class Room2 extends Room
{
	//----------------------------------------------------------//

	public Room2()
	{
		super("Hall 3 T-junction wide low.png");
	}

	//----------------------------------------------------------//

	public void inGameLoop()
	{
		if(soldier.z < 160)
		{
			leftWall(-100);
			rightWall(100);

			frontDoor(40, -30, 30, 240, new Room1());
		}
		else
		{	
			backWall(320);


			leftDoor(-200, 160, 320, 100, new Room3());

			rightDoor(200, 160, 320, 0, new Room4());
		}

	}

	//----------------------------------------------------------//

	public void draw(Graphics pen)
	{
		background.draw(pen);


		if(soldier.z >= 160)
		{
			pen.setClip(340, 200, 684, 300);
			//pen.setClip(436, 300, 878, 445);
		}

		soldier.draw(pen);

		pen.setClip(null);

	}

	//----------------------------------------------------------//

}
