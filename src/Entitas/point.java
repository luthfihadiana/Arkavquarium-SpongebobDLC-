// File  : point.java
package Entitas;
public class point{
    private double x;
    private double y;

    public point(){
        this.x = 0;
        this.y = 0;
    }
    public point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public boolean isSamepoint(point p){
        return (this.x == p.x && this.y == p.y);
    }
    public double distance(point p){
        double hsl;
        hsl = Math.sqrt((this.x-p.x*this.x-p.x)+(this.y-p.y*this.y-p.y));
        return hsl;
    }
	public point add(point P)
	{
		return new point(x + P.x, y + P.y);
	}
    public point minus(point P)
	{
		return new point(x - P.x, y - P.y);
    }

}