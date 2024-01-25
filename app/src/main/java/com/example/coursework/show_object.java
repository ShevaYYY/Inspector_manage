package com.example.coursework;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class show_object extends AppCompatActivity{
    private TextView title, state,city,street,building;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_show);
        init2();
        getIntentPers2();

    }
    private void init2()
    {
        title = findViewById(R.id.textView70);
        state = findViewById(R.id.textView71);
        city = findViewById(R.id.textView72);
        street= findViewById(R.id.textView73);
        building = findViewById(R.id.textView74);

    }
    private void getIntentPers2()
    {
        Intent i=getIntent();
        if(i != null)
        {
            title.setText(i.getStringExtra("title"));
            state.setText(i.getStringExtra("state"));
            city.setText(i.getStringExtra("city"));
            street.setText(i.getStringExtra("street"));
            building.setText(i.getStringExtra("building"));


        }
    }

}
