package br.com.ucsal.pinhobrunodev.tarefamobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.ucsal.pinhobrunodev.tarefamobile.R;
import br.com.ucsal.pinhobrunodev.tarefamobile.bd.Db;
import br.com.ucsal.pinhobrunodev.tarefamobile.model.Usuario;

public class UsuarioAdapter extends BaseAdapter {


    private List<Usuario> usuarios;
    private Context context;
    private Db db;

    public UsuarioAdapter(Context context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Usuario getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lista, viewGroup, false);
        }

        TextView nome = view.findViewById(R.id.nome);
        TextView nickname = view.findViewById(R.id.nickname);
        TextView followers = view.findViewById(R.id.followers);
        TextView following = view.findViewById(R.id.following);


        Usuario usuario = usuarios.get(position);

        nome.setText("Nome: "+usuario.getName());
        nickname.setText("Nickname: "+usuario.getLogin());
        followers.setText("Followers: "+usuario.getFollowers());
        following.setText("Following: "+usuario.getFollowing());


        return view;
    }



}
