package com.monitoramentosensores.model;

public class SensorTemperatura extends Sensor{

    public SensorTemperatura(String codigo, String nomeEquipamento, String tipoSensor, int totalDeAlertas){
        super(codigo, nomeEquipamento, tipoSensor, totalDeAlertas);
    }

    public SensorTemperatura(){
        super();
    }

    @Override
    public String toString(){
        return "|| Código: " + codigo + " | Tipo: " + tipoSensor + " | Equipamento: " + nomeEquipamento;
    }
}
