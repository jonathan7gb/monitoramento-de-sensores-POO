package com.monitoramentosensores;
import com.monitoramentosensores.service.SensorService;
import com.monitoramentosensores.view.Cadastros;
import com.monitoramentosensores.view.Erros;
import com.monitoramentosensores.view.Menus;
import com.monitoramentosensores.view.Sucesso;
import com.monitoramentosensores.view.Sair;
import com.monitoramentosensores.view.Saidas;

public class Main {
    public static void main(String[] args) {

        int opcao = -1;
        Menus menu = new Menus();
        Erros erro = new Erros();
        Cadastros cadastro = new Cadastros();
        Sucesso sucesso = new Sucesso();
        SensorService service = new SensorService();
        Sair sair = new Sair();
        Saidas saidas = new Saidas();

        do{
            opcao = menu.menuPrincipal();

            if(opcao > 0 && opcao <= 6){
                service.gerenciadorSensores(opcao, erro, menu, cadastro, sucesso, saidas);
            }else if(opcao < 0 || opcao > 6){
                erro.erroNumeroInvalido();
            }else{
                sair.sairSistema();
            }
        }while(opcao != 0);


    }
}