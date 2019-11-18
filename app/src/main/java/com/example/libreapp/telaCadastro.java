package com.example.libreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class telaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
    }

    public void retornaTela(View v) {
        Intent intentBack = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentBack);

    }

    public void cadastrarUsuario(View v) throws IOException {
        EditText campoUser = findViewById(R.id.userCadID);
        String user = campoUser.getText().toString();
        EditText campoEmail = findViewById(R.id.emailCadId);
        String email = campoEmail.getText().toString();
        EditText campoNome = findViewById(R.id.nomeCadID);
        String nome = campoNome.getText().toString();
        EditText campoBirthdate= findViewById(R.id.dateCadID);
        String birthdate = campoBirthdate.getText().toString();
        EditText campoSenha = findViewById(R.id.senhaID2);
        String senha = campoSenha.getText().toString();
        int resposta = DB_helper.insertIntoUsuario(user, email, nome, birthdate, senha);
        if (resposta == 1) {
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Erro! Cadastro não realizado!", Toast.LENGTH_LONG).show();
        }
    }


}
