package com.lucasvieira.coleoboardgames.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.lucasvieira.coleoboardgames.R;
import com.lucasvieira.coleoboardgames.adapter.BoardgameAdapter;
import com.lucasvieira.coleoboardgames.model.Boardgame;
import com.lucasvieira.coleoboardgames.model.RecyclerItemClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerBoard;
    private List<Boardgame> listaBoardgames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperarListagemBoardGame();
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

    private void recuperarListagemBoardGame() {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://api.boardgameatlas.com/api/search?name=catan&client_id=84n9GWJmZU&fields=name,min_playtime,max_playtime,description,image_url,min_players,max_players,year_published&limit=5";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("INFO", "Response: " + response.toString());

                        try {
                            JSONArray lista = response.getJSONArray("games");
//                            Log.i("INICIO", "iniciando lista");

                            for (int i = 0; i < lista.length(); i++) {
                                Boardgame boardgame = new Boardgame();
                                JSONObject jogo = lista.getJSONObject(i);

                                //variaveis GET
                                String nome = jogo.getString("name");
                                String capa = jogo.getString("image_url");
                                String minDuracao = jogo.getString("min_playtime");
                                String maxDuracao = jogo.getString("max_playtime");
                                String anoDeLancamento = jogo.getString("year_published");
                                Spanned descricao = Html.fromHtml(jogo.getString("description"));
                                String minJogadores = jogo.getString("min_players");
                                String maxJogadores = jogo.getString("max_players");

                                //setando dados no objeto
                                boardgame.setNome(nome);
                                boardgame.setCapa(capa);
                                boardgame.setMinDuracao(minDuracao);
                                boardgame.setMaxDuracao(maxDuracao);
                                boardgame.setAnoDeLancamento(anoDeLancamento);
                                boardgame.setDescricao(descricao);
                                boardgame.setMaxJogadores(minJogadores);
                                boardgame.setMaxJogadores(maxJogadores);

                                listaBoardgames.add(boardgame);
                            }
                            metodoRecyclerView();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("INFO", "Mensagem:" + error.getMessage());

                    }
                });

        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);
    }

    private void metodoRecyclerView() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerBoard = findViewById(R.id.recyclerView);

        //Configurar adapter
        BoardgameAdapter adapter = new BoardgameAdapter(listaBoardgames);

        //Configurar RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerBoard.setLayoutManager(layoutManager);
        recyclerBoard.setHasFixedSize(true);
        recyclerBoard.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerBoard.setAdapter(adapter);
        recyclerBoard.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerBoard,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Boardgame bg = listaBoardgames.get(position);
                                Boardgame dados = new Boardgame(bg.getNome(), bg.getDescricao(), bg.getCapa(), bg.getAnoDeLancamento(), bg.getJogadores(), bg.getDuracao());

                                Intent intent = new Intent(getApplicationContext(), ActivityDetalhes.class);
                                intent.putExtra("dados", dados);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //Ao segurar item lista
                                Boardgame bg = listaBoardgames.get(position);
                                Toast.makeText(MainActivity.this, "Nome do jogo: " + bg.getNome(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }));

        //botão para adicionar jogo
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PesquisaActivity.class);
                startActivity(intent);
            }
        });
    }
}