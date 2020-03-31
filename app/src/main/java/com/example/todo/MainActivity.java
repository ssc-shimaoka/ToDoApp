package com.example.todo;

import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TodoAdapter todo;
    private List<TodoItem> list = new ArrayList<TodoItem>();
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("activity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todo = new TodoAdapter(this);
        Displist();

    }

    public void onClickAddButton(View view)
    {
        // インテントのインスタンス生成
        Intent intent = new Intent(MainActivity.this, inputData.class);
        // 次画面のアクティビティ起動
        startActivity(intent);
    }


    @Override
    protected void onRestart() {

        Log.d("activity", "onRestart");

        list.clear();
        Displist();

        super.onRestart();
    }

    public void Displist()
    {
        Cursor c = todo.getAllList();
        if(c.moveToFirst()){
            do {
                TodoItem item = new TodoItem();
                item.set_id(c.getInt(c.getColumnIndex("_id")));
                item.setMemo(c.getString(c.getColumnIndex("memo")));
                list.add(item);
            } while(c.moveToNext());
        }

        // 紐付け
        listview = (ListView)findViewById(R.id.listview);

        // ArrayAdapterへ設定
        TodoListAdapter rowAdapater = new TodoListAdapter(this, 0, list);

        // リストビューへ設定
        listview.setAdapter(rowAdapater);
    }


}