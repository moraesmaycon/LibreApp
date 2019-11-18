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

    public void entrarFalso(View v) {

        EditText email = (EditText) findViewById(R.id.emailID);
        String emailText = email.getText().toString();
        EditText senha = (EditText) findViewById(R.id.senhaID);
        String senhaText = senha.getText().toString();

        if (emailText.equals("easteregg@gmail.com") && senhaText.equals("password")) {

            Intent entrarIntent = new Intent(getApplicationContext(), depoisVejo4.class);
            startActivity(entrarIntent);

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERRO");
            builder.setMessage("Usuário não cadastrado.");
            builder.setPositiveButton("OK" , null);
            builder.create().show();

        }

    }


    public void confereLogin(View v) throws IOException, JSONException {
        EditText campoEmail = findViewById(R.id.emailID);
        String emailDigitado = campoEmail.getText().toString();
        EditText campoSenha = findViewById(R.id.senhaID);
        String senhaDigitada = campoSenha.getText().toString();
        JSONArray todosOsUsuarios = DB_helper.selectAllFromUsuarios();
        boolean encontrou = false;
        for (int i = 0; i < todosOsUsuarios.length(); i++) {
            JSONObject usuario = todosOsUsuarios.getJSONObject(i);
            String email = usuario.getString("email");
            String senha = usuario.getString("senha");
            if (email.equals(emailDigitado) && senha.equals(senhaDigitada)) {
                encontrou = true;
                String nome = usuario.getString("nome");
                Intent intent = new Intent(this, depoisVejo4.class);
                Bundle bundle = new Bundle();
                bundle.putString("email", email);
                bundle.putString("nome", nome);
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
