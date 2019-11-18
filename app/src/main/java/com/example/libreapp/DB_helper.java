package com.example.libreapp;

import android.os.Build;
import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DB_helper {

    private static String WEB_SERVICE_URL = "http://10.21.80.155/webservice/";

    private static void checkThreadPolicy() {
        int SDK_VERSION = Build.VERSION.SDK_INT;
        if (SDK_VERSION > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy((policy));
        }
        ;
    }

    public static int insertIntoUsuario(String user, String email, String nome, String birthdate, String senha) throws IOException {
        checkThreadPolicy();
        String values = "user=" + user + "&email=" + email + "&nome=" + nome + "&birthdate=" + birthdate + "&senha=" + senha;
        URL url = new URL(WEB_SERVICE_URL + "ws_insert/ws_insert_usuarios.php?" + values);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader((new InputStreamReader(conexao.getInputStream())));
        String resposta = br.readLine();
        if (resposta.equals("true")) {
            return 1;
        } else {
            return 0;
        }

    };

    public static JSONArray selectAllFromUsuarios() throws IOException, JSONException {
        checkThreadPolicy();
        URL url = new URL(WEB_SERVICE_URL + "ws_read/ws_read_usuarios.php");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String linha;
        while ((linha = br.readLine()) != null) {
            sb.append(linha);
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;
    }

}