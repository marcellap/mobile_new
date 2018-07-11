package com.example.svilupposw.camera2.activity;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.svilupposw.camera2.R;
import com.example.svilupposw.camera2.adapters.showDataAdapter;
import com.example.svilupposw.camera2.adapters.ShowDataCardAdapter;
import com.example.svilupposw.camera2.models.Rifornimento;

import java.util.ArrayList;

/**
 * Created by svilupposw on 05/04/18.
 */

public class ShowCardActivity extends AppCompatActivity {

    private RecyclerView myShowDataList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);

        myShowDataList = findViewById(R.id.list);

        ArrayList<Rifornimento> data = new ArrayList<>();

        Rifornimento r = new Rifornimento("Eni",30.0);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);
        data.add(r);

        ShowDataRecyclerAdapter adapter = new ShowDataRecyclerAdapter(getApplicationContext(),data);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myShowDataList.setLayoutManager(linearLayoutManager);

        myShowDataList.setAdapter(adapter);

        }


}
