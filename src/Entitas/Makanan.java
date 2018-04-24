package Entitas;
public class Makanan extends Benda implements Gerak
{
	public Makanan(double _x , double _y)
	{
		super(_x,_y,1,'d');
	}
	
	public void gerak()
	{
		if(this.getPos().getY() < SCREEN_HEIGHT)
		{
			this.setPos(this.getPos().getX(),this.getPos().getY()+this.getKecepatan()*0.5);
		}
	}
}