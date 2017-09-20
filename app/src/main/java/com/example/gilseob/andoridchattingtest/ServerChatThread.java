/*
package com.example.gilseob.andoridchattingtest;

import android.content.Intent;
import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

*/
/**
 * Created by GILSEOB on 2017-07-09.
 *//*


public class ServerChatThread extends Thread {

    Socket soc;
    ServerSocket ssoc;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Protocol protocol;
    Intent intent = new Intent();


    public ServerChatThread(ServerSocket ssocs) {
        try {
        ssoc = ssocs;
        }catch (Exception e){
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            while(true) {
                Log.d("sever","클라이언트 기다리는 중");
                Log.d("server","Server : "+ssoc.getLocalSocketAddress());
                soc = ssoc.accept();
            }
        }catch (Exception e){
            Log.d("server","접속실패");
            e.printStackTrace();
            allClose();
        }
        Log.v("", soc.getInetAddress() + "에서 접속했습니다.");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oos = new ObjectOutputStream(soc.getOutputStream());
                    ois = new ObjectInputStream(soc.getInputStream());
                    protocol = new Protocol();
                    protocol = (Protocol) ois.readObject();
                    protocol.setServerIpcon(ssoc.getLocalSocketAddress().toString());
                    intent.putExtra("readData",protocol);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void sendMessage(){
        try{
            String sendText = intent.getStringExtra("sendText");
            protocol.setSendMessageText(sendText);
            oos.writeObject(protocol);
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
*/
