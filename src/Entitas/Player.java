package Entitas;
public class Player
{
    private int Telor;
    private int Uang;
    private boolean isPlaying;

    public Player(int telor, int uang, boolean isPlaying) {
        Telor = telor;
        Uang = uang;
        this.isPlaying = isPlaying;
    }

    public void setTelor(int Telor) {
        this.Telor = Telor;
    }
    public int getTelor() {
        return Telor;
    }
    public void setUang(int Uang) {
        this.Uang = Uang;
    }
    public int getUang() {
        return Uang;
    }
    public boolean Playing() {
        return isPlaying;
    }
    public void beliTelor(){
        Telor ++;
        buy(25);
    }
    public void getProfit(int value){
        Uang += value;
    }
    public void buy(int value){
        Uang -= value;
    }
}
