package sample;

import java.net.URL;

public class Cards{
    public boolean isInRange=false;
    public double hitSpd;
    double hp;
     double dmg;
     double rng;
    String url;

    public Cards(double hp, double dmg, double rng, String url,double hitSpd) {
        this.hp = hp;
        this.dmg = dmg;
        this.rng = rng;
        this.url = url;
        this.hitSpd=hitSpd;
    }

    public String getUrl() {
        return url;
    }
}
