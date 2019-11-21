package com.example.libreapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class telaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }


    public void retornaTela(View v) {
        Intent intentBack = new Intent(this, MainActivity.class);
        startActivity(intentBack);
    }

    public void confereLogin(View v) throws IOException, JSONException {
        EditText campoEmail = findViewById(R.id.emailDigitado);
        String emailDigitado = campoEmail.getText().toString();
        EditText campoSenha = findViewById(R.id.senhaDigitada);
        String senhaDigitada = campoSenha.getText().toString();
        JSONArray todosOsUsuarios = DB_helper.selectAllFromUsuarios();
        boolean encontrou = false;
        for (int i = 0; i < todosOsUsuarios.length(); i++) {
            JSONObject usuario = todosOsUsuarios.getJSONObject(i);
            String email = usuario.getString("e-mail");
            String senha = usuario.getString("senha");
            if (email.equals(emailDigitado) && senha.equals(senhaDigitada)) {
                encontrou = true;
                String nome = usuario.getString("nome");
                String dataNascimento = usuario.getString("data_de_nascimento");
                String user = usuario.getString("USER");
                Intent intent = new Intent(this, depoisVejo4.class);
                Bundle bundle = new Bundle();
                bundle.putString("email", email);
                bundle.putString("nome", nome);
                bundle.putString("dataNascimento", dataNascimento);
                bundle.putString("user", user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
        if (!encontrou) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Erro no Login!");
            builder.setMessage("Usuário não encontrado!");
            builder.setPositiveButton("Ok", null);
            builder.create().show();
        }
    }


}
