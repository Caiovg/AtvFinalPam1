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

public class TelaCadastro extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtSenha;

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;

    private Login login;
    private LoginRepositorio loginRepositorio;

    Intent it = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        criarConexao();
    }

    private void criarConexao(){
        try {
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao =dadosOpenHelper.getWritableDatabase();
            Toast.makeText(this, "BEM VINDO!!!", Toast.LENGTH_SHORT).show();
            loginRepositorio = new LoginRepositorio(conexao);
        }catch(SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("AVISO");
            dlg.setMessage("ERRO AO CONECTAR! ERRO: " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public void cadastrar(View v){
        login = new Login();

        this.txtLogin = (EditText) findViewById(R.id.txtLogin);
        this.txtSenha = (EditText) findViewById(R.id.txtSenha);

        login.usuario = this.txtLogin.getText().toString();
        login.senha = this.txtSenha.getText().toString();
        try {
            loginRepositorio.inserir(login);
            Toast.makeText(this, "CADASTRO EFETUADO COM SUCESSO!", Toast.LENGTH_SHORT).show();
            finish();
        }catch(SQLException ex) {
            System.out.println("ERRO: " + ex.getMessage());
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("AVISO");
            dlg.setMessage("ERRO AO INSERIR O CLIENTE! ERRO: " + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }

    public void telaLogar(View v){

        this.it = new Intent(TelaCadastro.this, TelaLogin.class);
        startActivity(this.it);

    }
    public void telaVoltar(View v){

        this.it = new Intent(TelaCadastro.this, MainActivity.class);
        startActivity(this.it);

    }
}
