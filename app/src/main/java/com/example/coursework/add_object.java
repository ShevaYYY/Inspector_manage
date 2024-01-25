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
import myClusses.object;
import myClusses.person;
public class add_object extends AppCompatActivity {


    Button add;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText  title, state,city,street,building;

    public void registration()
    {

        object object = new object(title.getText().toString(),state.getText().toString(),city.getText().toString(),street.getText().toString(),building.getText().toString());
        database.add_object(object);


    }


    void init(){
        title = findViewById(R.id.editTextobjectname10);
        state = findViewById(R.id.editTextobjectname2);
        city = findViewById(R.id.editTextobjectname3);
        street = findViewById(R.id.editTextobjectname4);
        building = findViewById(R.id.editTextobjectname5);

        add = findViewById(R.id.button15);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_object);
        init();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!title.getText().toString().isEmpty()&&!state.getText().toString().isEmpty()&&!city.getText().toString().isEmpty()&&!street.getText().toString().isEmpty()) {
                    registration();
                    Toast.makeText(add_object.this, "Об'єкт додано", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(add_object.this, "Не вдалось додати об'єкт", Toast.LENGTH_SHORT).show();
                }
                }

        });


}}
