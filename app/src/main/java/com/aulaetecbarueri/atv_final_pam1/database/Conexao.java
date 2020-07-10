package com.aulaetecbarueri.atv_final_pam1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final  String name = "banco.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context){ super(context, name, null, version);}

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table produtos(id integer primary key autoincrement, nome varchar(100), quantidade integer(100), descricao varchar(100), valor decimal(10,2))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
