public class Makanan extends Benda
{
	public Makanan(double _x)
	{
		super(_x,0,10,'d');
	}
	
	public void turun(double time_last)
	{
		if(this.getPos().getY() < SCREEN_HEIGHT)
		{
			this.setPos(this.getPos().getX(),this.getPos().getY()+this.getKecepatan()*time_last);
		}
	}//Makanan bergerak dari atas ke bawah

	/*public void draw()
	{
		draw_image("Krabby_Patty.png", this.getPos().getX(), this.getPos().getY());                        
	}*/
}