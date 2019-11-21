package com.example.libreapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class depoisVejo4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depois_vejo4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String user = bundle.getString("user");
        TextView userA = (TextView) findViewById(R.id.userBdId);
        userA.setText(user);
        String email = bundle.getString("email");
        TextView emailA = (TextView) findViewById(R.id.emailBdID);
        emailA.setText(email);
        String nome = bundle.getString("nome");
        TextView nomeA = (TextView) findViewById(R.id.nomeBdId);
        nomeA.setText(nome);
        String dataNascimento = bundle.getString("dataNascimento");
        TextView dataNascimentoA = (TextView) findViewById(R.id.birthdateBdId);
        dataNascimentoA.setText(dataNascimento);
    }

    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected (MenuItem item){

        switch (item.getItemId()){

            case R.id.deleteDataID:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("CONFIRMAÇÃO DE EXCLUSÃO DE CONTA");
                builder.setMessage("Você tem certeza que deseja excluir sua conta? Após sua confirmação, não terá como recuperá-la.");

                DialogInterface.OnClickListener btnSim = new DialogInterface.OnClickListener(){
                  public void onClick(DialogInterface dialog, int which){
                      //a lógica para excluir a pessoa
                  }
                };

                DialogInterface.OnClickListener btnCancel = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which){
                    dialog.dismiss();
                    };
                };

                builder.setPositiveButton("Sim", btnSim);
                builder.setNegativeButton("Cancelar", btnCancel);
                builder.show();
                break;
            case R.id.exitID:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;

        }

        return true;

    }

}
