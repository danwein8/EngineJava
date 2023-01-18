
public class BattleLord extends Sprite
{
	static String[] pose = {"_up_", "_dn_", "_lt_", "_rt_"};
	
	public BattleLord(int x, int y, int w, int h)
	{
		super(x, y, w, h, "bl", pose, 5, "gif", 10);
	}


}