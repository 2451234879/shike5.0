package com.cqupt.shike;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private List<Biji> list = new ArrayList<Biji>();
    public static  MyDateBaseHelper myDateBaseHelper;
    public static SQLiteDatabase db;
    public BijiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        myDateBaseHelper = new MyDateBaseHelper(this,"word.db",null,9);
        db = myDateBaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Word",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
           do{
               int id = cursor.getInt(cursor.getColumnIndex("id"));
               String title = cursor.getString(cursor.getColumnIndex("title"));
               String content = cursor.getString(cursor.getColumnIndex("content"));
               Biji bijidemo = new Biji(id,title,content);
               list.add(bijidemo);

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

        adapter = new BijiAdapter(
                FirstActivity.this, R.layout.biji_item, list);
        ListView listview = (ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Biji biji1 = list.get(position);
                Intent intent = new Intent(FirstActivity.this, Word.class);
                intent.putExtra("id", biji1.getId());
                intent.putExtra("title", biji1.getTitle());
                intent.putExtra("content", biji1.getContent());
                startActivity(intent);
            }
        } );
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Biji biji2 = list.get(position);
                showMyDialog(biji2, position);
                return true;
            }
            void showMyDialog(final Biji biji3, int position){
                final AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
                dialog.setTitle("是否删除");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.delete("Word", "id = "+biji3.getId(), null);
                        list.remove(biji3);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        });

    }
}


