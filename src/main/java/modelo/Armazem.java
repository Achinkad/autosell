package modelo;

import java.util.LinkedList;

public class Armazem {
    private String nome;
    private int telefone;
    private LinkedList<Peca> pecas;
    private int quantidadePeças;

    public Armazem(String nome, int telefone, LinkedList<Peca> pecas, int quantidadePeças) {
        this.nome = nome;
        this.telefone = telefone;
        this.pecas = pecas;
        this.quantidadePeças = quantidadePeças;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public LinkedList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(LinkedList<Peca> pecas) {
        this.pecas = pecas;
    }

    public int getQuantidadePeças() {
        return quantidadePeças;
    }

    public void setQuantidadePeças(int quantidadePeças) {
        this.quantidadePeças = quantidadePeças;
    }
}
