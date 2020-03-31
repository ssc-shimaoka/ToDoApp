package com.example.todo;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "todo.db";
    static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "todo";
    protected SQLiteDatabase db;

    // コンストラクタ
    public DBOpenHelper(Context context){
        //super(context, DB_NAME, null, DB_VERSION);
        super(context, DB_NAME, null, DB_VERSION);

    }

    // 作成
    @Override
    public void onCreate(SQLiteDatabase db){
        // create
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "("+
                        "   _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                        "   memo TEXT NOT NULL "+
                        "   "+
                        ");"
        );

    }

    // 更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

}
