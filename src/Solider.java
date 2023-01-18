
public class Solider extends Sprite
{
	static String[] pose = {"_up_", "_dn_", "_lt_", "_rt_"};

	public Solider(int x, int y)
	{
		super(x, y, 20, 50, "g", pose, 5, "gif", 10);
	}

	public Solider(int x, int y, int w, int h)
	{
		super(x, y, w, h, "g", pose, 5, "gif", 10);
	}


}