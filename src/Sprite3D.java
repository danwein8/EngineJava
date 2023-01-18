import java.awt.Graphics;

public class Sprite3D
{
	// Position P
	double x;
	double y;
	double z;

	// Velocity V
	double vx = 0;
	double vy = 0;

	// Accerleration a
	double ax = 0;
	double ay = gravity;


	int w;
	int h;


	final static double gravity = 0.3; 

	static double d = 512;

	static int x_origin = 683;  // 872;   //956;
	static int y_origin = 220; //384; //530;



	Animation[] animation;

	boolean moving = false;

	final int UP = 0;
	final int DN = 1;
	final int LT = 2;
	final int RT = 3;

	int action = DN;

	public Sprite3D(int x, int y, int z, int w, int h, String name, String[] pose, int count, String filetype, int delay)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;

		animation = new Animation[pose.length];

		for(int i = 0; i < animation.length; i++)

			animation[i] = new Animation(name + pose[i], count, filetype, delay);
	}



	public void draw(Graphics pen)
	{
		if (z - Camera.z > 10)
		{
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

			if(moving)

				pen.drawImage(animation[action].currentImage(), xS, yS, wS, hS, null);   	   

			else

				pen.drawImage(animation[action].stillImage(), xS, yS, wS, hS, null);

			moving = false;
		}
	}

	public void setVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}

	public void setAccelleration(double ax, double ay)
	{
		this.ax = ax;
		this.ay = ay;
	}

	public void jump()
	{
		vy = -8;
	}

	public void move()
	{
		// Moved based on current velocity
		x += vx;  
		y += vy;

		// Adjust Velocity based on current acceleration
		vx += ax;
		vy += ay;
	}


	public void moveUp(int dy)
	{
		y -= dy;

		moving = true;

		action = UP;
	}

	public void moveDown(int dy)
	{
		y += dy;

		moving = true;

		action = DN;
	}

	public void moveLeft(int dx)
	{
		x -= dx;

		moving = true;

		action = LT;
	}

	public void moveRight(int dx)
	{
		x += dx;

		moving = true;

		action = RT;
	}

	public void moveIn(int dz)
	{
		z += dz;

		moving = true;

		action = UP;
	}


	public void moveOut(int dz)
	{
		z -= dz;

		moving = true;

		action = DN;
	}


	public void goLeft(int dx)
	{
		vx = -dx;

		moving = true;

		action = LT;
	}

	public void goRight(int dx)
	{
		vx = +dx;

		moving = true;

		action = RT;
	}

	public boolean overlaps(Rect r)
	{
		return (x + w >= r.x      ) &&
				(x     <= r.x + r.w) &&
				(y + h >= r.y      ) &&
				(y     <= r.y + r.h);
	}


	public void pushUpFrom(Rect platform)
	{
		y -= y + h  - platform.y;

		vx = 0;
		vy = 0;
	}

	public boolean contains(int mx, int my)
	{
		return ( mx > x   ) &&   
				( mx < x+w ) && 
				( my > y   ) && 
				( my < y+h );
	}

}