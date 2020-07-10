package com.aulaetecbarueri.atv_final_pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);
    }


    public void cadastrar(View v){
        Intent it = new Intent(TelaInicio.this, CadastrarProdutos.class);
        startActivity(it);
    }

    public void listar(View v){
        Intent it = new Intent(TelaInicio.this, ListarProdutos.class);
        startActivity(it);
    }

    public void editarEexcluir(View v){
        Intent it = new Intent(TelaInicio.this, AlterarExcluir.class);
        startActivity(it);
    }

    public void voltar(View v){
        Intent it = new Intent(TelaInicio.this, MainActivity.class);
        startActivity(it);
    }
}
