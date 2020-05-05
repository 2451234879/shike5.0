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

public class Word extends AppCompatActivity {

    private EditText titleEditText;
    private EditText contentEditText;
    private ContentValues values;
    private int id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second1);
        Intent intent = getIntent();
        String data_title = intent.getStringExtra("title");
        String date_content = intent.getStringExtra("content");
        this.id1 = intent.getIntExtra("id", 0);
        EditText editText_title = findViewById(R.id.edit_title1);
        EditText editText_content = findViewById(R.id.edit_content1);
        editText_title.setText(data_title);
        editText_content.setText(date_content);
        Button button_fanhui1 = (Button)findViewById(R.id.fanhui1);
        button_fanhui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Word.this, FirstActivity.class);
                startActivity(intent);
            }
        });

//        myDateBaseHelper = new MyDateBaseHelper(this,"word.db",null,6);
//        db = myDateBaseHelper.getWritableDatabase();
        Button button_baocun1 = (Button)findViewById(R.id.baocun1);
        button_baocun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleEditText = (EditText)findViewById(R.id.edit_title1);
                String titleinput = titleEditText.getText().toString();
                contentEditText = (EditText)findViewById(R.id.edit_content1);
                String contentinput = contentEditText.getText().toString();
                values = new ContentValues();
                values.put("title", titleinput);
                values.put("content", contentinput);
                FirstActivity.db.update("Word", values, "id = "+id1,null);
                values.clear();
                Intent intent = new Intent(Word.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
