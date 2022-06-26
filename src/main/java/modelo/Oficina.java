package modelo;

import java.util.LinkedList;

public class Oficina {
    private String nome;
    private int telefone;
    private String email;
    private String responsavelOficina;
    private int telefoneResponsavel;
    private LinkedList<Reparacao> reparacoes;

    public Oficina(String nome, int telefone, String email, String responsavelOficina, int telefoneResponsavel) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.responsavelOficina = responsavelOficina;
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setResponsavelOficina(String responsavelOficina) {
        this.responsavelOficina = responsavelOficina;
    }

    public void setTelefoneResponsavel(int telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public LinkedList<Reparacao> getReparacoes() {
        return reparacoes;
    }

    public void setReparacoes(LinkedList<Reparacao> reparacoes) {
        if (reparacoes == null) return;
        this.reparacoes.addAll(reparacoes);
    }

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getResponsavelOficina() {
        return responsavelOficina;
    }

    public int getTelefoneResponsavel() {
        return telefoneResponsavel;
    }
}
