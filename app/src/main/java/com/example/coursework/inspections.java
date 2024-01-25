package com.example.coursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import myClusses.inspection;
import myClusses.person;

public class inspections extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspections);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewForInspectorInspections);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button watch_all = findViewById(R.id.button5);
        Button watch_implemented = findViewById(R.id.button4);
        Button watch_not_implemented = findViewById(R.id.button6);
        init();
        getDataFromBD();
        Button ADD_inspection=findViewById(R.id.button7);

        ADD_inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inspections.this, add_inspection.class);
                startActivity(intent);
            }
        });
        setOnClickItem();

    }


    private ListView ListViewInspections;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<inspection> listTemp;

    static private DatabaseReference inspections;
    private void init()
    {
        ListViewInspections=findViewById(R.id.ListViewInspections);
        listData=new ArrayList<>();
        listTemp=new ArrayList<>();

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        ListViewInspections.setAdapter(adapter);
        inspections= FirebaseDatabase.getInstance().getReference("Inspections");}
    private void getDataFromBD()
    {

        ValueEventListener vListener= new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(listData.size()>0)listData.clear();
                if(listTemp.size()>0)listTemp.clear();

                for(DataSnapshot ds: snapshot.getChildren())
                {
                    inspection inspection=ds.getValue(inspection.class);
                    //if(user.getUser_role().equals("inspector")){
                    assert inspection!=null;
                    //assert inspection.getDate_of_inspection()!=null;

                    listData.add(inspection.getObject().getTitle()+"\n"+inspection.getInspector().getSurname()+" "+inspection.getInspector().getName()+" "+inspection.getInspector().getMiddle_name()+"\n"+String.valueOf(inspection.getDate_of_inspection())/*+":"+String.valueOf(inspection.getDate_of_inspection().getMonth())+":"+String.valueOf(inspection.getDate_of_inspection().getYear())*/);
                    listTemp.add(inspection);
                }

                //}
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        if (inspections != null) {
            inspections.addValueEventListener(vListener);
        }



    }
    private void setOnClickItem()
    {
        String Future_B_Text="";
        ListViewInspections.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                             {
                                                 @Override
                                                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                     inspection inspection=listTemp.get(position);
                                                     Intent i =new Intent(inspections.this, inspection_show.class);
                                                     i.putExtra("user surname",inspection.getInspector().getSurname());
                                                     i.putExtra("user name",inspection.getInspector().getName());
                                                     i.putExtra("object tint",inspection.getObject().getTitle());
                                                     i.putExtra("object city",inspection.getObject().getCity());
                                                     i.putExtra("date",inspection.getDate_of_inspection());
                                                     i.putExtra("status",inspection.isIs_planned());
                                                    /* i.putExtra("result Declaration",inspection.getResult().getDeclaration());
                                                     i.putExtra("result Electroobladnannz",inspection.getResult().getElectroobladnannz());
                                                     i.putExtra("result Extinguishers",inspection.getResult().getExtinguishers());
                                                     i.putExtra("result Evacuation_ways",inspection.getResult().getEvacuation_ways());
                                                     i.putExtra("result Instruction",inspection.getResult().getInstruction());
                                                     i.putExtra("result Jornals_instruktaj",inspection.getResult().getJornals_instruktaj());
                                                     i.putExtra("result Kran_komplect",inspection.getResult().getKran_komplect());
                                                     i.putExtra("result Nakaz_rezhum",inspection.getResult().getNakaz_rezhum());
                                                     i.putExtra("result Nakaz_vidpovidalnogo",inspection.getResult().getNakaz_vidpovidalnogo());
                                                     i.putExtra("result Sygnalization",inspection.getResult().getSygnalization());
                                                     i.putExtra("result Opir_izolation",inspection.getResult().getOpir_izolation());*/

                                                     //if(inspection.isIs_planned().equals(false)){Future_B_Text="Результати перевірки";};



                                                     startActivity(i);




                                                 }
                                             }
        );

    }



}