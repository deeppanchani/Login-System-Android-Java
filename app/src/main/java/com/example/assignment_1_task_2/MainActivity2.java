package com.example.assignment_1_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText e_uid;
    private EditText e_pwd;
    private TextView si_info;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        String userEmail = bundle.getString("userEmail");
        String userName = bundle.getString("userName");
        String userPwd = bundle.getString("userPwd");

        e_uid = (EditText) findViewById(R.id.si_uid);
        e_pwd = (EditText) findViewById(R.id.si_password);
        si_info = (TextView) findViewById(R.id.si_textView);
        signin = (Button) findViewById(R.id.signIn_btn);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                validate(e_uid, e_pwd, userEmail, userName, userPwd);
            }
        });

    }

    private void validate(EditText e_Email, EditText e_Pwd, String userEmail, String userName, String userPwd){
        String email = e_Email.getText().toString();
        String pwd = e_Pwd.getText().toString();
        if((email.equals(userEmail) || email.equals(userName)) && pwd.equals(userPwd)){
            Intent intent= new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("userEmail", userEmail);
            intent.putExtra("userName", userName);
            Toast.makeText(getApplicationContext(),"Sign In Successfully",Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        } else {
            Intent intent= new Intent(MainActivity2.this, MainActivity.class);
            Toast.makeText(getApplicationContext(),"Sign In Unsuccessfully. Try Again.",Toast.LENGTH_SHORT).show();
            this.recreate();
        }
    }

}