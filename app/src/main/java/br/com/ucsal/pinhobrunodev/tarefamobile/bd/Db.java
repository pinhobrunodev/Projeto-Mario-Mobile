package br.com.ucsal.pinhobrunodev.tarefamobile.bd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.ucsal.pinhobrunodev.tarefamobile.model.Usuario;
import br.com.ucsal.pinhobrunodev.tarefamobile.repositories.UsuarioRepository;

@Database(entities = {Usuario.class}, exportSchema = false, version = 1)
public abstract class Db extends RoomDatabase {

    private static final String DB_NAME = "GITHUB_REGISTRATION";
    private static Db instance;

    public static synchronized Db getInstance(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(context, Db.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UsuarioRepository usuarioRepository();

}
