package br.com.andremeiras.covidparana.model;

public class CasosEObitos {

    private Long ibge;
    private String rs;
    private String municipio;
    private int qtdeCasos;
    private int qtdeObitos;
    private int qtdeRecuperados;
    private int emInvestigacao;

    public Long getIbge() {
        return ibge;
    }

    public void setIbge(Long ibge) {
        this.ibge = ibge;
    }

    public String getRs() {
        return rs;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getQtdeCasos() {
        return qtdeCasos;
    }

    public void setQtdeCasos(int qtdeCasos) {
        this.qtdeCasos = qtdeCasos;
    }

    public int getQtdeObitos() {
        return qtdeObitos;
    }

    public void setQtdeObitos(int qtdeObitos) {
        this.qtdeObitos = qtdeObitos;
    }

    public int getQtdeRecuperados() {
        return qtdeRecuperados;
    }

    public void setQtdeRecuperados(int qtdeRecuperados) {
        this.qtdeRecuperados = qtdeRecuperados;
    }

    public int getEmInvestigacao() {
        return emInvestigacao;
    }

    public void setEmInvestigacao(int emInvestigacao) {
        this.emInvestigacao = emInvestigacao;
    }

    @Override
    public String toString() {
        return "CasosEObitos [emInvestigacao=" + emInvestigacao + ", ibge=" + ibge + ", municipio=" + municipio
                + ", qtdeCasos=" + qtdeCasos + ", qtdeObitos=" + qtdeObitos + ", qtdeRecuperados=" + qtdeRecuperados
                + ", rs=" + rs + "]";
    }   

}
