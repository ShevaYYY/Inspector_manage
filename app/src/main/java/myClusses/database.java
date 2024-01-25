package myClusses;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class database {
    static private DatabaseReference users;
    static private DatabaseReference inspections;
    static private DatabaseReference objects;
    static public String user_role;
    static public void init(){
        users = FirebaseDatabase.getInstance().getReference("Users");
        inspections = FirebaseDatabase.getInstance().getReference("Inspections");
        objects = FirebaseDatabase.getInstance().getReference("Objects");
    }
    static public void add_user(person person){
        users.push().setValue(person);
    }
    static public void add_object(object object){
        objects.push().setValue(object);
    }
    static public void add_inspection(inspection inspection){
        inspections.push().setValue(inspection);
    }
    static public void checkUser_role(String email){
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    if(dataSnapshot.getValue(person.class).getEmail().equals(email)){
                        user_role = dataSnapshot.getValue(person.class).getUser_role();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    static public void setUser_Role(String role){
        user_role = role;
    }
    static public String getUserRole(){
        return user_role;
    }

}
