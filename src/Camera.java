public class Camera
{
	static int x;
	static int y;
	static int z;

	static int A = 0;

	static double cosA = 1;
	static double sinA = 0;

	public static void turnLeft(int dA)
	{
		A -= dA;

		if(A < 0)  A += 360;

		cosA = Lookup.cos[A];
		sinA = Lookup.sin[A];
	}

	public static void moveForward(int d)
	{
		x += d * sinA;
		z += d * cosA;
	}

	public static void moveBackward(int d)
	{
		x -= d * sinA;
		z -= d * cosA;
	}

	public static void turnRight(int dA)
	{
		A += dA;

		if(A >=  360)  A -= 360;

		cosA = Lookup.cos[A];
		sinA = Lookup.sin[A];
	}

	public static void moveUp(int dy)
	{
		y -= dy;
	}

	public static void moveDown(int dy)
	{
		y += dy;
	}

	public static void moveLeft(int dx)
	{
		x -= dx;
	}

	public static void moveRight(int dx)
	{
		x += dx;
	}

	public static void moveIn(int dz)
	{
		z += dz;
	}

	public static void moveOut(int dz)
	{
		z -= dz;
	}
}