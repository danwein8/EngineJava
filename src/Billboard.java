import java.awt.*;

public class Billboard
{
	// Position P
	double x;
	double y;
	double z;

	int w;
	int h;

	Image image;

	public Billboard(int x, int y, int z, int w, int h, String name)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;

		image = Toolkit.getDefaultToolkit().getImage(name);		
	}



	public void draw(Graphics pen)
	{
		if (z - Camera.z > 10)
		{
			double d = 512;
			int x_origin = 683; //956;
			int y_origin = 384; //530;

			double xC = x - Camera.x;
			double yC = y - Camera.y;
			double zC = z - Camera.z;


			double x3D = d * xC / zC;
			double y3D = d * yC / zC;
			double w3D = d *  w / zC;
			double h3D = d *  h / zC;


			int xS = (int)(x3D - w3D / 2)  + x_origin;
			int yS = (int)(y3D - h3D)      + y_origin;
			int wS = (int) w3D;
			int hS = (int) h3D;

			pen.drawImage(image, xS, yS, wS, hS, null);

		}
	}

}