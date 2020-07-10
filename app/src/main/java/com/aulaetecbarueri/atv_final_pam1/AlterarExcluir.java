package com.aulaetecbarueri.atv_final_pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aulaetecbarueri.atv_final_pam1.dominio.entidades.Produtos;
import com.aulaetecbarueri.atv_final_pam1.dominio.repositorio.ProdutosDAO;

import java.util.List;

public class AlterarExcluir extends AppCompatActivity {

    private EditText id;
    private EditText nome;
    private EditText quantidade;
    private EditText descricao;
    private EditText valor;
    private ProdutosDAO produtosDAO;
    private List<Produtos> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_excluir);

        id = findViewById(R.id.txtCodigo);
        nome = findViewById(R.id.txtNome);
        quantidade = findViewById(R.id.txtQuantidade);
        descricao = findViewById(R.id.txtDescricao);
        valor = findViewById(R.id.txtValor);

        produtosDAO = new ProdutosDAO(this);
    }

    public void buscar(View v){

        String id = this.id.getText().toString();

        produtos = produtosDAO.obterProdutos(id);

        System.out.println(produtos.get(0).getID());
        System.out.println(produtos.get(0).getNome());
        System.out.println(produtos.get(0).getQuantidade());
        System.out.println(produtos.get(0).getDescricao());
        System.out.println(produtos.get(0).getValor());

       this.id.setText(String.valueOf(produtos.get(0).getID()));
       nome.setText(String.valueOf(produtos.get(0).getNome()));
       quantidade.setText(String.valueOf(produtos.get(0).getQuantidade()));
       descricao.setText(String.valueOf(produtos.get(0).getDescricao()));
       valor.setText(String.valueOf(produtos.get(0).getValor()));
    }

    public void alterar (View v){

        Produtos produtos = new Produtos();

        int id = Integer.parseInt(this.id.getText().toString());
        produtos.setID(id);
        produtos.setNome(nome.getText().toString());
        produtos.setQuantidade(quantidade.getText().toString());
        produtos.setDescricao(descricao.getText().toString());
        produtos.setValor(valor.getText().toString());

        produtosDAO.alterar(produtos);

        Toast.makeText(this, "Aluno alterado com sucesso - ID: " + id, Toast.LENGTH_SHORT).show();
    }

    public void excluir (View v){
        int id = Integer.parseInt(this.id.getText().toString());

        produtosDAO.excluir(id);

        Toast.makeText(this,"Aluno Excluido com sucesso - ID: " + id, Toast.LENGTH_SHORT).show();
    }

    public void voltar(View v){

        Intent it = new Intent(AlterarExcluir.this, TelaInicio.class);
        startActivity(it);
    }
}
