public class akuarium{
	private LList<Koin> Coins;
	private LList<Guppy> Guppys;
	private LList<Piranha> Piranhas;
	private LList<Makanan> Foods;
	private int width;
	private int length;
	private Siput snail;
	public static final int SCREEN_HEIGHT = 480;
	public static final int SCREEN_WIDTH = 640;

	public akuarium(int W,int L) {
		//LList??
		Guppys = new LList<Guppy>();
		Piranhas = new LList<Piranha>(); 
		Foods = new LList<Makanan>(); 
		Coins = new LList<Koin>(); 
		this.width = W;
		this.length = L;
		snail = new Siput(SCREEN_WIDTH/2,SCREEN_HEIGHT);
		//siput??
	}
	public LList<Guppy> getGuppy(){
		return Guppys;
	}
	public LList<Piranha> getPiranhas(){
		return
		Piranhas;
	}
	public LList<Makanan> getFoods(){
		return Foods;
	}
	public LList<Koin> getCoins(){
		return Coins;
	}
	
	public int getLength() {
		return this.length;
	}
	public int getWidth() {
		return this.width;
	}
	public void setWidth(int W) {
		this.width = W;
	}
	public void setLength(int L) {
		this.length = L;
	}
	public void addGuppy(Guppy G) {
		this.Guppys.add(G);
	}
	public void addPiranha(Piranha P) {
		this.Piranhas.add(P);
	}
	public void addCoin(Koin C) {
		this.Coins.add(C);
	}
	public void addMakanan(Makanan F) {
		this.Foods.add(F);
	}

	public void fixGuppy() {
		ElmtLList<Guppy> P = Guppys.getFirst();
		ElmtLList<Guppy> Prec = null;
		while(P != null){
			if(!P.getData().getLife()){
				if(Prec == null){
					Guppys.setFirst(P.getNext());
					P = Guppys.getFirst();
				}else{
					Prec.setNext(P.getNext());
					P = Prec.getNext();
				}
			}else{
				Prec = P;
				P = P.getNext();
			}	
		}
	}
	public void fixPiranha() {
		ElmtLList<Piranha> P = Piranhas.getFirst();
		ElmtLList<Piranha> Prec = null;
		while(P != null){
			if(!P.getData().getLife()){
				if(Prec == null){
					Piranhas.setFirst(P.getNext());
					P = Piranhas.getFirst();
				}else{
					Prec.setNext(P.getNext());
					P = Prec.getNext();
				}
			}else{
				Prec = P;
				P = P.getNext();
			}	
		}
	}
	public void fixCoin() {
		ElmtLList<Koin> Pt = Coins.getFirst();
		ElmtLList<Koin> Prec = null;
		while(Pt != null){
			if(!Pt.getData().getLife()){
				if(Prec == null){
					Coins.setFirst(Pt.getNext());
					Pt = Coins.getFirst();
				}else{
					Prec.setNext(Pt.getNext());
					Pt = Prec.getNext();
				}
			}else{
				Prec = Pt;
				Pt = Pt.getNext();
			}	
		}
	}
	public void fixMakanan() {
		ElmtLList<Makanan> Pt = Foods.getFirst();
		ElmtLList<Makanan> Prec = null;
		while(Pt != null){
			if(!Pt.getData().getLife()){
				if(Prec == null){
					Foods.setFirst(Pt.getNext());
					Pt = Foods.getFirst();
				}else{
					Prec.setNext(Pt.getNext());
					Pt = Prec.getNext();
				}
			}else{
				Prec = Pt;
				Pt = Pt.getNext();
			}	
		}
	}

	public int moveAll(double timeLast){
		ElmtLList<Guppy> p = Guppys.getFirst();
		while(p != null){
			p.getData().gerakMakan(Foods,timeLast, Coins);
			p = p.getNext();
		}
		ElmtLList<Piranha> q = Piranhas.getFirst();
		while(q != null){
			q.getData().gerakMakan(Guppys,timeLast, Coins);
			q = q.getNext();
		}
		ElmtLList<Makanan> r = Foods.getFirst();
		while(r != null){
			r.getData().turun(timeLast);
			r = r.getNext();
		}
		ElmtLList<Koin> s = Coins.getFirst();
		while(s != null){
			s.getData().turun(timeLast);
			s = s.getNext();
		}
		return snail.takeCoin(Coins,timeLast);
	}
	public void drawAll(){
		ElmtLList<Guppy> p = Guppys.getFirst();
		while(p != null){
//			p.getData().draw();
			p = p.getNext();
		}
		ElmtLList<Piranha> q = Piranhas.getFirst();
		while(q != null){
//			q.getData().draw();
			q = q.getNext();
		}
		ElmtLList<Makanan> r = Foods.getFirst();
		while(r != null){
//			r.getData().draw();
			r = r.getNext();
		}
		ElmtLList<Koin> s = Coins.getFirst();
		while(s != null){
//			s.getData().draw();
			s = s.getNext();
		}
//		snail.draw();
	}
	public void makeDead(){
		ElmtLList<Guppy> p = Guppys.getFirst();
		while(p != null){
			if(p.getData().getCC() > 1500){
				p.getData().makeDead();
			}
			p = p.getNext();
		}
		ElmtLList<Piranha> q = Piranhas.getFirst();
		while(q != null){
			if(q.getData().getCC() > 1500){
				q.getData().makeDead();
			}
			q = q.getNext();
		}
		ElmtLList<Makanan> r = Foods.getFirst();
		while(r != null){
			if((r.getData().getPos().getX() - 640)>1){
				r.getData().makeDead();
			}
			r = r.getNext();
		}
		// snail.gerak(timeLast);
	}
	public boolean isPosValid(double x,double y) {
		return ((x>=0)&&(x<=this.length)&&(y>=0)&&(y<=this.width));
	}
}