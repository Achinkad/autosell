package modelo;

public class Date {
    private int dia;
    private int mes;
    private int ano;

    public Date(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia>31){
            return;
        }
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes>12){
            return;
        }
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano<1900){
            return;
        }
        this.ano = ano;
    }
    public String getData(){
        return dia+"-"+mes+"-"+ano;
    }
}
