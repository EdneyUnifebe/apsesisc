package edneyimme.net.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edneyimme.net.myapplication.R;
import edneyimme.net.myapplication.dao.Users;

public class listUsersAdapter extends ArrayAdapter {


    public listUsersAdapter(Context context, ArrayList<Users> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Users user = (Users) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_lista_usuarios, parent, false);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.nomeUsuario);
        tvName.setText(user.getNome());
        return convertView;
    }

}
