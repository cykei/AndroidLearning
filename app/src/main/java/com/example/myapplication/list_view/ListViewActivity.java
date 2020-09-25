package com.example.myapplication.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ArrayList<MovieData> movieDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Log.d("알림 : ","데이터 초기화 전");
        this.InitializeMovieData();
        Log.d("알림 : ","데이터 초기화 후");

        ListView listView = (ListView)findViewById(R.id.listView);
        final MovieAdapter myAdapter = new MovieAdapter(getApplicationContext(),movieDataList);

        Log.d("알림 : ","어댑터 설정 전");
        listView.setAdapter(myAdapter);
        Log.d("알림 : ","어댑터 설정 후");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(),
                        myAdapter.getItem(position).getMovieName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void InitializeMovieData()
    {
        movieDataList = new ArrayList<MovieData>();

        movieDataList.add(new MovieData(R.drawable.ic_launcher_background, "미션임파서블","15세 이상관람가"));
        movieDataList.add(new MovieData(R.drawable.ic_launcher_background, "아저씨","19세 이상관람가"));
        movieDataList.add(new MovieData(R.drawable.ic_launcher_background, "어벤져스","12세 이상관람가"));
    }
}