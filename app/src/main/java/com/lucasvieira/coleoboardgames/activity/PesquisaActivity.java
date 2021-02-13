package com.lucasvieira.coleoboardgames.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lucasvieira.coleoboardgames.R;
import com.lucasvieira.coleoboardgames.adapter.BoardgameAdapter;
import com.lucasvieira.coleoboardgames.model.Boardgame;
import com.lucasvieira.coleoboardgames.model.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends AppCompatActivity {

    private List<Boardgame> listaAddBG = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        Boardgame boardgame = new Boardgame();
        boardgame.recuperarListagemBoardGame(getApplicationContext());

        Toolbar toolbar = findViewById(R.id.toolbarPesquisa);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //Configurar adapter
        BoardgameAdapter adapter = new BoardgameAdapter(listaAddBG);

        //Configurar RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Boardgame bg = listaAddBG.get(position);
//                                Boardgame dados = new Boardgame(bg.getNome(), bg.getDescricao(), bg.getCapa(), bg.getAnoDeLancamento(), bg.getJogadores(), bg.getDuracao());

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                intent.putExtra("dados", dados);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //Ao segurar item lista
                                Boardgame bg = listaAddBG.get(position);
                                Toast.makeText(getApplicationContext(), "Nome do jogo: " + bg.getNome(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}