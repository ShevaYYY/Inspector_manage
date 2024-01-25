package com.example.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import myClusses.person;

public class users extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewForInspectorInspections);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        init();
        getDataFromBD();

        Button ADD_user=findViewById(R.id.button12);

        ADD_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(users.this, registration.class);
                startActivity(intent);
            }
        });
        setOnClickItem();

    }

    private ListView listViewusers;
    private ArrayAdapter <String> adapter;
    private List<String> listData;
    private List<person> listTemp;

    static private DatabaseReference users;
    private void init()
    {
        listViewusers=findViewById(R.id.ListView);
        listData=new ArrayList<>();
        listTemp=new ArrayList<>();

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        listViewusers.setAdapter(adapter);
        users= FirebaseDatabase.getInstance().getReference("Users");}
        private void getDataFromBD()
    {

        ValueEventListener vListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(listData.size()>0)listData.clear();
                if(listTemp.size()>0)listTemp.clear();

                for(DataSnapshot ds: snapshot.getChildren())
                {
                   person user=ds.getValue(person.class);
                   //if(user.getUser_role().equals("inspector")){
                   assert user!=null;
                   listData.add(user.getSurname()+" "+user.getName()+" "+user.getMiddle_name());
                   listTemp.add(user);
                }

                //}
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        if (users != null) {
            users.addValueEventListener(vListener);
        }



    }
    private void setOnClickItem()
    {
        listViewusers.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                             {
                                                 @Override
                                                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                     person user=listTemp.get(position);
                                                     Intent i =new Intent(users.this, show_person.class);
                                                     i.putExtra("user surname",user.getSurname());
                                                     i.putExtra("user name",user.getName());
                                                     i.putExtra("user midlename",user.getMiddle_name());
                                                     i.putExtra("user email",user.getEmail());
                                                     i.putExtra("user phone",user.getPhone());
                                                     i.putExtra("user status",user.getUser_role());
                                                     startActivity(i);




                                                 }
                                             }
        );

    }



}