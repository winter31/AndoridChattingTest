package com.example.gilseob.andoridchattingtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.os.Bundle;

public class MainPage extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        final Intent intent = new Intent(MainPage.this, SelectSession.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}
