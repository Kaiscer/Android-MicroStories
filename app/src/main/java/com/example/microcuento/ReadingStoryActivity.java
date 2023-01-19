package com.example.microcuento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.microcuento.model.Story;

public class ReadingStoryActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_story);


        tvTitle = findViewById(R.id.tv_TitleS);
        tvStory = findViewById(R.id.tv_StoryS);

        String name = ((Application)getApplication()).getName();
        Story story = getIntent().getParcelableExtra(ChooseStoryActivity.KEY_STORY);

        tvTitle.setText(story.getTitle());
        tvStory.setText(String.format(story.getStory(), name));

    }


}