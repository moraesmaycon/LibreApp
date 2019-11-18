package com.example.libreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void entrarOne (View v){
        Intent intent = new Intent(this, telaLogin.class);
        startActivity(intent);
    }

    public void cadastrarOne (View v){
        Intent intent = new Intent(this, telaCadastro.class);
        startActivity(intent);
    }


}
