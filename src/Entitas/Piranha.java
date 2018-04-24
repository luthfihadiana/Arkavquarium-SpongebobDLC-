package Entitas;
public class Piranha extends Ikan
{
	public Piranha(double _x , double _y)
	{
		super(_x,_y,3,'r',0);
	}

	public void keluarKoin(LList<Koin> C, Guppy G)
	{
		Koin k = new Koin(G.getTahap()*100, this.getPos().getX(), this.getPos().getY());
		C.add(k);
	}
	public void gerakMakan(LList<Guppy> A, LList<Koin> C)
	{
		this.c++;
		this.time++;
		long mulaiLapar = 500;
		ElmtLList<Guppy> p = A.getFirst();
		if ((p == null)||(this.time<=mulaiLapar))
		{
			this.gerak();
		}
		else
		{
			ElmtLList<Guppy> pDekat = p;
			do
			{
				if (Math.abs(pDekat.getData().getPos().getY()-this.getPos().getY()) + Math.abs(pDekat.getData().getPos().getX()-this.getPos().getX())<= 10)
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
				cariMakan(pDekat);
			}
		}
	}
}