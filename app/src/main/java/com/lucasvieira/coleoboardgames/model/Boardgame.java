package com.lucasvieira.coleoboardgames.model;

import java.io.Serializable;

public class Boardgame implements Serializable   {

    private String nome;
    private String duracao;
    private int descricao;
    private int capa;
    private int[] jogadores;
    private String dificuldade;
    private String cooperativo;
    private String cartas;

    public Boardgame(String nome, String duração, int descrição, int capa) {
        this.nome = nome;
        this.duracao = duração;
        this.descricao = descrição;
        this.capa = capa;
//        this.jogadores = jogadores;
//        this.dificuldade = dificuldade;
//        this.cooperativo = cooperativo;
//        this.cartas = cartas;
    }

    public Boardgame(){ }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(int[] jogadores) {
        this.jogadores = jogadores;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getCooperativo() {
        return cooperativo;
    }

    public void setCooperativo(String cooperativo) {
        this.cooperativo = cooperativo;
    }

    public String getCartas() {
        return cartas;
    }

    public void setCartas(String cartas) {
        this.cartas = cartas;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }
}
