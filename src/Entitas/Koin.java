package Entitas;
public class Koin extends Benda implements Gerak
{
	private int nilai;
	
	public Koin(double _x)
	{
		super(_x,0,1,'d');
		nilai = 10;
	}
	
	public Koin(int value , double _x, double _y)
	{
		super(_x,_y,1,'d');
		nilai = value;
	}
	
	public int getNilai()
	{
		return nilai;
	}//Mengembalikan nilai suatu koin
	
	public void setNilai(int in)
	{
		nilai = in;
	}

	public void gerak()
	{
		if(this.getPos().getY() < SCREEN_HEIGHT)
		{
			this.setPos(this.getPos().getX(),this.getPos().getY()+this.getKecepatan()*0.5);
		}
	}
}