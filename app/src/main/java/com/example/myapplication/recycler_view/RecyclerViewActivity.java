package com.example.myapplication.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        context = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 1. 리스트에 보여줄 데이터 준비
        ArrayList<CardItem> items = new ArrayList<>();
        items.add(new CardItem(R.drawable.ic_launcher_background,"미키마우스"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"인어공주"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"디즈니공주"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"토이스토리"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"니모를 찾아서"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"악마는 프라드를 입는다"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"미션임파서블"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"아저씨"));
        items.add(new CardItem(R.drawable.ic_launcher_background,"어벤져스"));

        // 2. 리스트 레이아웃 설정
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // layoutManager = new LinearLayoutManager(this);
        // layoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(context,items);
        recyclerView.setAdapter(adapter);

    }
}