package es.iesmz.tests;

import java.util.Arrays;

public class DiasLluvia {
    //Atributos
    private boolean[][] anyo;


    //Constructor
    public DiasLluvia() {
        boolean anyo[][] = new boolean[12][31];
    }

    //Metodos
    public boolean registroDia(int dia, int mes, boolean lluvia){
        if(dia < 1 || mes < 1 || dia > anyo.length || mes > anyo[0].length){
            System.out.println("NO SE HA PODIDO REGISTRAR EL DIA DESEADO");
            return false;
        }
        anyo[mes-1][dia-1] = lluvia;
        return true;
    }

    public boolean consultarDia(int dia, int mes) throws Exception{
        if(dia < 1 || mes < 1 || dia > anyo.length || mes > anyo[0].length){
            System.out.println("El " + dia + "de " + mes + "esta fuera del rango de registro");
            return false;
        }
        return anyo[mes-1][dia-1];
    }

    public int contarDiasLluviosos() throws Exception{
        int C = 0;
        for (int i = 0; i < anyo.length; i++) {
            for (int j = 0; j < anyo[i].length; j++) {
                if (anyo[i][j]) C++;
            }
        }
        return C;
    }
    public int trimestreLluvioso() throws Exception {
        int[] trimestres = new int[4];

        for (int i = 0; i < anyo.length; i++) {
            for (int j = 0; j < anyo[i].length; j++) {
                if (anyo[i][j]) {
                    if (i >= 0 && i <= 2) { // Trimestre 1: enero a marzo
                        trimestres[0]++;
                    } else if (i >= 3 && i <= 5) { // Trimestre 2: abril a junio
                        trimestres[1]++;
                    } else if (i >= 6 && i <= 8) { // Trimestre 3: julio a septiembre
                        trimestres[2]++;
                    } else { // Trimestre 4: octubre a diciembre
                        trimestres[3]++;
                    }
                }
            }
        }

        int trimestreMasLluvioso = 0;
        int maxLluvia = trimestres[0];
        for (int i = 1; i < trimestres.length; i++) {
            if (trimestres[i] > maxLluvia) {
                maxLluvia = trimestres[i];
                trimestreMasLluvioso = i;
            }
        }

        return trimestreMasLluvioso + 1;
    }
}
