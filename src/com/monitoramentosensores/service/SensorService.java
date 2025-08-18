package com.monitoramentosensores.service;
import com.monitoramentosensores.model.Sensor;
import com.monitoramentosensores.model.SensorTemperatura;
import com.monitoramentosensores.model.SensorVibracao;
import com.monitoramentosensores.model.Medicao;
import com.monitoramentosensores.view.Cadastros;
import com.monitoramentosensores.view.*;
import java.util.ArrayList;
import java.util.List;

public class SensorService {

    protected List<Sensor> Lista_de_Sensores;
    protected List<Medicao> Lista_de_Medicoes;

    public SensorService(){
        this.Lista_de_Sensores = new ArrayList<>();
        this.Lista_de_Medicoes = new ArrayList<>();
    }

    public List<Sensor> getLista_de_Sensores(){
        return Lista_de_Sensores;
    }

    public void setLista_de_Sensores(List<Sensor> Lista_de_Sensores){
        this.Lista_de_Sensores = Lista_de_Sensores;
    }

    public List<Medicao> getLista_de_Medicoes(){
        return Lista_de_Medicoes;
    }

    public void setLista_de_Medicoes(List<Medicao> Lista_de_Medicoes){
        this.Lista_de_Medicoes = Lista_de_Medicoes;
    }

