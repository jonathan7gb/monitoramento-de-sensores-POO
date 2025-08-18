package com.monitoramentosensores.view;
import com.monitoramentosensores.model.*;

import java.util.Scanner;

public class Cadastros {

    Erros erro = new Erros();
    Scanner sc = new Scanner(System.in);

    public SensorTemperatura cadastroSensorTemperatura(String codigo, String nomeEquip, String tipo, int totalDeAlertas){
        return new SensorTemperatura(codigo, nomeEquip, tipo, totalDeAlertas);
    }

    public SensorVibracao cadastroSensorVibracao(String codigo, String nomeEquip, String tipo, int totalDeAlertas){
        return new SensorVibracao(codigo, nomeEquip, tipo, totalDeAlertas);
    }

    public void headerCadastro(){
        System.out.println("\n|| ============================= ||");
        System.out.println("||      CADASTRAR SENSORES       ||");
        System.out.println("|| ============================= ||");
    }

    public String inputCodigoSensor(){
        System.out.print("|| Digite o código do sensor: ");
        String codigo = sc.nextLine();

        return codigo;
    }

    public String inputEquipamentoSensor(){
        System.out.print("|| Digite o nome do Equipamento: ");
        String equipamento = sc.nextLine();

        return equipamento;
    }

    public int inputTipoSensor(){
        boolean valido = false;
        int opcaoTipoSensor = -1;
        System.out.println("|| Digite o tipo do sensor: ");
        System.out.println("|| 1 - Sensor de Temperatura: ");
        System.out.println("|| 2 - Sensor de Vibração: ");

        do{
            System.out.print("|| Digite a opção: ");
            String tipoEquip = sc.nextLine();

            try{
                opcaoTipoSensor = Integer.parseInt(tipoEquip);
                valido = true;
            } catch (NumberFormatException e) {
                erro.ErroInputInvalido();
            }
        }while(valido == false);

        return opcaoTipoSensor;
    }


    //========================================

    public Medicao cadastrarMedicao(){
        boolean valido = false;
        double medicao = 0.0;
        System.out.println("");
        String codigo = inputCodigoSensor();

        do{
            System.out.print("|| Digite o valor da medição: ");
            String valorMedicao = sc.nextLine();

            try{
                medicao = Double.parseDouble(valorMedicao);
                valido = true;
            } catch (NumberFormatException e) {
                erro.ErroInputInvalido();
            }
        }while(valido == false);

        System.out.print("|| Digite a data e hora (formato dd/MM/yyyy HH:mm): ");
        String data = sc.nextLine();
        System.out.println("");

        return new Medicao(codigo, medicao, data);
    }

}
