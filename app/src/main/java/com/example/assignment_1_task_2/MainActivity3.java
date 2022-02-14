package com.example.assignment_1_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView welText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle bundle = getIntent().getExtras();
        String userEmail = bundle.getString("userEmail");
        String userName = bundle.getString("userName");

        welText = (TextView) findViewById(R.id.welcomeText);

        welText.setText(userEmail + "\n" + userName);
    }
}