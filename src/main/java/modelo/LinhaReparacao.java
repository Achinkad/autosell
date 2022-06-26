package modelo;

public class LinhaReparacao {
    private Peca peca;
    private float quantidade;

    public LinhaReparacao(Peca peca, float quantidade) {
        this.peca = peca;
        this.quantidade = quantidade;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
}
