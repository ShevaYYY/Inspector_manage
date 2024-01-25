package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import myClusses.database;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button create, login;
    private FirebaseAuth mAuth;
    public void signing_up(String email, String password){
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener( this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {

                    Toast.makeText(MainActivity.this, "Авторизацію виконано успішно", Toast.LENGTH_SHORT).show();
                   if(database.getUserRole().equals("admin")) {
                        Intent intent = new Intent(MainActivity.this, main_admin.class);
                        startActivity(intent);
                    }
                   else
                    {
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(intent);}
                }
                else {Toast.makeText(MainActivity.this, "Авторизація не пройшла", Toast.LENGTH_SHORT).show();}
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database.init();
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextobjectname);
        password = findViewById(R.id.editTextTextPassword);
        create = findViewById(R.id.button2);
        login = findViewById(R.id.button);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registration.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()){
                    database.checkUser_role(email.getText().toString());
                    signing_up(email.getText().toString(), password.getText().toString());
                }
                else
                    Toast.makeText(MainActivity.this, "Введіть усі необхідні значення", Toast.LENGTH_SHORT).show();
            }
        });
    }
}