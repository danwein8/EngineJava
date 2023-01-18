import java.awt.Graphics;

public class Polygon
{
	int x;
	int y;

	int[] xpoints;
	int[] ypoints;

	public Polygon(int x, int y, int[] xpoints, int[] ypoints)
	{
		this.x = x;
		this.y = y;

		this.xpoints = xpoints;
		this.ypoints = ypoints;
	}





	public void draw(Graphics pen)
	{
		int[] xs = new int[xpoints.length];
		int[] ys = new int[ypoints.length];

		for(int i = 0; i < xpoints.length; i++)
		{
			xs[i] = xpoints[i] + x;
			ys[i] = ypoints[i] + y;
		}

		pen.drawPolygon(xs, ys, xpoints.length);	
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


	/*
	public void draw(Graphics pen)
	{
		for(int i = 0; i < xpoints.length-1; i++)

			pen.drawLine(xpoints[i], ypoints[i], xpoints[i+1], ypoints[i+1]);

		pen.drawLine(xpoints[0], ypoints[0], xpoints[xpoints.length-1], ypoints[xpoints.length-1])
	}
	 */
}