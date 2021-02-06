package com.lucasvieira.coleoboardgames.model;

import java.io.Serializable;

public class Boardgame implements Serializable   {

    private String nome;
    private String duracao;
    private String descricao;
    private int capa;
    private int minJogadores;
    private int maxJogadores;
    private String dificuldade;
    private String cooperativo;
    private String cartas;

    public Boardgame(String nome, String duração, String descrição, int capa) {
        this.nome = nome;
        this.duracao = duração;
        this.descricao = descrição;
        this.capa = capa;
//        this.minJogadores = minJogadores;
//        this.maxJogadores = maxJogadores;
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

    public int getMinJogadores() {
        return minJogadores;
    }

    public void setMinJogadores(int minJogadores) {
        this.minJogadores = minJogadores;
    }

    public int getMaxJogadores() {
        return maxJogadores;
    }

    public void setMaxJogadores(int maxJogadores) {
        this.maxJogadores = maxJogadores;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }
}
