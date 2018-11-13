package com.example.zain.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.zain.registration.Constants.users;

public class logInActivity extends AppCompatActivity {

    Button userLog;
    EditText userId, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userLog = findViewById(R.id.userLog);
        userId = findViewById(R.id.userId);
        userPass = findViewById(R.id.userPass);

        userLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userId.getText().toString();
                String pass = userPass.getText().toString();
                for(int i=0;i<users.size();i++) {
                    if(users.get(i).id.equals(id) && users.get(i).pass.equals(pass)) {
                        Intent in = new Intent(logInActivity.this, LoggedInActivity.class);
                        startActivity(in);
                        finish();
                    }
                }
                Toast.makeText(logInActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
