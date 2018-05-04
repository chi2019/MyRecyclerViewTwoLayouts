package com.example.chanakya.myrecyclerviewtwolayouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Object> list;
    MyAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        list = new ArrayList<>();

        list.add(new Item1("Dany Targaryen", "Valyria"));
        list.add(new Item1("Rob Stark", "Winterfell"));
        list.add("http://i.imgur.com/7spzG.png");
        list.add(new Item1("Jon Snow", "Castle Black"));
        list.add("http://i.imgur.com/7spzG.png");
        list.add(new Item1("Tyrion Lanister", "King's Landing"));

        adapter = new MyAdapter(this,list);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}
