package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Listener extends Thread{
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    public Listener(DataInputStream dataInputStream,DataOutputStream dataOutputStream)
    {
        this.dataInputStream=dataInputStream;
        this.dataOutputStream=dataOutputStream;
    }
    @Override
    public void run() {
        try {while (true)
        {
                String str=dataInputStream.readUTF();
            String[] parts = str.split("#");
            String func=parts[0];
            if(func.equals("enterMainMenu"))
                Controller.enterMainMenu();
            if(func.equals("userPassNotMatch"))
                Controller.userPassNotMatch();
        }} catch (IOException e) {
            e.printStackTrace();
        }
    }
}
