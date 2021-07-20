package sample;

import java.net.URL;

public class Archer extends Troops{
    double number=2;
    double hitSpd=1.2;
    double hp=125;
    double dmg=33;
    double rng=100;
    Archer(String url) {
        super(125.0,33.0,100.0,url,1);
        speed=0.33;
    }
}
