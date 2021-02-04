package com.lucasvieira.coleoboardgames.model;

public class Boardgame {

    private String nome;
    private String duração;
    private int minJogadores;
    private int maxJogadores;
    private String dificuldade;
    private String cooperativo;
    private String cartas;
    private String descrição;
    private int capa;

    public Boardgame(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuração() {
        return duração;
    }

    public void setDuração(String duração) {
        this.duração = duração;
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

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }
}
