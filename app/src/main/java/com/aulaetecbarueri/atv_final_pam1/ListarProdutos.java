package com.aulaetecbarueri.atv_final_pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aulaetecbarueri.atv_final_pam1.dominio.entidades.Produtos;
import com.aulaetecbarueri.atv_final_pam1.dominio.repositorio.ProdutosDAO;

import java.util.ArrayList;
import java.util.List;

public class ListarProdutos extends AppCompatActivity {

    private ListView listView;
    private ProdutosDAO dao;
    private List<Produtos> produtos;
    private List<Produtos> produtosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        listView = findViewById(R.id.lista_produtos);
        dao = new ProdutosDAO(this);

        produtos = dao.obterTodos();

        ArrayAdapter<Produtos> adaptador = new ArrayAdapter<Produtos>(this, android.R.layout.simple_list_item_1, produtos);
        listView.setAdapter(adaptador);
    }

}
