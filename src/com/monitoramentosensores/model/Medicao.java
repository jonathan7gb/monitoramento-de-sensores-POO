package com.monitoramentosensores.model;

public class Medicao {

    private String codigoSensor;
    private double valor;
    private String dataHora;

    public Medicao(String codigoSensor, double valor, String dataHora){
        this.codigoSensor = codigoSensor;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public void setCodigo(String codigoSensor){
        this.codigoSensor = codigoSensor;
    }

    public String getCodigoSensor(){
        return this.codigoSensor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        return "Valor: " + this.valor + " | Data: " + this.dataHora;
    }
}
