package sample;

public class Troops extends Cards{
    String url;
    boolean isInRange=false;
    int number;
    public Troops(double hp,double dmg ,double rng,String url,double hitSpd)
    {
        super(hp,dmg,rng,url,hitSpd);
    }
}
