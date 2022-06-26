package modelo;

public class Cliente {
    private String nome;
    private int contribuinte;
    private String morada;
    private int telefone;
    private String email;
    private FichaCliente ficha;

    public Cliente(String nome, int contribuinte, String morada, int telefone, String email, FichaCliente ficha) {
        this.nome = nome;
        this.contribuinte = contribuinte;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.ficha = ficha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(int contribuinte) {
        this.contribuinte = contribuinte;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FichaCliente getFicha() {
        return ficha;
    }

    public void setFicha(FichaCliente ficha) {
        this.ficha = ficha;
    }
}
