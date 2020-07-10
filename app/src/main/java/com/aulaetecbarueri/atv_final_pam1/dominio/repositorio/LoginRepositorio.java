package com.aulaetecbarueri.atv_final_pam1.dominio.repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aulaetecbarueri.atv_final_pam1.dominio.entidades.Login;

public class LoginRepositorio {

    private SQLiteDatabase conexao;

    public LoginRepositorio(SQLiteDatabase conexao){

        this.conexao = conexao;

    }

    public void inserir(Login login){

        ContentValues contentValues = new ContentValues();

        contentValues.put("usuario", login.usuario);
        contentValues.put("senha", login.senha);

        conexao.insertOrThrow("tbl_login", null, contentValues);

    }

    public boolean logar(Login login){

        StringBuilder sql = new StringBuilder();

        String[] parametros = new String[2];
        parametros[0] = String.valueOf(login.usuario);
        parametros[1] = String.valueOf(login.senha);

        sql.append("SELECT codigo, usuario, senha ");
        sql.append("FROM tbl_login ");
        sql.append("WHERE usuario = ? AND senha = ?");

        Cursor resultado = conexao.rawQuery(sql.toString(), parametros);

        if(resultado.getCount() > 0) {

            return true;

        }else{

            return false;

        }

    }
}
