package br.com.ucsal.pinhobrunodev.tarefamobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import br.com.ucsal.pinhobrunodev.tarefamobile.R;
import br.com.ucsal.pinhobrunodev.tarefamobile.adapter.UsuarioAdapter;
import br.com.ucsal.pinhobrunodev.tarefamobile.bd.Db;
import br.com.ucsal.pinhobrunodev.tarefamobile.repositories.UsuarioRepository;

public class MainActivity2 extends AppCompatActivity {


    private ListView listView;
    private UsuarioAdapter usuarioAdapter;
    private Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = Db.getInstance(this);
        listView = findViewById(R.id.listview);
        configureAdapter();
    }

    private void configureAdapter() {
        usuarioAdapter = new UsuarioAdapter(this, db.usuarioRepository().findAll());
        listView.setAdapter(usuarioAdapter);
    }

}