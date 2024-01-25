package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class show_person extends AppCompatActivity {

    private TextView surname,name,middle_name,email,phone,user_role;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_show);
        init();
        getIntentPers();
    }
    private void init()
    {
        surname = findViewById(R.id.textView16);
        name = findViewById(R.id.textView17);
        middle_name = findViewById(R.id.textView18);
        email = findViewById(R.id.textView19);
        phone = findViewById(R.id.textView20);
        user_role = findViewById(R.id.textView21);

    }
    private void getIntentPers()
    {
        Intent i=getIntent();
        if(i != null)
        {
            surname.setText(i.getStringExtra("user surname"));
            name.setText(i.getStringExtra("user name"));
            middle_name.setText(i.getStringExtra("user midlename"));
            email.setText(i.getStringExtra("user email"));
            phone.setText(i.getStringExtra("user phone"));
            user_role.setText(i.getStringExtra("user status"));

        }
    }
}
