package modelo;

import java.util.LinkedList;

public class DadosApp {
    private LinkedList<Veiculo> veiculos;
    private LinkedList<FichaVeiculo> fichasVeiculo;
    private LinkedList<Cliente> clientes;
    private LinkedList<FichaCliente> fichasCliente;
    private LinkedList<Local> locais;
    private LinkedList<Evento> eventos;
    private LinkedList<Filial> filiais;
    private LinkedList<Transporte> transportes;
    private LinkedList<Peca> pecas;
    private LinkedList<PecasArmazem> pecasArmazem;
    private LinkedList<Armazem> armazens;
    private LinkedList<Oficina> oficinas;
    private LinkedList<Reparacao> reparacaos;
    private LinkedList<LinhaReparacao> linhaReparacao;
    private LinkedList<Transacao> transacoes;

    public static DadosApp getInstancia(){
        return new DadosApp();
    }

    private DadosApp() {
        this.veiculos = new LinkedList<>();
        this.fichasVeiculo = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.fichasCliente = new LinkedList<>();
        this.locais = new LinkedList<>();
        this.eventos = new LinkedList<>();
        this.filiais = new LinkedList<>();
        this.transportes = new LinkedList<>();
        this.pecas = new LinkedList<>();
        pecas.add(new Peca("Peca 1","ref","Chinês",800,"desc","BMW","15"));
        this.pecasArmazem = new LinkedList<>();
        this.armazens = new LinkedList<>();
        this.oficinas = new LinkedList<>();
        this.reparacaos = new LinkedList<>();
        this.linhaReparacao = new LinkedList<>();
        this.transacoes = new LinkedList<>();
    }

    public LinkedList<Veiculo> getVeiculos() {
        return new LinkedList<>(veiculos);
    }

    public LinkedList<FichaVeiculo> getFichasVeiculo() {
        return new LinkedList<>(fichasVeiculo);
    }

    public LinkedList<Cliente> getClientes() {
        return new LinkedList<>(clientes);
    }

    public LinkedList<FichaCliente> getFichasCliente() {
        return new LinkedList<>(fichasCliente);
    }

    public LinkedList<Local> getLocais() {
        return new LinkedList<>(locais);
    }

    public LinkedList<Evento> getEventos() {
        return new LinkedList<>(eventos);
    }

    public LinkedList<Filial> getFiliais() {
        return new LinkedList<>(filiais);
    }

    public LinkedList<Transporte> getTransportes() {
        return new LinkedList<>(transportes);
    }

    public LinkedList<Peca> getPecas() {
        return new LinkedList<>(pecas);
    }

    public LinkedList<PecasArmazem> getPecasArmazem() {
        return new LinkedList<>(pecasArmazem);
    }

    public LinkedList<Armazem> getArmazens() {
        return new LinkedList<>(armazens);
    }

    public LinkedList<Oficina> getOficinas() {
        return new LinkedList<>(oficinas);
    }

    public LinkedList<Reparacao> getReparacaos() {
        return new LinkedList<>(reparacaos);
    }

    public LinkedList<LinhaReparacao> getLinhaReparacao() {
        return new LinkedList<>(linhaReparacao);
    }

    public LinkedList<Transacao> getTransacoes() {
        return new LinkedList<>(transacoes);
    }
}
