package com.cqupt.shike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;
import android.widget.EditText;

import java.security.PrivateKey;

public class SecondActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText contentEditText;
    private ContentValues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button_fanhui = (Button)findViewById(R.id.fanhui);
        button_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

//        myDateBaseHelper = new MyDateBaseHelper(this,"word.db",null,6);
//        db = myDateBaseHelper.getWritableDatabase();
        Button button_baocun = (Button)findViewById(R.id.baocun);
        button_baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleEditText = (EditText)findViewById(R.id.edit_title);
                String titleinput = titleEditText.getText().toString();
                contentEditText = (EditText)findViewById(R.id.edit_content);
                String contentinput = contentEditText.getText().toString();
                values = new ContentValues();
                values.put("title", titleinput);
                values.put("content", contentinput);
                FirstActivity.db.insert("Word",null,values);
                values.clear();
            }
        });
    }
}
