package com.lucasvieira.coleoboardgames.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucasvieira.coleoboardgames.R;
import com.lucasvieira.coleoboardgames.model.Boardgame;

public class ActivityDetalhes extends AppCompatActivity {

    private TextView nome, duracao, descricao, jogadores, anoDeLancamento;
    private ImageView capa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        Boardgame dados = (Boardgame) getIntent().getSerializableExtra("dados");

        nome = findViewById(R.id.nome);
        duracao = findViewById(R.id.duracao);
        descricao = findViewById(R.id.descricao);
        capa = findViewById(R.id.capaImage);
        anoDeLancamento = findViewById(R.id.lancamento);
        jogadores = findViewById(R.id.jogadores);

        nome.setText(dados.getNome());
        duracao.setText(dados.getDuracao());
        descricao.setText(dados.getDescricao());
        capa.setImageResource(dados.getCapa());
        jogadores.setText(dados.getJogadores());
        anoDeLancamento.setText(dados.getAnoDeLancamento());
    }
}