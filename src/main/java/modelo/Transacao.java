package modelo;

public class Transacao {
    private TipoTransacao tipoTransacao;
    private Cliente cliente;
    private Veiculo veiculo;
    private float valor;

    public Transacao(Cliente cliente, Veiculo veiculo, float valor) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.valor = valor;
        this.tipoTransacao = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
