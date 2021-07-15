package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private int gems,money;
    private String user,pass,name,email;

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Player(String user,String name,String pass,String email) {
        gems=0;
        money=500;
        this.user=user;
        this.name=name;
        this.pass=pass;
        this.email=email;
    }
}

