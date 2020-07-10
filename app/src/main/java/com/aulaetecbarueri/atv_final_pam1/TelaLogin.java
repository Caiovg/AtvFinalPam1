package com.aulaetecbarueri.atv_final_pam1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.aulaetecbarueri.atv_final_pam1.database.DadosOpenHelper;
import com.aulaetecbarueri.atv_final_pam1.dominio.entidades.Login;
import com.aulaetecbarueri.atv_final_pam1.dominio.repositorio.LoginRepositorio;

public class TelaLogin extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtSenha;

    private Login login = null;
    private LoginRepositorio loginRepositorio = null;


    Intent it = null;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        criarConexao();
    }

    public void Limpar(){

        this.txtLogin = (EditText) findViewById(R.id.txtLogin);
        this.txtSenha = (EditText) findViewById(R.id.txtSenha);

        txtLogin.setText("");
        txtSenha.setText("");

    }
    public void telaLogado(View v){

        this.txtLogin = (EditText) findViewById(R.id.txtLogin);
        this.txtSenha = (EditText) findViewById(R.id.txtSenha);

        login = new Login();

        login.usuario = txtLogin.getText().toString();
        login.senha = txtSenha.getText().toString();

        loginRepositorio = new LoginRepositorio(conexao);

        if(loginRepositorio.logar(login)){
            Limpar();
            this.it = new Intent(TelaLogin.this, TelaInicio.class);
            startActivity(this.it);
        }
        else{
            Limpar();
            Toast.makeText(this,"Usuario ou senha incorretos", Toast.LENGTH_SHORT).show();

        }

    }

    private void criarConexao(){

        try {

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            Toast.makeText(this, "BEM VINDO!!!", Toast.LENGTH_SHORT).show();
        }catch(SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("AVISO");
            dlg.setMessage("ERRO AO CONECTAR! ERRO: " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public void telaCadastrar(View v){

        this.it = new Intent(TelaLogin.this, TelaCadastro.class);
        startActivity(this.it);

    }
    public void telaVoltar(View v){

        this.it = new Intent(TelaLogin.this, MainActivity.class);
        startActivity(this.it);

    }
}
