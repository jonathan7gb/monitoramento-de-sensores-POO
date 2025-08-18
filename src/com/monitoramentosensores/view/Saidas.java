package com.monitoramentosensores.view;

public class Saidas {

    public void sensorJaCadastrado(){
        System.out.println("\n|| ⚠\uFE0F Erro: Já existe um sensor com esse código cadastrado! \n");
    }

    //=======================================

    public void inspecaoRecomendada(){
        System.out.println("\n⚠\uFE0F ATENÇÃO: Inspeção imediata recomendada!\n");
    }

    //=======================================

    public void MedicaoForaDoLimiteTecnico(){
        System.out.print("|| ⚠\uFE0F ALERTA: Medição fora do limite técnico!");
    }

    //=======================================

    public void listaVazia(){
        System.out.println("\n|| A Lista de Sensores está vazia ||\n");
    }

    //=======================================

    public void listaVaziaMedicao(){
        System.out.println("\n|| A Lista de Medições está vazia ||\n");
    }

    //=======================================

    public void NenhumSensorEncontrado(){
        System.out.println("|| Nenhum Sensor Encontrado ||\n");
    }

    //=======================================

    public void verificandoSensores(){
        try{
            Thread.sleep(300);
            System.out.print("\nVe");
            Thread.sleep(300);
            System.out.print("ri");
            Thread.sleep(300);
            System.out.print("fi");
            Thread.sleep(300);
            System.out.print("ca");
            Thread.sleep(300);
            System.out.print("nd");
            Thread.sleep(300);
            System.out.print("o ");
            Thread.sleep(300);
            System.out.print("Se");
            Thread.sleep(300);
            System.out.print("ns");
            Thread.sleep(300);
            System.out.print("or");
            Thread.sleep(300);
            System.out.print("es");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".\n");
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
