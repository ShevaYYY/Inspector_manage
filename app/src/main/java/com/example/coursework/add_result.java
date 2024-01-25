package com.example.coursework;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import myClusses.inspection;



public class add_result extends AppCompatActivity {

    TextView declaration;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_result);
        init();


    }

        private void init()
    {
        declaration=findViewById(R.id.textView2);




        }



}
