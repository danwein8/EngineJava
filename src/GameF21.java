//--------------------------------------------------------------//
import java.awt.*;
//--------------------------------------------------------------//

public class GameF21 extends GameBase 
{
	//----------------------------------------------------------//


	Wall3D wall1 = new Wall3D(100, 1000, 100, 100, 100, -100);	
	Wall3D wall2 = new Wall3D(-100, 100, -100, 1000, 100, -100);
	Wall3D wall3 = new Wall3D(100, 1000, 2000, 2000, 100, -100);
	Wall3D wall4 = new Wall3D(2000, 2000, 0, 4000, 100, -100);
	Wall3D wall5 = new Wall3D(0, 4000, -3000, 2500, 100, -100);
	Wall3D wall6 = new Wall3D(-3000, 2500, -1500, 1000, 100, -100);
	Wall3D wall7 = new Wall3D(-1500, 1000, -100, 1000, 100, -100);

	//----------------------------------------------------------//

	public void initialize() 
	{
	}

	//----------------------------------------------------------//

	public void inGameLoop()
	{
		if(pressing[LT])   Camera.turnLeft(2);
		if(pressing[RT])   Camera.turnRight(2);
		if(pressing[UP])   Camera.moveForward(10);
		if(pressing[DN])   Camera.moveBackward(10);
		if(pressing[_D])   Camera.moveDown(3);
		if(pressing[_U])   Camera.moveUp(3);

	}

	//----------------------------------------------------------//

	public void paint(Graphics pen)
	{
		wall4.draw(pen);
		wall5.draw(pen);
		wall3.draw(pen);
		wall6.draw(pen);
		wall7.draw(pen);
		wall1.draw(pen);
		wall2.draw(pen);
	}

	//----------------------------------------------------------//

}

/*
public class GameF21 extends GameBase 
{
	//----------------------------------------------------------//

	Soldier3D soldier = new Soldier3D(0, 90, 100);

	//----------------------------------------------------------//

	public void initialize() 
	{
		Room.soldier = soldier;
		Room.current = new Room1();
	}

	//----------------------------------------------------------//

	public void inGameLoop()
	{
		if(pressing[LT])   soldier.moveLeft(3);
		if(pressing[RT])   soldier.moveRight(3);
		if(pressing[UP])   soldier.moveIn(3);
		if(pressing[DN])   soldier.moveOut(3);

		Room.current.inGameLoop();
	}

	//----------------------------------------------------------//

	public void paint(Graphics pen)
	{
		Room.current.draw(pen);
	}

	//----------------------------------------------------------//

}

 */


