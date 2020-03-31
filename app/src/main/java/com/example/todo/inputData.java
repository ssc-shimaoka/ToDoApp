package com.example.todo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class inputData extends AppCompatActivity {

    private TodoAdapter todo;
    private Button btn_back;
    private Button btn_save;
    private EditText txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_save = (Button)findViewById(R.id.btn_save);
        txt1 = (EditText)findViewById(R.id.editText);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 画面を閉じる
                finish();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 値を保存する
                todo.insert(txt1.getText().toString());

                // 画面を閉じる
                finish();
            }
        });
        
        todo = new TodoAdapter(this);
    }


}
