package com.monitoramentosensores.model;

public class Sensor {

    protected String codigo;
    protected String nomeEquipamento;
    protected String tipoSensor;
    protected int totalDeAlertas;

    public Sensor(String codigo, String nomeEquipamento, String tipoSensor, int totalDeAlertas){
        this.codigo = codigo;
        this.nomeEquipamento = nomeEquipamento;
        this.tipoSensor = tipoSensor;
        this.totalDeAlertas = totalDeAlertas;
    }

    public Sensor(){
        this.codigo = "";
        this.nomeEquipamento = "";
        this.tipoSensor = "";
        this.totalDeAlertas = 0;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public String getNomeEquip(){
        return this.nomeEquipamento;
    }

    public String getTipoSensor(){
        return this.tipoSensor;
    }
    public int getTotalDeAlertas(){
        return this.totalDeAlertas;
    }


    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setNomeEquip(String nomeEquipamento){
        this.nomeEquipamento = nomeEquipamento;
    }

    public void setTipoSensor(String tipoSensor){
        this.tipoSensor = tipoSensor;
    }

    public void setTotalDeAlertas(int totalDeAlertas){
        this.totalDeAlertas = totalDeAlertas;
    }

    public void addAlertaAoTotal(){
        this.totalDeAlertas++;
    }

    @Override
    public String toString(){
        return "|| Código: " + codigo + " | Tipo: " + tipoSensor + " | Equipamento: " + nomeEquipamento;
    }
}
