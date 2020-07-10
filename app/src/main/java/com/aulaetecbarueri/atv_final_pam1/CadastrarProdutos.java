package com.aulaetecbarueri.atv_final_pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aulaetecbarueri.atv_final_pam1.dominio.entidades.Produtos;
import com.aulaetecbarueri.atv_final_pam1.dominio.repositorio.ProdutosDAO;

public class CadastrarProdutos extends AppCompatActivity {

    private EditText nome;
    private EditText quantidade;
    private EditText descricao;
    private EditText valor;
    private ProdutosDAO produtosDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produtos);

        nome = findViewById(R.id.txtNome);
        quantidade = findViewById(R.id.txtQuantidade);
        descricao = findViewById(R.id.txtDescricao);
        valor = findViewById(R.id.txtValor);

        produtosDAO = new ProdutosDAO(this);
    }

    public void salvar(View v){
        Produtos produtos = new Produtos();

        produtos.setNome(nome.getText().toString());
        produtos.setQuantidade(quantidade.getText().toString());
        produtos.setDescricao(descricao.getText().toString());
        produtos.setValor(valor.getText().toString());

        long id = produtosDAO.inserir(produtos);

        Toast.makeText(this, "Produto inserido com sucesso - ID: " + id, Toast.LENGTH_SHORT).show();

    }

    public void voltar(View v){

        Intent it = new Intent(CadastrarProdutos.this, TelaInicio.class);
        startActivity(it);
    }
}
