package com.example.gilseob.andoridchattingtest;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by GILSEOB on 2017-07-08.
 */

public class MainActivity extends AppCompatActivity{

    Socket soc;
    EditText messageText ;
    static Button sendbtn1;
    StringBuffer textHelper = new StringBuffer();
    TextView textView;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    String sendMessages;
    String receiveMessage;
    Handler handler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSocket();

        sendbtn1 = (Button) findViewById(R.id.sendMessage);
        textView = (TextView) findViewById(R.id.textView);
        messageText = (EditText) findViewById(R.id.messageText);

        sendbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sendMessages = messageText.getText().toString();
                            Log.d("메세지", "Client : " + sendMessages);
                            oos.writeObject(sendMessages);
                            String content = "Client : " + sendMessages + "\n";
                            textHelper.append(content);
                            runOnUiThread(new Runnable(){
                                @Override
                                public void run() {
                                    textView.setText(textHelper.toString());
                                }
                            });

                            receiveMessage = (String) ois.readObject();
                            Log.d("Server", "Server:" + receiveMessage);
                            textHelper.append("Server : " + receiveMessage + "\n");
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(textHelper.toString());
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {


                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();*/
    }



    public void setSocket(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("client", "서버 접속 중");
                    soc = new Socket("203.233.196.180", 7878);
                    Log.d("","접속 성공");
                    oos = new ObjectOutputStream(soc.getOutputStream());;
                    ois = new ObjectInputStream(soc.getInputStream());
                }catch (Exception e){
                    Log.d("","접속 실패");
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
