package edneyimme.net.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edneyimme.net.myapplication.adapter.listUsersAdapter;
import edneyimme.net.myapplication.controller.LoadInformationFromService;
import edneyimme.net.myapplication.dao.Users;

public class PaginaInicial extends Activity {

    ListView listViewUsers;

    private ArrayList<Users> listaDeUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_inicial);

        listViewUsers = (ListView) findViewById(R.id.listViewUsers);
        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chamarTelaDetalheUsuario(i);
            }
        });
        carrecarListaServidor();

        listUsersAdapter listAdapter = new listUsersAdapter(PaginaInicial.this, this.listaDeUsuarios);
        listViewUsers.setAdapter(listAdapter);

    }

    /**
     * Chamar tela detalhe de usuario para fazer upload de imagens
     * @param i
     */
    private void chamarTelaDetalheUsuario(int i) {
        Intent intent = new Intent(PaginaInicial.this, UploadAprovarImagem.class);
        startActivity(intent);
    }

    /**
     * Carregar fontes de informacao
     */
    public void carrecarListaServidor(){
        LoadInformationFromService lifs = new LoadInformationFromService();
        this.listaDeUsuarios = lifs.getUserInformationFromService();

    }
}
