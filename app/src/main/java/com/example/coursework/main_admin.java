package com.example.coursework;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class main_admin extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_admin);

            Button to_inspection=findViewById(R.id.button10);
            Button to_objects=findViewById(R.id.button9);
            Button to_inspectors=findViewById(R.id.button8);

            to_inspection.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(main_admin.this, inspections.class);
                    startActivity(intent);
                }
            });
            to_objects.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(main_admin.this, objects.class);
                    startActivity(intent);
                }
            });
            to_inspectors.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(main_admin.this, users.class);
                    startActivity(intent);
                }
            });

        }



    }

