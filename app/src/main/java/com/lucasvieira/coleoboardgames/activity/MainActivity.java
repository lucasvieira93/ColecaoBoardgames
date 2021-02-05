package com.lucasvieira.coleoboardgames.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.lucasvieira.coleoboardgames.R;
import com.lucasvieira.coleoboardgames.adapter.BoardgameAdapter;
import com.lucasvieira.coleoboardgames.model.Boardgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerBoard;
    private List<Boardgame> listaBoardgames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerBoard = findViewById(R.id.recyclerView);

        this.listarBoargames();

        //Configurar adapter
        BoardgameAdapter adapter = new BoardgameAdapter(listaBoardgames);

        //Configurar RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerBoard.setLayoutManager(layoutManager);
        recyclerBoard.setHasFixedSize(true);
        recyclerBoard.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerBoard.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item_adicionar) {
            Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item_pesquisar) {
            Toast.makeText(this, "Pesquisar", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void listarBoargames() {
        Boardgame b1, b2, b3;

        b1 = new Boardgame();
        b1.setNome("Arcadia Quest");
        b1.setDuração("1h30 p/ missão");
        b1.setDescrição("Tabuleiro PvPvE com seus amigos");
        this.listaBoardgames.add(b1);

        b2 = new Boardgame();
        b2.setNome("Camel Up");
        b2.setDuração("40 min");
        b2.setDescrição("Apostadores de camelos, vence quem tiver mais dinheiro");
        this.listaBoardgames.add(b2);

        b3 = new Boardgame();
        b3.setNome("Jaipur");
        b3.setDuração("20 min");
        b3.setDescrição("Negociação 1v1, vence aquele que melhor se adaptar ao mercado");
        this.listaBoardgames.add(b3);
    }
}