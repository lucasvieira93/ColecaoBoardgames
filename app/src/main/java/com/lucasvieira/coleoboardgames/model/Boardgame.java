package com.lucasvieira.coleoboardgames.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Spanned;

import java.io.Serializable;

public class Boardgame implements Serializable   {

    private String nome;
    private String minDuracao;
    private String maxDuracao;
    private Spanned descricao;
    private Bitmap capa;
    private String minJogadores;
    private String maxJogadores;
    private String anoDeLancamento;

    public Boardgame(String nome, String minDuracao, String maxDuracao, Spanned descricao, Bitmap  capa, String minJogadores, String maxJogadores, String anoDeLancamento) {
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

    public Bitmap  getCapa() {
        return capa;
    }

    public void setCapa(Bitmap  capa) {
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
}
