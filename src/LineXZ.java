import java.awt.Graphics;

public class LineXZ
{
	int Ax;
	int Az;

	int Bx;
	int Bz;

	int y;


	double Nx;
	double Nz;

	double c;

	double d = 512;

	int origin_x = 960;
	int origin_y = 540;

	public LineXZ(int Ax, int Az, int y, int Bx, int Bz)
	{
		this.Ax = Ax;
		this.Az = Az;

		this.y  = y;

		this.Bx = Bx;
		this.Bz = Bz;

		double vx = Ax - Bx;
		double vz = Az - Bz;

		double mag = Math.sqrt(vx*vx + vz*vz);


		Nx = -vz / mag;
		Nz =  vx / mag; 

		c = Ax * Nx + Az * Nz;
	}

	public double distanceFrom(double Px, double Pz)
	{
		return Px * Nx + Pz * Nz - c;
	}

	public void draw(Graphics pen)
	{
		int AxC = Ax - Camera.x;
		int AzC = Az - Camera.z;
		int BxC = Bx - Camera.x;
		int BzC = Bz - Camera.z;


		if((AzC < 1) && (BzC >= 1))
		{
			double CxC = BxC - (BzC-1)*(BxC - AxC)/(BzC - AzC);

			double Bx3D = d * BxC / BzC;
			double By3D = d * ( y - Camera.y) / BzC;

			double Cx3D = d * CxC;
			double Cy3D = d * ( y - Camera.y);


			int AxS = (int)Bx3D + origin_x;
			int AyS = (int)By3D + origin_y;

			int BxS = (int)Cx3D + origin_x;
			int ByS = (int)Cy3D + origin_y;


			pen.drawLine(AxS, AyS, BxS, ByS);
		}




		if((AzC >= 1) && (BzC < 1))
		{
			double CxC = AxC - (AzC-1)*(AxC - BxC)/(AzC - BzC);

			double Ax3D = d * AxC / AzC;
			double Ay3D = d * ( y - Camera.y) / AzC;

			double Cx3D = d * CxC;
			double Cy3D = d * ( y - Camera.y);


			int AxS = (int)Ax3D + origin_x;
			int AyS = (int)Ay3D + origin_y;

			int BxS = (int)Cx3D + origin_x;
			int ByS = (int)Cy3D + origin_y;


			pen.drawLine(AxS, AyS, BxS, ByS);
		}


		if((AzC > 0) && (BzC > 0))
		{		
			double Ax3D = d * AxC / AzC;
			double Ay3D = d * ( y - Camera.y) / AzC;

			double Bx3D = d * BxC / BzC;
			double By3D = d * ( y - Camera.y) / BzC;


			int AxS = (int)Ax3D + origin_x;
			int AyS = (int)Ay3D + origin_y;

			int BxS = (int)Bx3D + origin_x;
			int ByS = (int)By3D + origin_y;


			pen.drawLine(AxS, AyS, BxS, ByS);
		}

	}

	public void moveLeft(int dx)
	{
		Ax -= dx;
		Bx -= dx;
	}

	public void moveRight(int dx)
	{
		Ax += dx;
		Bx += dx;
	}

	public void moveIn(int dz)
	{
		Az -= dz;
		Bz -= dz;
	}

	public void moveOut(int dz)
	{
		Az += dz;
		Bz += dz;
	}

	public void moveBy(int dx, int dz)
	{
		Ax += dx;
		Az += dz;

		Bx += dx;
		Bz += dz;
	}


}