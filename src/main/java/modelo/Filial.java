package modelo;

import vista.Erros;

import java.util.LinkedList;

public class Filial extends Local {
    private LinkedList<Oficina> oficinas;
    private LinkedList<Armazem> armazens;
    private boolean sede;

    public Filial(LinkedList<Oficina> oficinas, LinkedList<Armazem> armazens, boolean sede, String designacao, String localizacao, String morada, int numeroMaxVeiculos, LinkedList<Veiculo> veiculos) {
        super(designacao, localizacao, morada, numeroMaxVeiculos, veiculos);
        this.oficinas = oficinas;
        this.armazens = armazens;
        this.sede = sede;
    }


    public LinkedList<Oficina> getOficinas() {
        return oficinas;
    }

    public void setOficinas(LinkedList<Oficina> oficinas) {
        if (oficinas == null) return;

        for (Oficina o : oficinas) {
            oficinas.add(o);
        }
    }

    public LinkedList<Armazem> getArmazens() {
        return armazens;
    }

    public void setArmazens(LinkedList<Armazem> armazens) {
        if (armazens == null) return;

        for (Armazem a : armazens) {
            armazens.add(a);
        }
    }

    public boolean isSede() {
        return sede;
    }

    public void setSede(boolean sede) {
        this.sede = sede;
    }
}
