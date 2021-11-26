package br.com.ucsal.pinhobrunodev.tarefamobile.service;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import br.com.ucsal.pinhobrunodev.tarefamobile.model.Usuario;

public class GitHubWebService extends AsyncTask<Void, Void, Usuario> {

    private String username;

    public GitHubWebService(String username) {
        this.username = username;
    }

    private String baseUrl = "https://api.github.com/users/";
    /**
     * Método que contém a lógica para realizar a requisição para o web service em background.
     *
     * @param voids
     * @return o endereço convertido de um objeto JSON para um objeto Address.
     */
    @Override
    protected Usuario doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();


            try {
                URL url = new URL(baseUrl + this.username.trim());

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(4000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return new Gson().fromJson(resposta.toString(), Usuario.class);
    }
}
