package com.cqupt.shike;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class FirstActivity extends AppCompatActivity {

    private String[] data = {"待新增1","待新增2","待新增3","待新增2","待新增3","待新增2","待新增3","待新增2","待新增3","待新增2","待新增3"
            ,"待新增2","待新增3","待新增2","待新增3","待新增2","待新增3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button_xinjian = (Button)findViewById(R.id.button2);
        button_xinjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                FirstActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listview = (ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
    }
}


