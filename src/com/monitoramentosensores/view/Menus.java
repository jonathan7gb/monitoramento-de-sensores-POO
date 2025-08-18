package com.monitoramentosensores.view;
import java.util.Scanner;

public class Menus {

    Erros erro = new Erros();
    Scanner sc = new Scanner(System.in);
    public int menuPrincipal(){
        boolean valido = false;
        int opcao = -1;

        System.out.println("|| ========================================= ||");
        System.out.println("|| Sistema de Monitoramento WEG - Versão 1.0 ||");
        System.out.println("|| ========================================= ||");
        System.out.println("|| 1 - Cadastrar Sensor                      ||");
        System.out.println("|| 2 - Listar Sensores                       ||");
        System.out.println("|| 3 - Listar Sensores Críticos              ||");
        System.out.println("|| 4 - Registrar Medição                     ||");
        System.out.println("|| 5 - Exibir Histórico de Medições          ||");
        System.out.println("|| 6 - Verificar Alertas                     ||");
        System.out.println("|| 0 - Sair                                  ||");
        System.out.println("|| ========================================= ||");

        do{
            System.out.print("|| Digite a opção: ");
            String opcaoStr = sc.nextLine();

            try{
                opcao = Integer.parseInt(opcaoStr);
                valido = true;
            } catch (NumberFormatException e) {
                erro.ErroInputInvalido();
            }
        }while(valido == false);

        return opcao;
    }
}
