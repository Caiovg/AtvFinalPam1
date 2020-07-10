package com.aulaetecbarueri.atv_final_pam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent it = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void telaCadastrar(View v){

        this.it = new Intent(MainActivity.this, TelaCadastro.class);
        startActivity(this.it);

    }
    public void telaLogar(View v){

        this.it = new Intent(MainActivity.this, TelaLogin.class);
        startActivity(this.it);

    }
}
