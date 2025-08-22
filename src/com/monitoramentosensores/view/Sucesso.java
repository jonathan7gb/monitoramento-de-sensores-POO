package com.monitoramentosensores.view;

public class Sucesso {

    public void sensorCadastradoComSucesso(String tipo, String limite){
        System.out.println("\n|| ✅ Sensor Cadastrado com Sucesso! ");
        System.out.println("|| Tipo: " + tipo + " | Limite de alerta: " + limite + "\n");
    }

    public void medicaoCadastradaComSucesso(){
        System.out.println("|| ✅ Medição Cadastrada com Sucesso! \n");
    }
}
