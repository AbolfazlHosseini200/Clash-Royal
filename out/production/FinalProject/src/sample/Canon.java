package sample;

public class Canon extends Buildings{
    public Canon(String url) {
        super(380,60,50,url,1);
        hitSpd=0.8;
        rng=10;
        dur=30;
        hp=380;
        dmg=60;
    }
}
