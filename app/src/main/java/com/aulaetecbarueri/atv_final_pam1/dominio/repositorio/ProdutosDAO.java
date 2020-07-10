package com.aulaetecbarueri.atv_final_pam1.dominio.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.aulaetecbarueri.atv_final_pam1.database.Conexao;
import com.aulaetecbarueri.atv_final_pam1.dominio.entidades.Produtos;

import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutosDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Produtos produtos){

        ContentValues values = new ContentValues();
        values.put("nome", produtos.getNome());
        values.put("quantidade", produtos.getQuantidade());
        values.put("descricao", produtos.getDescricao());
        values.put("valor", produtos.getValor());

        return banco.insert("produtos", null, values);
    }

    public void alterar(Produtos produtos){

        ContentValues values = new ContentValues();
        values.put("nome", produtos.getNome());
        values.put("quantidade", produtos.getQuantidade());
        values.put("descricao", produtos.getDescricao());
        values.put("valor", produtos.getValor());

        banco.update("produtos", values, "id = ?", new String[]{String.valueOf(produtos.getID())});
    }

    public void excluir(int id){
        banco.delete("produtos","id = ?", new String[]{ String.valueOf(id)});
    }

    public List<Produtos> obterTodos(){

        List<Produtos> produtos = new ArrayList<>();
        Cursor cursor = banco.query("produtos", new String[]{"id","nome","quantidade","descricao","valor"}, null, null, null, null, null);

        while (cursor.moveToNext()){

            Produtos a = new Produtos();
            a.setID(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setQuantidade(cursor.getString(2));
            a.setDescricao(cursor.getString(3));
            a.setValor(cursor.getString(4));

            produtos.add(a);
        }

        return produtos;
    }

    public List<Produtos> obterProdutos(String cod){

        String[] codigo = new String[]{cod};

        List<Produtos> produtos = new ArrayList<>();
        Cursor cursor = banco.rawQuery("SELECT id, nome, quantidade, descricao, valor FROM produtos WHERE ID = ?", codigo);
        while (cursor.moveToNext()){

            Produtos a = new Produtos();
            a.setID(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setQuantidade(cursor.getString(2));
            a.setDescricao(cursor.getString(3));
            a.setValor(cursor.getString(4));

            produtos.add(a);
        }

        return produtos;
    }
}
