package Entitas;

import java.util.Random;

public class Ikan extends Benda implements Gerak
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
	public void gerak()
	{
		if(count % 223 == 0)
		{
			Random rand = new Random();
			this.setSudut(rand.nextInt(360));
		}
		double xmov = this.getPos().getX()+this.getKecepatan()*Math.cos(sudut*Math.PI/180);
		double ymov = this.getPos().getY()+this.getKecepatan()*Math.sin(sudut*Math.PI/180);
		if((xmov-60<0)||(xmov+60>640))
		{
			sudut = sudut+180;
			xmov = this.getPos().getX()+this.getKecepatan()*Math.cos(sudut*Math.PI/180);
		}
		if((ymov-20<0)||(ymov+20>480))
		{
			sudut = -1*sudut;        
			ymov = this.getPos().getY()+this.getKecepatan()*Math.sin(sudut*Math.PI/180);
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
		count ++;
	}
    public void cariMakan(ElmtLList<? extends Benda> pDekat) {
        sudut = Math.atan2(pDekat.getData().getPos().getY()-this.getPos().getY(),pDekat.getData().getPos().getX()-this.getPos().getX());
        double xmov = this.getPos().getX()+this.getKecepatan()*Math.cos(sudut*180/Math.PI);
        double ymov = this.getPos().getY()+this.getKecepatan()*Math.sin(sudut*180/Math.PI);
        this.setPos(xmov,ymov);

        if ((this.getSudut()>=90)&&(this.getSudut()<=270))
        {
            this.setArah('l');
        }
        else
        {
            this.setArah('r');
        }
    }
}