// File : Siput.java
import java.util.Random;
public class Siput extends Benda{
	private int xdes;
	
    public Siput(double _x, double _y){
        super(_x,_y,30,'r');
        Random rand = new Random();
        xdes = rand.nextInt(640);
        System.out.println(xdes);
    }
    public void setXDes(int in){
        xdes = in;
    }
    public int getXDes(){
        return xdes;
    }
    public void gerak(double time_last){
        if(Math.abs(xdes-this.getPos().getX()) < 500 ){
			Random rand = new Random();
            xdes = rand.nextInt(640);
        } else if (xdes < this.getPos().getX()){
            this.setArah('1');
            this.setPos(this.getPos().getX()-(this.getKecepatan()*time_last),this.getPos().getY());
        } else {
            this.setArah('r');
            this.setPos(this.getPos().getX()+(this.getKecepatan()*time_last),this.getPos().getY());
        }
    }
    public int takeCoin(LList<Koin> C,double time_last)
	{
        ElmtLList<Koin> p = C.getFirst();
        int val = 0;
        if (p==null){
            this.gerak(time_last);
        } 
        else {
            boolean isDone = false;
            ElmtLList<Koin> pDekat = p;
            do {
                if (Math.abs(pDekat.getData().getPos().getY()-this.getPos().getY()) + Math.abs(pDekat.getData().getPos().getX()-this.getPos().getX()) < 5) {
                    val = val + pDekat.getData().getNilai();
                    System.out.println(val);
                    pDekat.getData().makeDead();
                    isDone = true;
                }
                else {
                    if ((Math.abs(p.getData().getPos().getY()-this.getPos().getY()) < Math.abs(pDekat.getData().getPos().getY()-this.getPos().getY()))&&
                    (Math.abs(p.getData().getPos().getX()-this.getPos().getX()) < Math.abs(pDekat.getData().getPos().getX()-this.getPos().getX()))){
                        pDekat = p;
                    }
                    p = p.getNext();
                }
            } while ((p != null) && (!isDone));
            if (!isDone) {
                if(pDekat.getData().getPos().getX() < this.getPos().getX()){
                    this.setArah('l');
                    this.setPos(this.getPos().getX()-(this.getKecepatan()*time_last),this.getPos().getY());
                    
                }else{
                    this.setArah('r');
                    this.setPos(this.getPos().getX()+(this.getKecepatan()*time_last),this.getPos().getY());                    
                }
            }
        }
	return val;
    }
}