package com.example.assignment_1_task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText pwd;
    private EditText username;
    private TextView info;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.su_emailAddress);
        username = (EditText) findViewById(R.id.su_PersonName);
        pwd = (EditText) findViewById(R.id.su_password);
        info = (TextView) findViewById(R.id.su_textView);
        signup = (Button) findViewById(R.id.signUp_btn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                saveUser(email,pwd,username);
            }
        });

    }

    private void saveUser(EditText userEmail, EditText userPwd, EditText userName){
        Intent intent= new Intent(MainActivity.this, MainActivity2.class);
        String email = userEmail.getText().toString();
        String pwd = userPwd.getText().toString();
        String name = userName.getText().toString();
        if (!checkEmail(email)) {
            Toast.makeText(getApplicationContext(),"Enter Correct Email",Toast.LENGTH_SHORT).show();
            this.recreate();
        } else if (!checkPwd(pwd)) {
            Toast.makeText(getApplicationContext(),"Weak Password",Toast.LENGTH_SHORT).show();
            this.recreate();
        } else {
            intent.putExtra("userEmail", email);
            intent.putExtra("userPwd", pwd);
            intent.putExtra("userName", name);
            Toast.makeText(getApplicationContext(), "Sign Up Successfully", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }
    private boolean checkPwd(String userPwd) {
        return null != userPwd && userPwd.length() >= 8;
    }
    private boolean checkEmail(String userEmail) {
        if (null == userEmail || userEmail.length() == 0) {
            return false;
        }
        Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher emailMatcher = emailPattern.matcher(userEmail);
        return emailMatcher.matches();
    }
}