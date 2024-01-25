package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class inspection_show extends AppCompatActivity {

    private TextView inspector,object,date,status;

    Boolean zap=false;
    Button b;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspection);
        init();
        getIntentPers();
        b=findViewById(R.id.button114);
        if(zap==true)b.setText("Почати перевірку");else b.setText("Результати");
        Intent intent;

        if(zap==true){b.setText("Почати перевірку");
            intent = new Intent(inspection_show.this, add_result.class);
        }
        else{ b.setText("Результати"); intent = new Intent(inspection_show.this, show_result.class);}


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });
    }
    private void init()
    {
        inspector = findViewById(R.id.textView115);
        object = findViewById(R.id.textView114);
        date = findViewById(R.id.textView106);
        status = findViewById(R.id.textView15);
        b=findViewById(R.id.button114);


    }
    private void getIntentPers()
    {
        Intent i=getIntent();
        if(i != null)
        {
            inspector.setText(i.getStringExtra("user surname")+" "+i.getStringExtra("user name"));
            object.setText(i.getStringExtra("object tint")+" "+i.getStringExtra("object city"));
            date.setText(i.getStringExtra("date"));
            status.setText(i.getStringExtra("status"));
            if(status.getText().equals("Запланована"))zap=true;


        }
    }
}