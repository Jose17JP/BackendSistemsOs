package com.store.model;

public class Arista {
    private String destino;
    private int peso; // distancia o tiempo

    public Arista(String destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public String getDestino() {
        return destino;
    }
    public int getPeso() {
        return peso;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

}
