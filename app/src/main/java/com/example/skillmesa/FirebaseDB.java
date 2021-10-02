package com.example.skillmesa;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDB {
     private FirebaseDatabase db;
     private DatabaseReference ref;
     private List<City> cities = new ArrayList<>();

     public interface DataStatus{
         void isLoaded(List<City> cities, List<String> keys);
         void isInserted();
         void isUpdated();
         void isDeleted();


     }
     public FirebaseDB(){
         db = FirebaseDatabase.getInstance();
         ref = db.getReference("cities");
     }

     public void readCities(final DataStatus datastatus){
         ref.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull  DataSnapshot snapshot) {
               cities.clear();
               List <String> keys = new ArrayList<>();
               for(DataSnapshot keyNode: snapshot.getChildren()){
                   keys.add(keyNode.getKey());
                   City city = keyNode.getValue(City.class);
                   cities.add(city);
               }
                datastatus.isLoaded(cities, keys);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });
     }


}
