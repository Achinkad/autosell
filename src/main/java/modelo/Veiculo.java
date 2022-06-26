package modelo;

public class Veiculo extends Item{
    private String matricula;
    private String marca;
    private String modelo;
    private String cor;
    private int quilometragem;
    private String descricao;
    private Cliente antigoDono;
    private FichaVeiculo ficha;

    private String motivoVenda;




    public Veiculo(String matricula, String marca, String modelo, String cor, int quilometragem, String descricao, Cliente antigoDono, FichaVeiculo ficha,String motivoVenda) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.descricao = descricao;
        this.antigoDono = antigoDono;
        this.ficha = ficha;
        this.motivoVenda=motivoVenda;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getAntigoDono() {
        return antigoDono;
    }

    public void setAntigoDono(Cliente antigoDono) {
        this.antigoDono = antigoDono;
    }

    public FichaVeiculo getFicha() {
        return ficha;
    }

    public void setFicha(FichaVeiculo ficha) {
        this.ficha = ficha;
    }

    public String getMotivoVenda() {
        return motivoVenda;
    }

    public void setMotivoVenda(String motivoVenda) {
        this.motivoVenda = motivoVenda;
    }
}
