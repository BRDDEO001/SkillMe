package com.example.skillmesa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_cities);
        new FirebaseDB().readCities(new FirebaseDB.DataStatus() {
            @Override
            public void isLoaded(List<City> cities, List<String> keys) {
                new RecyclerView_Config().setConfig(recyclerView,MainActivity.this ,cities, keys);
            }

            @Override
            public void isInserted() {

            }

            @Override
            public void isUpdated() {

            }

            @Override
            public void isDeleted() {

            }
        });

    }
}