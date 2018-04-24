package Entitas;
public class akuarium{
	private LList<Koin> Coins;
	private LList<Guppy> Guppys;
	private LList<Piranha> Piranhas;
	private LList<Makanan> Foods;
	private Siput snail;
    private Player player;
	public static final int SCREEN_HEIGHT = 480;
	public static final int SCREEN_WIDTH = 640;
    public akuarium() {
		Guppys = new LList<Guppy>();
		Piranhas = new LList<Piranha>(); 
		Foods = new LList<Makanan>(); 
		Coins = new LList<Koin>();
		Guppys.add(new Guppy(100,100));
		snail = new Siput(SCREEN_WIDTH/2,SCREEN_HEIGHT-40);
		player = new Player(0,100,true);
	}
	public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public Siput getSnail() {
        return snail;
    }

    public void setSnail(Siput snail) {
        this.snail = snail;
    }
	public LList<Guppy> getGuppy(){
		return Guppys;
	}
	public LList<Piranha> getPiranhas(){
		return Piranhas;
	}
	public LList<Makanan> getFoods(){
		return Foods;
	}
	public LList<Koin> getCoins(){
		return Coins;
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

	public void moveAll(){
		ElmtLList<Guppy> p = Guppys.getFirst();
		while(p != null){
			p.getData().gerakMakan(Foods,Coins);
			p = p.getNext();
		}
		ElmtLList<Piranha> q = Piranhas.getFirst();
		while(q != null){
			q.getData().gerakMakan(Guppys,Coins);
			q = q.getNext();
		}
		ElmtLList<Makanan> r = Foods.getFirst();
		while(r != null){
			r.getData().gerak();
			r = r.getNext();
		}
		ElmtLList<Koin> s = Coins.getFirst();
		while(s != null){
			s.getData().gerak();
			s = s.getNext();
		}
		int total = 0;
		snail.takeCoin(Coins,total);
		player.getProfit(total);
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
			if(r.getData().getPos().getY() >= SCREEN_HEIGHT){
				r.getData().makeDead();
			}
			r = r.getNext();
		}
	}
	public void fixAll(){
		this.fixCoin();
		this.fixGuppy();
		this.fixMakanan();
		this.fixPiranha();
	}
	public void resetAkuarium(){
        Guppys = new LList<Guppy>();
        Piranhas = new LList<Piranha>();
        Foods = new LList<Makanan>();
        Coins = new LList<Koin>();
        Guppys.add(new Guppy(100,100));
        snail = new Siput(SCREEN_WIDTH/2,SCREEN_HEIGHT-40);
        player = new Player(0,100,true);
    }
    public boolean isLose(){
        return player.getUang() <= 0;
    }
}