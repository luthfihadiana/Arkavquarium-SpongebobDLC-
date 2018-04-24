import java.util.Random;
public class Ikan extends Benda
{
	protected int time; //>50 lapar dan >100 mati
	protected double sudut;// point Destination; // Sebuah point yang akan dituju oleh ikan
	protected long c;
	
	static int count = 0;
	
	public Ikan()
	{
		time = 0;
		sudut = 0;
		c = 0;
	}
	
	public Ikan(double _x, double _y, int _kecepatan, char _arah, int s)
	{
		super(_x, _y, _kecepatan, _arah);
		time = 0;
		sudut = s;
		c = 0;
	}

	public int getTime()
	{
		return time;
	}
	
	public void setTime(int _waktu)
	{
		time =  _waktu;
	}
	public double getSudut()
	{
		return sudut;
	}
	public long getCC()
	{
		return c;
	}
	public void setSudut(int x)
	{
		sudut = x;
	}
	public void gerak(double time_last)
	{
		// cout << this.getPos().getX() <<","<< this.getPos().getY()<<endl;
		if(count % 223 == 0)
		{
			Random rand = new Random();
			this.setSudut(rand.nextInt(360));
			// cout << this.getArah();
		}
		double xmov = this.getPos().getX()+this.getKecepatan()*Math.cos(sudut*Math.PI/180)*time_last;
		double ymov = this.getPos().getY()+this.getKecepatan()*Math.sin(sudut*Math.PI/180)*time_last;
		if((xmov-60<0)||(xmov+60>640))
		{
			sudut = sudut+180;
			xmov = this.getPos().getX()+this.getKecepatan()*Math.cos(sudut*Math.PI/180)*time_last;
		}
		if((ymov-20<0)||(ymov+20>480))
		{
			sudut = -1*sudut;        
			ymov = this.getPos().getY()+this.getKecepatan()*Math.sin(sudut*Math.PI/180)*time_last;
		}  
		this.setPos(xmov,ymov);
		if ((this.getSudut()>=90)&&(this.getSudut()<=270))
		{
			this.setArah('l');
		}
		else
		{
			this.setArah('r');
		}
		// cout << this.getPos().getX() <<","<< this.getPos().getY()<<endl;    
		count ++;
	}
}