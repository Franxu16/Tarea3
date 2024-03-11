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
    public void registroDia(int dia, int mes, boolean lluvia) throws Exception{
        if(dia <= 31 && mes <= 12){
            anyo[mes][dia] = lluvia;
        }else{
            throw new Exception("FECHA INCORRECTA O INEXSISTENTE QUE NO PUEDE SER INTRODUCIDA EN EL CALENDARIO");
        }
    }

    public boolean consultarDia(int dia, int mes) throws Exception{
        for (int i = 0; i < anyo.length; i++) {
            for (int j = 0; j < anyo[i].length; j++) {
                if(anyo[i][j] && dia == 1){
                    System.out.println("Dias: " + j);
                    return true;
                }
            }
        }
        System.out.println("No existe el día: ");
        return false;
    }

    public int contarDiasLluviosos() throws Exception{

    }

    public int trimestreLluvioso() throws Exception{

    }

    public int primerDiaLluvia() throws Exception{

    }
}
