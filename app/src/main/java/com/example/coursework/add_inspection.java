package com.example.coursework;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.time.LocalDate;
import java.util.Date;

import myClusses.database;
import myClusses.result;
import myClusses.inspection;
import myClusses.object;
import myClusses.person;


public class add_inspection extends AppCompatActivity {
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter;
    private List<String> listData2;
    private List<object> listTemp2;
    private List<String> listData;
    private List<person> listTemp;
    Button add;
    person User;
    object Object;
    Date date;
    Boolean changed=false;
    LocalDate currentDate = LocalDate.now(); // отримуємо поточну дату





    Date convertedDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());



    static private DatabaseReference users;
    static private DatabaseReference objects;

    static private DatabaseReference inspections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_inspection);



        // Initialize the lists




        init();
        getDataFromBD();
        getDataFromBD2();

        Spinner sp_objects = findViewById(R.id.spinnerobject);
        Spinner sp_inspectors = findViewById(R.id.spinnerinspector);
        sp_objects.setAdapter(adapter2);
        sp_inspectors.setAdapter(adapter);
        sp_objects.setPrompt("Виберіть об'єкт");
        sp_inspectors.setPrompt("Виберіть інспектора");
        sp_objects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(), adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                 Object= listTemp2.get(position);
                Intent i =new Intent(add_inspection.this, show_object.class);
                i.putExtra("title", Object.getTitle());
                i.putExtra("state",Object.getState());
                i.putExtra("city",Object.getCity());
                i.putExtra("street",Object.getStreet());
                i.putExtra("building",Object.getBuilding());

                //startActivity(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp_inspectors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getBaseContext(), adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                   User=listTemp.get(position);
                    Intent i =new Intent(add_inspection.this, show_person.class);
                    i.putExtra("user surname",User.getSurname());
                    i.putExtra("user name",User.getName());
                    i.putExtra("user midlename",User.getMiddle_name());
                    i.putExtra("user email",User.getEmail());
                    i.putExtra("user phone",User.getPhone());
                    i.putExtra("user status",User.getUser_role());
                    //startActivity(i);

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User!=null&&Object!=null) {
                    //if(date.equals(null))date=convertedDate;
                    if(changed==false)date=convertedDate;
                    registration(User,Object,date);
                    Toast.makeText(add_inspection.this, "Перевірку додано", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(add_inspection.this, "Не вдалось додати Перевірку", Toast.LENGTH_SHORT).show();
                }

                person p=new person("fhgfhgghf","dfg","fdsffd","fdsfdf","fsdfd","fdsfd");
                object o=new object("fsdf","fdsfs","fdsfs","fsdf","fdsfd");


                LocalDate currentDate = LocalDate.now(); // отримуємо поточну дату


                Date convertedDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                //registration(p,o,convertedDate);
            }

        });
    }

    private void init()
    {
        //listViewusers=findViewById(R.id.ListView);
        listData2 = new ArrayList<>();
        listTemp2 = new ArrayList<>();
        listData = new ArrayList<>();
        listTemp = new ArrayList<>();

        add = findViewById(R.id.button13);

        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listData2);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listData);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner sp_objects = findViewById(R.id.spinnerobject);
        Spinner sp_inspectors = findViewById(R.id.spinnerinspector);
        CalendarView calendarView= findViewById(R.id.calendarView);

        sp_objects.setAdapter(adapter2);
        sp_inspectors.setAdapter(adapter);
        users= FirebaseDatabase.getInstance().getReference("Users");
        objects= FirebaseDatabase.getInstance().getReference("Objects");
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                changed=true;
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                date = calendar.getTime();
            }
        });

    }


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
                    if(user.getUser_role().equals("inspector")){
                    assert user!=null;
                    listData.add(user.getSurname()+" "+user.getName()+" "+user.getMiddle_name());
                    listTemp.add(user);}
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
    private void getDataFromBD2()
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
                    listData2.add(obj.getTitle()+obj.getCity());
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
    public void registration(person inspector, object object, @NonNull Date Date )
    {

        LocalDate currentDate = LocalDate.now(); // отримуємо поточну дату





        Date convertedDate = Date.from(currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        result r=new result();
        //result r2d2=new result(true,true,true,true,true,true,true,true,true,true,true);

        inspection inspection= new inspection(inspector,object,convertedDate,Date,"Запланована",r);
        database.add_inspection(inspection);


    }





}
