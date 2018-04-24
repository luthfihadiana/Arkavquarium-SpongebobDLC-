public class Piranha extends Ikan
{
	public Piranha(double _x , double _y)
	{
		super(_x,_y,50,'r',0);
	}

	public void keluarKoin(LList<Koin> C, Guppy G)
	{
		Koin k = new Koin(G.getTahap()*100, this.getPos().getX(), this.getPos().getY());
		C.add(k);
	}
	/*public void draw()
	{
		long mLapar = 500;
		if(this.time >= mLapar)
		{
			if(this.getArah() == 'r')
			{
				draw_image("Piranha_r_hungry.png", this.getPos().getX(), this.getPos().getY());                        
			}
			else
			{
				draw_image("Piranha_l_hungry.png", this.getPos().getX(), this.getPos().getY());                        
			}
		}
		else
		{
			if(this.getArah() == 'r')
			{
				draw_image("Piranha_r.png", this.getPos().getX(), this.getPos().getY());                        
			}
			else
			{
				draw_image("Piranha_l.png", this.getPos().getX(), this.getPos().getY());                        
			}
		}
	}*/

	public void gerakMakan(LList<Guppy> A, double t, LList<Koin> C)
	{
		this.c++;
		this.time++;
		long mulaiLapar = 500;
		ElmtLList<Guppy> p = A.getFirst();
		if ((p == null)||(this.time<=mulaiLapar))
		{
			this.gerak(t);
		}
		else
		{
			ElmtLList<Guppy> pDekat = p;
			do
			{
				if (Math.abs(pDekat.getData().getPos().getY()-this.getPos().getY()) + Math.abs(pDekat.getData().getPos().getX()-this.getPos().getX()) < 1)
				{
					this.keluarKoin(C, pDekat.getData());
					pDekat.getData().makeDead();
					this.time = 0;
				}
				else
				{
					if ((Math.abs(p.getData().getPos().getY()-this.getPos().getY()) < Math.abs(pDekat.getData().getPos().getY()-this.getPos().getY()))&&
					(Math.abs(p.getData().getPos().getX()-this.getPos().getX()) < Math.abs(pDekat.getData().getPos().getX()-this.getPos().getX())))
					{
						pDekat = p;
					}
				}
				p = p.getNext();
			}
			while (p != null);
			
			if (this.time>mulaiLapar)
			{
				sudut = Math.atan2(pDekat.getData().getPos().getY()-this.getPos().getY(),pDekat.getData().getPos().getX()-this.getPos().getX());
				System.out.println(sudut);
				double xmov = this.getPos().getX()+this.getKecepatan()*Math.cos(sudut*180/Math.PI)*t;
				double ymov = this.getPos().getY()+this.getKecepatan()*Math.sin(sudut*180/Math.PI)*t;
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
	}
}