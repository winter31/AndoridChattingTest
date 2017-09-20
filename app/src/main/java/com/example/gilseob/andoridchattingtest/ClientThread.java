package com.example.gilseob.andoridchattingtest;

import android.content.Intent;
import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by GILSEOB on 2017-07-09.
 */

public class ClientThread extends Thread {

    Socket soc;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    int portNum = 7878;
    Intent intent ;
    String textt;


    @Override
    public void run() {
        super.run();
        try {
            soc = new Socket("203.233.196.31", portNum);
            Log.d("client","접속 성공");
            oos = new ObjectOutputStream(soc.getOutputStream());
            ois = new ObjectInputStream(soc.getInputStream());
                try{
                    textt = (String)ois.readObject();
                }catch (Exception e){
                    e.printStackTrace();
                }
                String tttt = intent.getStringExtra("sendData");
                oos.writeObject(tttt);
        }catch (Exception e  ){
            Log.d("클리언트", "접속 끊킴");
            e.printStackTrace();
            allClose();
        }
    }

    public void sendMessage(String text1){
        try{
            oos.writeObject(text1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void allClose(){
        try{
            oos.close();
            ois.close();
            soc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
