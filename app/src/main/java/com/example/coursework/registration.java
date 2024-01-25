package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import myClusses.database;
import myClusses.person;

public class registration extends AppCompatActivity {
    Button add;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText email, password, phone, name, surname, middle_name;
    RadioButton admin, inspector;
    public void registration() {
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String role;
                    if(admin.isChecked()){

                        role = "admin";
                    database.setUser_Role("admin");}
                    else{
                        role = "inspector";
                    database.setUser_Role("inspector");}
                    person person = new person(name.getText().toString(),surname.getText().toString(),middle_name.getText().toString(),email.getText().toString(),phone.getText().toString(),role);
                    database.add_user(person);

                    if(database.getUserRole().equals("admin")) {
                        Intent intent = new Intent(registration.this, inspections.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(registration.this, MainActivity3.class);
                        startActivity(intent);
                    }
                    Toast.makeText(registration.this, "Реєстрацію виконано успішно", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(registration.this, "Реєстрація не пройшла", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void init(){
        email = findViewById(R.id.editTextobjectname);
        password = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.editTextNumber);
        name = findViewById(R.id.editTextTextPersonName3);
        surname = findViewById(R.id.editTextTextPersonName4);
        middle_name = findViewById(R.id.editTextTextPersonName7);
        admin = findViewById(R.id.radioButton);
        inspector = findViewById(R.id.radioButton2);
        add = findViewById(R.id.button3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!email.getText().toString().isEmpty()&&!password.getText().toString().isEmpty()&&!phone.getText().toString().isEmpty()&&!name.getText().toString().isEmpty()&&!surname.getText().toString().isEmpty()&&(admin.isChecked()||inspector.isChecked())) {
                    registration();
                }
            }
        });
    }
}