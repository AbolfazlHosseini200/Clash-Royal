package sample;

public class Barbarian extends Troops{
    public Barbarian(String url) {
        super(300.0,75,20,url,2);
        number=4;
        hitSpd=1.5;
        hp=300;
        dmg=75;
        rng=50;
    }
}
