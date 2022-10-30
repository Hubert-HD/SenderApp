package com.example.senderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MESSAGE_EXTERNAL_ACTION = "send_message_external";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSender = findViewById(R.id.btnSender);

        btnSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = etMessage.getText().toString();
                Intent intent = new Intent(MESSAGE_EXTERNAL_ACTION);
                intent.putExtra("message", message);
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
            }
        });
    }
}