
public class Soldier3D extends Sprite3D
{
	static String[] pose = {"_up_", "_dn_", "_lt_", "_rt_"};

	public Soldier3D(int x, int y, int z)
	{
		super(x, y, z, 20, 50, "g", pose, 5, "gif", 10);
	}

	public Soldier3D(int x, int y, int z, int w, int h)
	{
		super(x, y, z, w, h, "g", pose, 5, "gif", 10);
	}
}