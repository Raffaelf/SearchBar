package com.example.searchbar;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private float estrela;
    private int img;
    private double preco;

    public Produto(String nome, double preco, float estrela, int img) {
        this.nome = nome;
        this.estrela = estrela;
        this.img = img;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getEstrela() {
        return estrela;
    }

    public void setEstrela(float estrela) {
        this.estrela = estrela;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
