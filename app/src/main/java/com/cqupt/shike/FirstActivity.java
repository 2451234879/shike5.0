package com.cqupt.shike;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<String>();
    public static  MyDateBaseHelper myDateBaseHelper;
    public static SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        myDateBaseHelper = new MyDateBaseHelper(this,"word.db",null,7);
        db = myDateBaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Word",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
           do{
                String title = cursor.getString(cursor.getColumnIndex("title"));
               list.add(title);
            }while(cursor.moveToNext());
        }
        cursor.close();
        Button button_xinjian = (Button)findViewById(R.id.button2);
        button_xinjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                FirstActivity.this, android.R.layout.simple_list_item_1, list);
        ListView listview = (ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
     //           intent.putExtra("title",list.get(position).);
                startActivity(intent);
            }
        } );
    }
}


