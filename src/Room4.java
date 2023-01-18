public class Room4 extends Room
{
	public Room4()
	{
		super("Room with no doors.png");
	}

	public void inGameLoop()
	{
		leftWall(-85);
		rightWall(75);

		frontWall(60);
		backWall(235);
	}

}