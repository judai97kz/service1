package com.judai.service1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1;
    Button send,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStartService();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickStopService();
            }
        });
    }

    private void mapping(){
        send = findViewById(R.id.btsend);
        clear = findViewById(R.id.clear);
        ed1 = findViewById(R.id.dataintent);
    }

    private void clickStartService(){
        Intent intent = new Intent(this,MyService.class);
        intent.putExtra("text",ed1.getText().toString().trim());
        startService(intent);
    }

    private void clickStopService(){
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }

}