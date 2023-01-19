package com.example.microcuento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class StartActivity extends AppCompatActivity {

    public static final String SEND_NAME = "Name";
    private EditText etName;
    private Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startapp();}
        });


    }

    private void startapp() {
        String name = etName.getText().toString();
        if (name.isEmpty()) {
            Snackbar.make(etName,R.string.MsgNoName, Snackbar.LENGTH_SHORT).show();
        } else {
            ((Application) getApplication()).setName(name);
            Intent intent = new Intent(this, ChooseStoryActivity.class);
            startActivity(intent);
        }
    }


}