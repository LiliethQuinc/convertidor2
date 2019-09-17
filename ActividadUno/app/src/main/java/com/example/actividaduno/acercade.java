package com.example.actividaduno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class acercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
    }

}
