package com.aulaetecbarueri.atv_final_pam1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DadosOpenHelper extends SQLiteOpenHelper {

    public DadosOpenHelper(@Nullable Context context) {

        /*
         * 1 - nome do banco
         * 2 - cursor de dados
         * 3 - versão da base de dados
         * */
        super(context, "login", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptDLL.getCreateTableLogin());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
