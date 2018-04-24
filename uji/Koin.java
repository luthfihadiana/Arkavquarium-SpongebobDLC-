public class Koin extends Benda
{
	private int nilai;
	
	public Koin()
	{
		super(50,0,10,'d');
		nilai = 10;
	}
	
	public Koin(int value , double _x, double _y)
	{
		super(_x,_y,10,'d');
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

	public void turun(double time_last)
	{
		if(this.getPos().getY() < SCREEN_HEIGHT)
		{
			this.setPos(this.getPos().getX(),this.getPos().getY()+this.getKecepatan()*time_last);
		}
	}

	/*public void draw()
	{
		draw_image("Koin.png", this.getPos().getX(), this.getPos().getY());
	}*/
}