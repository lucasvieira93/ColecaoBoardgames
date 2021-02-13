package com.lucasvieira.coleoboardgames.model;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public class Boardgame implements Serializable   {

    private String nome;
    private String minDuracao;
    private String maxDuracao;
    private Spanned descricao;
    private String capa;
    private String minJogadores;
    private String maxJogadores;
    private String anoDeLancamento;

    public Boardgame(String nome, String minDuracao, String maxDuracao, Spanned descricao, String capa, String minJogadores, String maxJogadores, String anoDeLancamento) {
        this.nome = nome;
        this.minDuracao = minDuracao;
        this.maxDuracao = maxDuracao;
        this.descricao = descricao;
        this.capa = capa;
        this.minJogadores = minJogadores;
        this.maxJogadores = maxJogadores;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Boardgame(){ }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMinDuracao() {
        return minDuracao;
    }

    public void setMinDuracao(String minDuracao) {
        this.minDuracao = minDuracao;
    }

    public String getMaxDuracao() {
        return maxDuracao;
    }

    public void setMaxDuracao(String maxDuracao) {
        this.maxDuracao = maxDuracao;
    }

    public Spanned getDescricao() {
        return descricao;
    }

    public void setDescricao(Spanned descricao) {
        this.descricao = descricao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getMinJogadores() {
        return minJogadores;
    }

    public void setMinJogadores(String minJogadores) {
        this.minJogadores = minJogadores;
    }

    public String getMaxJogadores() {
        return maxJogadores;
    }

    public void setMaxJogadores(String maxJogadores) {
        this.maxJogadores = maxJogadores;
    }

    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(String anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getJogadores (){
        return this.getMinJogadores() + " - " + this.getMaxJogadores();
    }

    public String getDuracao(){
        return this.getMinDuracao() + " - " + this.getMaxDuracao() + "min";
    }

    public void recuperarListagemBoardGame(Context context) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

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

//                                listaBG.add(boardgame);
                            }
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
}
