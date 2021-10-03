package com.itproger.convertor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {



        private static final String db_name = "task_manager";
        private static final int db_version = 1;

        private static final  String db_table = "converter";
        private static final  String db_ton = "ton";
        private static final String db_kg = "kilo";
        private static final String db_grm = "grm";

        public DataBase(@Nullable Context context) {
            super(context, db_name, null, db_version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = String.format("CREATE TABLE %s (ID INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL);", db_table, db_ton, db_kg, db_grm);
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            String  query = String.format("DELETE TABLE IF EXISTS %s", db_table);
            db.execSQL(query);
            onCreate(db);
        }

        public void insertData(String task){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(db_ton,  task);
            values.put( db_kg,  task);
            values.put(db_grm, task);
            db.insertWithOnConflict(db_table,null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }



        public ArrayList<String> getAllTask (){
            ArrayList<String> allTask = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(db_table,new String[]{db_ton,db_kg,db_grm}, null, null, null,null,null);
            while (cursor.moveToNext()){
                int index = cursor.getColumnIndex(db_ton);
                allTask.add(cursor.getString(index));
            }
            cursor.close();
            db.close();
            return allTask;
        }
}


