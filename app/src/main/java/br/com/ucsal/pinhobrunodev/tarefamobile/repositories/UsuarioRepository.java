package br.com.ucsal.pinhobrunodev.tarefamobile.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.ucsal.pinhobrunodev.tarefamobile.model.Usuario;

@Dao
public interface UsuarioRepository {


    @Query("SELECT * FROM usuario")
    List<Usuario> findAll();


    @Insert
    void insert(Usuario usuario);
}
