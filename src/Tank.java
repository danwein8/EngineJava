public class Tank extends PolygonModel
{
	static int[][] x_coordinates =
		{
				{50,  50, -50, -50},
				{30,  30, -30, -30},
				{30,  30, -30, -30},
				{20, -20, -20,  20},
				{40,  40,  20,  20},				
		};

	static int[][] y_coordinates =
		{
				{-30,  30,  30, -30},
				{ 30,  40,  40,  30},
				{-30, -40, -40, -30},
				{ 20,  20, -20, -20},
				{-5,    5,   5,  -5},				
		};

	public Tank(int x, int y, int A)
	{
		super(x, y, A, x_coordinates, y_coordinates);
	}


	public boolean overlaps(Line L)
	{
		return L.distanceFrom(x, y) - 40 < 0;   			
	}

	public void pushedBackBy(Line L)
	{
		double d = L.distanceFrom(x, y);

		x += (40 - d) * L.Nx;
		y += (40 - d) * L.Ny;
	}

}

