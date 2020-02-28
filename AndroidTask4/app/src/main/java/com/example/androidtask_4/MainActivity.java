package com.example.androidtask_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

import android.os.Bundle;
import android.os.Handler;
import android.widget.AbsListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity<listItems> extends AppCompatActivity {
    ArrayList<String> list;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    LinearLayoutManager manager;
     String[] listItems;
    boolean isScrolling = false;
    int currentItems,scrolledItems,totalItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        listItems= new String[]{"Akaanksha Gupta","Ankit Arora", "Anupam Bharadwaj","Ashutosh Srivastava","Astha Singh","Bharat TTN","Lakshya Sharma","Naveen Verma","Priya Patel","Subarno Chatterjee","Tanvi Gupta","Ujjwal Kumar"};

 list = new ArrayList<>(Arrays.asList(listItems));
        adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrolledItems= manager.findFirstVisibleItemPosition();
                if(isScrolling && (currentItems+scrolledItems==totalItems))
                {
                    isScrolling = false;
                    fetchdata();
                }
            }
        });
    }

    private void fetchdata() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++)
                    list.add("NEW NAME "+i);
                adapter.notifyDataSetChanged();

            }
        }, 5000);
    }
}
