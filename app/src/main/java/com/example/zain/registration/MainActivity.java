package com.example.zain.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.zain.registration.Constants.users;
import com.example.zain.registration.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button signUp, logIn;
    EditText nameText, idText, passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = findViewById(R.id.signUp);
        nameText = findViewById(R.id.name);
        idText = findViewById(R.id.id);
        passText = findViewById(R.id.pass);
        logIn = findViewById(R.id.logIn);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString();
                String pass = passText.getText().toString();
                String id = idText.getText().toString();
                if(name.length() == 0 || pass.length() == 0 || id.length() == 0) {
                    Toast.makeText(MainActivity.this, "Fill The Fields", Toast.LENGTH_SHORT).show();
                }else {
                    User newUser = new User(name, id, pass);
                    users = new ArrayList<>();
                    users.add(newUser);
                    Intent i = new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, logInActivity.class);
                startActivity(i);
            }
        });
    }
}
