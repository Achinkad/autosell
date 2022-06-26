package modelo;

import java.util.Date;
import java.util.LinkedList;

public class Evento {
    private Date dataInicio;
    private Date dateFim;
    private Filial filial;
    private String designacao;
    private String localizacao;
    private String morada;
    private int numMaxVeiuclos;
    private LinkedList<Veiculo> veiculosAssociados;
}
