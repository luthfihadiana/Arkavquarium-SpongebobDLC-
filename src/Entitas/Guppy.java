package Entitas;
public class Guppy extends Ikan
{
	private int tahap;
    private int Mmakan;

	public Guppy()
	{
		tahap = 1;
		Mmakan = 0;
		c = 0;
	}
	
	public Guppy(double _x,double _y)
	{
		super(_x,_y,3,'r',0);
		tahap = 1;
		Mmakan = 0;
	}
	
	public int getTahap()
	{
		return tahap;
	}
	
	public int getMMakan()
	{
		return Mmakan;
	}
	
	public void setTahap(int _tahap)
	{
		tahap = _tahap;
	}
	
	public void setMMakan(int _Mmakan)
	{
		Mmakan = _Mmakan;
	}
	
	public void tumbuh()
	{
		if(tahap < 3){
			tahap++;            
		}
	}
	public void keluarKoin(LList<Koin> C)
	{
		Koin k = new Koin(this.getTahap()*10, this.getPos().getX(), this.getPos().getY());
		C.add(k);
	}
	public void gerakMakan(LList<Makanan> A, LList<Koin> C)
	{
		ElmtLList<Makanan> p = A.getFirst();
		this.c++;
		if (this.c % 5000 == 0)
		{
			this.keluarKoin(C);
		}

		this.time++;
		long mulaiLapar = 500;
		if ((p == null)||(this.time<=mulaiLapar))
		{
			this.gerak();
		}
		else
		{
			ElmtLList<Makanan> pDekat = p;
			do{
				if (Math.abs(pDekat.getData().getPos().getY()-this.getPos().getY()) + Math.abs(pDekat.getData().getPos().getX()-this.getPos().getX()) <= 10)
				{
					this.time = 0; // nol-in lagi artinya ikan kenyang
					this.Mmakan++;
					if (Mmakan % 3 == 0) {
						this.tumbuh();
					}
					pDekat.getData().makeDead();
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
			if (this.time > mulaiLapar)
			{
                cariMakan(pDekat);
			}
		}
	}
}