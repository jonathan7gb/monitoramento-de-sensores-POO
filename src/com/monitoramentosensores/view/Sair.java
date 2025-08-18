package com.monitoramentosensores.view;

public class Sair {

    public void sairSistema(){
        try{
            System.out.print("\n|");
            Thread.sleep(250);
            System.out.print("|");
            Thread.sleep(250);
            System.out.print("  S");
            Thread.sleep(250);
            System.out.print("a");
            Thread.sleep(250);
            System.out.print("i");
            Thread.sleep(250);
            System.out.print("n");
            Thread.sleep(250);
            System.out.print("d");
            Thread.sleep(250);
            System.out.print("o");
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
            System.out.print(".");
            Thread.sleep(250);
            System.out.print("\n|");
            Thread.sleep(250);
            System.out.print("|");
            Thread.sleep(250);
            System.out.println(" Obrigado por usar o Monitoramento WEG!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
