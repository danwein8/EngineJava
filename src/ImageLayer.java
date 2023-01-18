import java.awt.*;

public class ImageLayer
{
	int x = 0;
	int y = 0;
	int z = 0;


	Image image;

	public ImageLayer(String filename)
	{
		image = Toolkit.getDefaultToolkit().getImage(filename);
	}

	public ImageLayer(String filename, int z)
	{
		image = Toolkit.getDefaultToolkit().getImage(filename);

		this.z = z;
	}

	public ImageLayer(String filename, int x, int y, int z)
	{
		image = Toolkit.getDefaultToolkit().getImage(filename);

		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void draw(Graphics pen)
	{
		for(int i = 0; i < 20; i++)

			pen.drawImage(image, x + 720*i - Camera.x / z, y - Camera.y / z, null);
	}

}