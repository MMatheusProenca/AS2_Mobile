package com.pucpr.alertaja;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import com.pucpr.alertaja.controlles.HomeActivity;
import com.pucpr.alertaja.controlles.ListEvents;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 3000; // Tempo de duração da splash screen em milissegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(homeIntent);
        }, SPLASH_TIMEOUT);
    }

}