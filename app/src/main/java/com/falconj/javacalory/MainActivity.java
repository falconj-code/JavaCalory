package com.falconj.javacalory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<DataModel> mList;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_meal);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();

        List<String> breakfastList = new ArrayList<>();
        breakfastList.add("+  Add Breakfast");

        List<String> lunchList = new ArrayList<>();
        lunchList.add("+  Add Lunch");

        List<String> dinnerList = new ArrayList<>();
        dinnerList.add("+  Add Dinner");

        List<String> snackList = new ArrayList<>();
        snackList.add("+  Add Snack");

        mList.add(new DataModel(breakfastList, "Breakfast", R.drawable.ic_breakfast));
        mList.add(new DataModel(lunchList, "Lunch", R.drawable.ic_lunch));
        mList.add(new DataModel(dinnerList, "Dinner", R.drawable.ic_dinner));
        mList.add(new DataModel(snackList, "Snack", R.drawable.ic_snack));

        adapter = new ItemAdapter(mList);
        recyclerView.setAdapter(adapter);
    }
}