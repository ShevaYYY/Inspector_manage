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


import myClusses.object;

public class objects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.objects);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewForInspectorInspections);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        init();
        getDataFromBD();

        Button ADD_object=findViewById(R.id.button11);

        ADD_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(objects.this, add_object.class);
                startActivity(intent);
            }
        });
        setOnClickItem2();

    }

    private ListView listViewobjects;
    private ArrayAdapter<String> adapter2;
    private List<String> listData2;
    private List<object> listTemp2;

    static private DatabaseReference objects;
    private void init()
    {
        listViewobjects =findViewById(R.id.ListView2);
        listData2 =new ArrayList<>();
        listTemp2 =new ArrayList<>();

        adapter2 =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listData2);
        listViewobjects.setAdapter(adapter2);
        objects= FirebaseDatabase.getInstance().getReference("Objects");}
    private void getDataFromBD()
    {

        ValueEventListener vListener2= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(listData2.size()>0) listData2.clear();
                if(listTemp2.size()>0) listTemp2.clear();

                for(DataSnapshot ds2: snapshot.getChildren())
                {
                    object obj=ds2.getValue(object.class);
                    //if(user.getUser_role().equals("inspector")){
                    assert obj!=null;
                    listData2.add(obj.getTitle());
                    listTemp2.add(obj);
                }

                //}
                adapter2.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        if (objects != null) {
            objects.addValueEventListener(vListener2);
        }




    }
    private void setOnClickItem2()
    {
        listViewobjects.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                             {
                                                 @Override
                                                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                     object object= listTemp2.get(position);
                                                     Intent i =new Intent(objects.this, show_object.class);
                                                     i.putExtra("title", object.getTitle());
                                                     i.putExtra("state",object.getState());
                                                     i.putExtra("city",object.getCity());
                                                     i.putExtra("street",object.getStreet());
                                                     i.putExtra("building",object.getBuilding());

                                                     startActivity(i);




                                                 }
                                             }
        );

    }


}
