//--------------------------------------------------------------//
import java.awt.Graphics;
//--------------------------------------------------------------//

public abstract class Room
{
	static Soldier3D soldier;
	static Room      current;

	Background       background;

	//----------------------------------------------------------//

	public Room(String filename)
	{
		background = new Background(filename);
	}

	//----------------------------------------------------------//

	public void inGameLoop()
	{

	}

	//----------------------------------------------------------//

	public void draw(Graphics pen)
	{
		background.draw(pen);

		soldier.draw(pen);					
	}

	//----------------------------------------------------------//

	public void frontWall(int z)
	{
		if(soldier.z < z)   soldier.z += 3;
	}

	//----------------------------------------------------------//

	public void backWall(int z)
	{
		if(soldier.z > z)   soldier.z -= 3;
	}

	//----------------------------------------------------------//


	public void leftWall(int x)
	{
		if(soldier.x < x)   soldier.x += 3;
	}

	//----------------------------------------------------------//

	public void rightWall(int x)
	{
		if(soldier.x > x)   soldier.x -= 3;
	}

	//----------------------------------------------------------//

	public void frontDoor(int z, int x1, int x2, int popup, Room room)
	{		
		if((soldier.z < z) && (soldier.x > x1) && (soldier.x < x2))
		{
			Room.current = room;

			soldier.z = popup;  // where the soldier pops up in the next room.				
		}
	}


	//----------------------------------------------------------//

	public void backDoor(int z, int x1, int x2, int popup, Room room)
	{		
		if((soldier.z > z) && (soldier.x > x1) && (soldier.x < x2))
		{
			Room.current = room;

			soldier.z = popup;  // where the soldier pops up in the next room.				
		}
	}


	//----------------------------------------------------------//

	public void leftDoor(int x, int z1, int z2, int popup, Room room)
	{		
		if((soldier.x < x) && (soldier.z > z1) && (soldier.z < z2))
		{
			Room.current = room;

			soldier.x = popup;  // where the soldier pops up in the next room.				
		}
	}


	//----------------------------------------------------------//

	public void rightDoor(int x, int z1, int z2, int popup, Room room)
	{
		if((soldier.x > x) && (soldier.z > z1) && (soldier.z < z2))
		{
			Room.current = room;

			soldier.x = popup;  // where the soldier pops up in the next room.				
		}
	}

	//----------------------------------------------------------//
}