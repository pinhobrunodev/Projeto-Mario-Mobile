package br.com.ucsal.pinhobrunodev.tarefamobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.com.ucsal.pinhobrunodev.tarefamobile.R;
import br.com.ucsal.pinhobrunodev.tarefamobile.bd.Db;
import br.com.ucsal.pinhobrunodev.tarefamobile.model.Usuario;
import br.com.ucsal.pinhobrunodev.tarefamobile.repositories.UsuarioRepository;
import br.com.ucsal.pinhobrunodev.tarefamobile.service.GitHubWebService;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private Button button;
    private Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Db.getInstance(this);
        username = findViewById(R.id.username);
        button   =  findViewById(R.id.button);

        button.setOnClickListener(view -> {
            String usernameInput = username.getText().toString();
            try {
                Usuario usuario = new GitHubWebService(usernameInput).execute().get();
                db.usuarioRepository().insert(usuario);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}