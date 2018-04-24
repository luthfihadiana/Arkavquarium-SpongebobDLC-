//Benda.java
import java.util.Random;
import java.lang.*;

public abstract class Benda
{
	protected point Pos;
	protected int Kecepatan;
	protected char Arah;
	protected boolean isLife;
	public static final int SCREEN_HEIGHT = 480;
	public static final int SCREEN_WIDTH = 640;
	
	public Benda(){
  
	}
	public Benda(double _x ,double _y ,int _kecepatan ,char _arah){
		Pos.setX(_x);
		Pos.setY(_y);
		isLife = true;
		Kecepatan = _kecepatan;
		Arah = _arah;
	}
	public point getPos(){
		return Pos;
	}
	public int getKecepatan(){
		return Kecepatan;
	}
	public boolean getLife(){
		return isLife;
	}
	public char getArah(){
		return Arah;
	}
	public void makeDead(){
		isLife = !isLife;
	}
	public void setPos(double _x , double _y){
		Pos.setX(_x);
		Pos.setY(_y); 
	}
	public void setKecepatan(int _kecepatan){
		Kecepatan = _kecepatan;
	}
	public void setArah(char _arah){
		Arah = _arah;
	}
}