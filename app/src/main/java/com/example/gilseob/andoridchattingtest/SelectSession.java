package com.example.gilseob.andoridchattingtest;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import java.net.ServerSocket;

public class SelectSession extends Activity {


    Intent intent;
    int portNum = 7878;
    ServerSocket ssocs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selelct_session);
    }

   /* public void chooseServer(View v) {
        intent = new Intent(v.getContext(), MainActivity.class);
        sORc1 = 1;
        intent.putExtra("ServerOrClient", sORc1);
        try {
            ssocs = new ServerSocket(portNum);
            String ipAddress = getLocalIpAddress();
            Log.d("serverIP","IP:"+ipAddress);
            ServerChatThread sct = new ServerChatThread(ssocs);
            sct.start();
            Log.d("server", "서버 가동 중");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void chooseClient(View v) {
        intent = new Intent(v.getContext(), MainActivity.class);
        startActivity(intent);
    }

   /* public String getLocalIpAddress() {
        WifiManager wifiMgr = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        int ip = wifiInfo.getIpAddress();
        String ipAddress = String.format("%d.%d.%d.%d"
                , (ip & 0xff)
                , (ip >> 8 & 0xff)
                , (ip >> 16 & 0xff)
                , (ip >> 24 & 0xff));
        return ipAddress;
    }*/
}
