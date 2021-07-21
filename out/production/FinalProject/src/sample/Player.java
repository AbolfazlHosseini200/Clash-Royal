package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private int gems,money,xp;
    private String user,pass,name,email;
    private ArrayList<String> deck=new ArrayList<String>();

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Player(String user,String name,String pass,String email) {
        gems=0;
        xp=0;
        money=500;
        this.user=user;
        this.name=name;
        this.pass=pass;
        this.email=email;
    }

    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    public ArrayList<String> getDeck() {
        return deck;
    }
}