    public void gerenciadorSensores(int opcaoMenuPrincipal, Erros erro, Menus menu, Cadastros cadastro, Sucesso sucesso, Saidas saidas){

        switch (opcaoMenuPrincipal){
            case 1 -> {
                boolean achou = false;

                cadastro.headerCadastro();
                String codigo = cadastro.inputCodigoSensor();

                for(Sensor sensor : Lista_de_Sensores){
                    if(sensor instanceof  SensorTemperatura sensorTemperatura){
                        if(sensorTemperatura.getCodigo().equalsIgnoreCase(codigo)){
                            saidas.sensorJaCadastrado();
                            achou = true;
                            break;
                        }
                    }else if(sensor instanceof  SensorVibracao sensorVibracao){
                        if(sensorVibracao.getCodigo().equalsIgnoreCase(codigo)){
                            saidas.sensorJaCadastrado();
                            achou = true;
                            break;
                        }
                    }
                }

                if(achou == false){
                    String nomeEquipamento = cadastro.inputEquipamentoSensor();
                    int tipoSensor = cadastro.inputTipoSensor();

                    if(tipoSensor == 1){
                        SensorTemperatura sensorTemp = cadastro.cadastroSensorTemperatura(codigo, nomeEquipamento, "Temperatura", 0);
                        Lista_de_Sensores.add(sensorTemp);
                        sucesso.sensorCadastradoComSucesso("Temperatura", "temperatura > 80ºC");
                    }else if(tipoSensor == 2){
                        SensorVibracao sensorVib = cadastro.cadastroSensorVibracao(codigo, nomeEquipamento, "Vibração",0);
                        Lista_de_Sensores.add(sensorVib);
                        sucesso.sensorCadastradoComSucesso("Vibração", "vibração > 60hz > vibração");
                    }else{
                        erro.erroNumeroInvalido();
                    }
                }

            }//ENCERRA CASE 1 DA OPÇÃO DO MENU PRINCIPAL

            case 2 -> {
                if(Lista_de_Sensores.isEmpty()){
                    saidas.listaVazia();
                }else {
                    System.out.println("\n|| Sensores cadastrados: \n");
                    for (Sensor sensor : Lista_de_Sensores) {
                        if (sensor instanceof SensorTemperatura sensorTemp) {
                            System.out.println(sensorTemp);
                        } else if (sensor instanceof SensorVibracao sensorVibracao) {
                            System.out.println(sensorVibracao);
                        }
                    }
                }
                System.out.println("");
            }//ENCERRA CASE 2 DA OPÇÃO DO MENU PRINCIPAL

            case 3 -> {
                if(Lista_de_Sensores.isEmpty()){
                    saidas.listaVazia();
                }else{
                    boolean encontrado = false;

                    System.out.println("\n|| Sensores com mais de 3 alertas: \n");

                    for(Sensor sensor : Lista_de_Sensores){
                        if(sensor instanceof SensorTemperatura sensorTemperatura){
                            if(sensorTemperatura.getTotalDeAlertas() > 3){
                                System.out.println(sensorTemperatura + " | Alertas: " + sensorTemperatura.getTotalDeAlertas());
                                encontrado = true;
                            }
                        }else if(sensor instanceof SensorVibracao sensorVibracao){
                            if(sensorVibracao.getTotalDeAlertas() > 3){
                                System.out.println(sensorVibracao + " | Alertas: " + sensorVibracao.getTotalDeAlertas());
                                encontrado = true;
                            }
                        }
                    }

                    if(encontrado == false){
                        saidas.NenhumSensorEncontrado();
                    }else{
                        saidas.inspecaoRecomendada();
                    }
                }
            }//ENCERRA CASE 3 DA OPÇÃO DO MENU PRINCIPAL

            case 4 -> {

                if(Lista_de_Sensores.isEmpty()){
                    saidas.listaVazia();
                }else{
                    boolean encontrado = false;
                    Medicao medicao = cadastro.cadastrarMedicao();
                    String tipo = "";


                    for(Sensor sensor : Lista_de_Sensores){
                        if (sensor instanceof SensorTemperatura sensorTemperatura){
                            if(sensorTemperatura.getCodigo().equalsIgnoreCase(medicao.getCodigoSensor())){
                                encontrado = true;
                                if(medicao.getValor() > 80){
                                    sensorTemperatura.addAlertaAoTotal();
                                    sucesso.medicaoCadastradaComSucesso();
                                    saidas.MedicaoForaDoLimiteTecnico();
                                    System.out.println("(" + medicao.getValor() +"ºC > 80ºC)\n");
                                }
                            }
                        }else if(sensor instanceof SensorVibracao sensorVibracao){
                            if(sensorVibracao.getCodigo().equalsIgnoreCase(medicao.getCodigoSensor())){
                                encontrado = true;
                                if(medicao.getValor() != 60){
                                    sensorVibracao.addAlertaAoTotal();
                                    sucesso.medicaoCadastradaComSucesso();
                                    saidas.MedicaoForaDoLimiteTecnico();
                                    System.out.println("(" + medicao.getValor() +"Hz != 60Hz)\n");
                                }
                            }
                        }
                    }

                    if(encontrado == false){
                        System.out.println("");
                        saidas.NenhumSensorEncontrado();
                    }else{
                        Lista_de_Medicoes.add(medicao);
                    }
                }

            } //ENCERRA CASE 4 DA OPÇÃO DO MENU PRINCIPAL

            case 5 -> {
                if(Lista_de_Sensores.isEmpty()){
                    saidas.listaVazia();
                }else if(Lista_de_Medicoes.isEmpty()){
                    saidas.listaVaziaMedicao();
                }else{
                    int totalMedicoes = 1;
                    System.out.println("");
                    String codigo = cadastro.inputCodigoSensor();

                    for(Medicao medicao : Lista_de_Medicoes){
                        if(medicao.getCodigoSensor().equalsIgnoreCase(codigo)){
                            System.out.println("\nHistórico de Medições do Sensor "+ codigo +":\n");
                            break;
                        }
                    }

                    for(Medicao medicao : Lista_de_Medicoes){
                        if(medicao.getCodigoSensor().equalsIgnoreCase(codigo)){
                            System.out.print("|| " + totalMedicoes + ". ");
                            System.out.print(medicao);
                            totalMedicoes++;

                            for(Sensor sensor : Lista_de_Sensores){
                                if (sensor instanceof SensorTemperatura sensorTemperatura){
                                    if(sensorTemperatura.getCodigo().equalsIgnoreCase(medicao.getCodigoSensor())){
                                        if (medicao.getValor() > 80){
                                            System.out.println(" ⚠\uFE0F ALERTA");
                                        }
                                    }
                                }else if(sensor instanceof SensorVibracao sensorVibracao){
                                    if (sensorVibracao.getCodigo().equalsIgnoreCase(medicao.getCodigoSensor())){
                                        if (medicao.getValor() != 60){
                                            System.out.println(" ⚠\uFE0F ALERTA");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("\n");
                }

            } //ENCERRA CASE 5 DA OPÇÃO DO MENU PRINCIPAL

            case 6 -> {
                saidas.verificandoSensores();

                if(Lista_de_Sensores.isEmpty()){
                    saidas.listaVazia();
                }else{
                    for(Sensor sensor : Lista_de_Sensores){
                        if (sensor instanceof SensorTemperatura sensorTemperatura) {
                            System.out.println("Sensor " + sensorTemperatura.getCodigo() + " (Temperatura) - " + sensorTemperatura.getNomeEquip());
                            if(sensorTemperatura.getTotalDeAlertas() > 0){
                                System.out.println("⚠\uFE0F "+ sensorTemperatura.getTotalDeAlertas() +" alerta(s) detectado(s)\n");
                            }else{
                                System.out.println("✅ Nenhum alerta!\n");
                            }
                        }else if(sensor instanceof  SensorVibracao sensorVibracao){
                            System.out.println("Sensor " + sensorVibracao.getCodigo() + " (Vibração) - " + sensorVibracao.getNomeEquip());
                            if(sensorVibracao.getTotalDeAlertas() > 0){
                                System.out.println("⚠\uFE0F "+ sensorVibracao.getTotalDeAlertas() +" alerta(s) detectado(s)\n");
                            }else{
                                System.out.println("✅ Nenhum alerta!\n");
                            }
                        }
                    }

                }
            } //ENCERRA CASE 6 DA OPÇÃO DO MENU PRINCIPAL

        } //ENCERRA O SWITCH DA OPÇÃO DO MENU PRINCIPAL

    }
}
