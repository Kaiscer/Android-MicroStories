package com.example.microcuento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.microcuento.model.DataSource;
import com.example.microcuento.model.Story;
import com.example.microcuento.utilrv.StoryAdapter;

import java.util.ArrayList;


public class ChooseStoryActivity extends AppCompatActivity implements View.OnClickListener {


    public static final String KEY_STORY = "STORY_SEL";
    RecyclerView rv;
    StoryAdapter adapter;
    RecyclerView.LayoutManager llm;

    DataSource dataSource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elige_cuento);

        rv = findViewById(R.id.rv_Cuento);
        configRV();


    }

    private void configRV() {
        // Configuramos el RecyclerView
        //1 - Va a tener el tamaño fijo
        rv.setHasFixedSize(true);
        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        dataSource = new DataSource();
        adapter = new StoryAdapter(dataSource.getListStory(), this);
        rv.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        int pos = rv.getChildAdapterPosition(v);
        Story storySelected = dataSource.getListStory().get(pos);

        Intent intent = new Intent(this, ReadingStoryActivity.class);
        intent.putExtra(KEY_STORY, storySelected);
        startActivity(intent);
    }
}