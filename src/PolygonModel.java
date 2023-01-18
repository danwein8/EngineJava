import java.awt.*;

public class PolygonModel
{
	double x;
	double y;

	int A;

	double ux;
	double uy;

	double Nx;
	double Ny;


	int[][] x_points;
	int[][] y_points;

	public PolygonModel(int x, int y, int A, int[][] x_points, int[][] y_points)
	{
		this.x = x;
		this.y = y;

		this.A = A;

		ux = Lookup.cos[A];
		uy = Lookup.sin[A];

		Nx = -uy;
		Ny =  ux;

		this.x_points = x_points;
		this.y_points = y_points;
	}


	public void draw(Graphics pen)
	{
		int[] xs = new int[x_points[0].length];
		int[] ys = new int[y_points[0].length];


		double cosA = ux;
		double sinA = uy;


		for(int polygon = 0; polygon < x_points.length; polygon++)
		{	
			for(int i = 0; i < x_points[polygon].length; i++)
			{
				int x_ = x_points[polygon][i];
				int y_ = y_points[polygon][i];

				xs[i] = (int)(x_ * cosA - y_ * sinA + x);
				ys[i] = (int)(x_ * sinA + y_ * cosA + y);
			}

			pen.setColor(new Color(0, 80, 0));
			pen.fillPolygon(xs, ys, x_points[polygon].length);

			pen.setColor(Color.BLACK);
			pen.drawPolygon(xs, ys, x_points[polygon].length);	
		}


	}


	public void moveLeft(int dx)
	{
		x -= dx;
	}

	public void moveRight(int dx)
	{
		x += dx;
	}

	public void moveUp(int dy)
	{
		y -= dy;
	}

	public void moveDown(int dy)
	{
		y += dy;
	}

	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}



	public double distanceLeftRight(double Px, double Py)
	{
		return (Px - x) * Nx + (Py - y) * Ny;
	}

	public double distanceInFront(double Px, double Py)
	{
		return (Px - x) * ux + (Py - y) * uy;
	}


	public void turnTowards(Circle c)
	{
		if(distanceLeftRight(c.x, c.y)  <  0)   turnLeft(2);

		else                                    turnRight(2);
	}

	public void chase(Circle c)
	{

		//if(distanceInFront(c.x, c.y) >= -40)
		{
			turnTowards(c);

			if(distanceInFront(c.x, c.y) >  50+c.r)		moveForward(8);
		}
	}


	public void moveForward(int d)
	{
		x += d * ux;
		y += d * uy;
	}


	public void turnLeft(int dA)
	{
		A -= dA;

		if(A < 0  )  A += 360;

		ux = Lookup.cos[A];
		uy = Lookup.sin[A];

		Nx = -uy;
		Ny =  ux;
	}

	public void turnRight(int dA)
	{
		A += dA;

		if(A > 359)  A -= 360;		

		ux = Lookup.cos[A];
		uy = Lookup.sin[A];

		Nx = -uy;
		Ny =  ux;
	}




}