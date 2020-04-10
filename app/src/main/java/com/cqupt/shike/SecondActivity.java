package com.cqupt.shike;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    private  MyDateBaseHelper myDateBaseHelper;
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

        myDateBaseHelper = new MyDateBaseHelper(this,"word.db",null,1);
        Button button_baocun = (Button)findViewById(R.id.baocun);
        button_baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDateBaseHelper.getWritableDatabase();
            }
        });
    }
}
