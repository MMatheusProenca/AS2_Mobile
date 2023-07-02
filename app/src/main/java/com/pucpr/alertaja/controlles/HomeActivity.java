package com.pucpr.alertaja.controlles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.pucpr.alertaja.R;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void abrirOutraView(View v) {
        Intent intent = new Intent(this, ListEvents.class);
        startActivity(intent);
    }

}