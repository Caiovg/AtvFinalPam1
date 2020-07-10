package com.aulaetecbarueri.atv_final_pam1.database;

public class ScriptDLL {

    public static String getCreateTableLogin(){

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS tbl_login(");
        sql.append("codigo integer primary key autoincrement not null,");
        sql.append("usuario varchar(250) not null default('sem dados'),");
        sql.append("senha varchar(20) not null default('sem dados'));");

        return sql.toString();

    }
}
