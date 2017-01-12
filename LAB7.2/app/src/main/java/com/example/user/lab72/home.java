package com.example.user.lab72;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {
    protected Button next,exit;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        next =(Button)findViewById(R.id.next);
        exit =(Button)findViewById(R.id.exit);
        next.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                intent.setClass(home.this, MainActivity.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(  );
                intent.setClass(home.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
