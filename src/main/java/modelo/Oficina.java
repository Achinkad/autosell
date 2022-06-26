package modelo;

import java.util.LinkedList;

public class Oficina {
    private String nome;
    private int telefone;
    private String email;
    private String responsavelOficina;
    private int telefoneResponsavel;
    private LinkedList<Reparacao> reparacaos;

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
