package br.com.zup.desafio.helpers;

import br.com.zup.desafio.models.Veiculo;

import java.util.Calendar;
import java.util.List;

public class VeiculoHelper {

    public static boolean disponibilidadeVeiculo(Veiculo veiculo){

        Calendar dataAtual = Calendar.getInstance();
        Integer diaDaSemana = dataAtual.get(Calendar.DAY_OF_WEEK);
        String anoVeiculo = veiculo.getAno_modelo();
        Integer ultimoDigitoAno = Integer.parseInt(String.valueOf(anoVeiculo.charAt(3))); //convertendo último digito para inteiro
        Integer diaDisponivel = 0;

        /* Validação dias da semana em inteiro:
           Domingo: 1
           Segunda: 2
           Terça: 3
           Quarta: 4
           Quinta: 5
           Sexta: 6
           Sábado: 7
         */

       if(ultimoDigitoAno < 2) {
           diaDisponivel = 2;
       } else if(ultimoDigitoAno < 4) {
           diaDisponivel = 3;
       } else if(ultimoDigitoAno < 6) {
           diaDisponivel = 4;
       } else if(ultimoDigitoAno < 8) {
           diaDisponivel = 5;
       } else {
           diaDisponivel = 6;}

       if(diaDisponivel == diaDaSemana){
           return true;
       }
        return false;
    }

    public static List<Veiculo> disponibilidadeVeiculos(List<Veiculo> veiculos) {

        for (int i = 0; i < veiculos.size(); i++) {

            Calendar dataAtual = Calendar.getInstance();
            Integer diaDaSemana = dataAtual.get(Calendar.DAY_OF_WEEK);
            String anoVeiculo = veiculos.get(i).getAno_modelo();
            Integer ultimoDigitoAno = Integer.parseInt(String.valueOf(anoVeiculo.charAt(3))); //convertendo último digito para inteiro
            Integer diaDisponivel = 0;

            if (ultimoDigitoAno < 2) {
                diaDisponivel = 2;
            } else if (ultimoDigitoAno < 4) {
                diaDisponivel = 3;
            } else if (ultimoDigitoAno < 6) {
                diaDisponivel = 4;
            } else if (ultimoDigitoAno < 8) {
                diaDisponivel = 5;
            } else {
                diaDisponivel = 6;
            }

            if (diaDisponivel == diaDaSemana) {
                veiculos.get(i).setDisponivel(true);
            } else {
                veiculos.get(i).setDisponivel(false);
            }
        }
            return veiculos;
    }
}
