package com.aulaetecbarueri.atv_final_pam1.dominio.entidades;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Produtos implements Serializable {
    private int ID;
    private String nome;
    private String quantidade;
    private String descricao;
    private String valor;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }
}
