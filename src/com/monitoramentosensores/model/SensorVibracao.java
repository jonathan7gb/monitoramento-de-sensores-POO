package com.monitoramentosensores.model;

public class SensorVibracao extends Sensor{

    public SensorVibracao(String codigo, String nomeEquipamento, String tipoSensor, int totalDeAlertas){
        super(codigo, nomeEquipamento, tipoSensor, totalDeAlertas);
    }

    @Override
    public String toString(){
        return "|| Código: " + codigo + " | Tipo: " + tipoSensor + " | Equipamento: " + nomeEquipamento;
    }
}
