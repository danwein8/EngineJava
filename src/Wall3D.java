import java.awt.Color;
import java.awt.Graphics;

public class Wall3D
{
	int Ax;
	int Az;

	int Bx;
	int Bz;

	int ybot;
	int ytop;


	double Nx;
	double Nz;

	double c;

	double d = 512;

	int origin_x = 683;
	int origin_y = 300;

	public Wall3D(int Ax, int Az, int Bx, int Bz, int ybot, int ytop)
	{
		this.Ax = Ax;
		this.Az = Az;

		this.ybot  = ybot;
		this.ytop  = ytop;

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

		double cosA = Camera.cosA;
		double sinA = Camera.sinA;

		int AxR = (int)(AxC * cosA - AzC * sinA);
		int AzR = (int)(AxC * sinA + AzC * cosA);

		int BxR = (int)(BxC * cosA - BzC * sinA);
		int BzR = (int)(BxC * sinA + BzC * cosA);



		if((AzR < 1) && (BzR >= 1))
		{
			double CxR = BxR - (BzR-1)*(BxR - AxR)/(BzR - AzR);

			double Bx3D = d * BxR / BzR;
			double By3DB = d * ( ybot - Camera.y) / BzR;
			double By3DT = d * ( ytop - Camera.y) / BzR;

			double Cx3D = d * CxR / 1;
			double Cy3DB = d * ( ybot - Camera.y);
			double Cy3DT = d * ( ytop - Camera.y);


			int AxS = (int)Bx3D + origin_x;
			int AySB = (int)By3DB + origin_y;
			int AyST = (int)By3DT + origin_y;

			int BxS = (int)Cx3D + origin_x;
			int BySB = (int)Cy3DB + origin_y;
			int ByST = (int)Cy3DT + origin_y;


			int[] x_points = {AxS,  BxS,  BxS,  AxS};
			int[] y_points = {AySB, BySB, ByST, AyST};


			pen.setColor(Color.LIGHT_GRAY);
			pen.fillPolygon(x_points, y_points, 4);

			pen.setColor(Color.BLACK);
			pen.drawPolygon(x_points, y_points, 4);
		}




		if((AzR >= 1) && (BzR < 1))
		{
			double CxR = AxR - (AzR-1)*(AxR - BxR)/(AzR - BzR);

			double Ax3D = d * AxR / AzR;
			double Ay3DB = d * ( ybot - Camera.y) / AzR;
			double Ay3DT= d * ( ytop - Camera.y) / AzR;

			double Cx3D = d * CxR;
			double Cy3DB = d * ( ybot - Camera.y);
			double Cy3DT = d * ( ytop - Camera.y);


			int AxS = (int)Ax3D + origin_x;
			int AySB = (int)Ay3DB + origin_y;
			int AyST = (int)Ay3DT + origin_y;

			int BxS = (int)Cx3D + origin_x;
			int BySB = (int)Cy3DB + origin_y;
			int ByST = (int)Cy3DT + origin_y;


			int[] x_points = {AxS,  BxS,  BxS,  AxS};
			int[] y_points = {AySB, BySB, ByST, AyST};

			pen.setColor(Color.LIGHT_GRAY);
			pen.fillPolygon(x_points, y_points, 4);

			pen.setColor(Color.BLACK);
			pen.drawPolygon(x_points, y_points, 4);
		}


		if((AzR >= 1) && (BzR >= 1))
		{		
			double Ax3D = d * AxR / AzR;
			double Ay3DB = d * ( ybot - Camera.y) / AzR;
			double Ay3DT = d * ( ytop - Camera.y) / AzR;

			double Bx3D = d * BxR / BzR;
			double By3DB = d * ( ybot - Camera.y) / BzR;
			double By3DT = d * ( ytop - Camera.y) / BzR;


			int AxS = (int)Ax3D + origin_x;
			int AySB = (int)Ay3DB + origin_y;
			int AyST = (int)Ay3DT + origin_y;

			int BxS = (int)Bx3D + origin_x;
			int BySB = (int)By3DB + origin_y;
			int ByST = (int)By3DT + origin_y;


			int[] x_points = {AxS,  BxS,  BxS,  AxS};
			int[] y_points = {AySB, BySB, ByST, AyST};

			pen.setColor(Color.LIGHT_GRAY);
			pen.fillPolygon(x_points, y_points, 4);

			pen.setColor(Color.BLACK);
			pen.drawPolygon(x_points, y_points, 4);

		}

	}

}