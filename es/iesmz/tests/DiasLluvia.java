package es.iesmz.tests;

import java.util.Arrays;

public class DiasLluvia {
    // Atributos
    private boolean[][] anyo;

    // Constructor
    public DiasLluvia() {
        this.anyo = new boolean[12][31]; // Inicializamos el atributo anyo de la clase
    }

    // Métodos
    public boolean registroDia(int dia, int mes, boolean lluvia) {
        if (dia < 1 || mes < 1 || mes > 12 || dia > diasEnMes(mes)) {
            System.out.println("NO SE HA PODIDO REGISTRAR EL DIA DESEADO: Fecha fuera de rango.");
            return false;
        }
        anyo[mes - 1][dia - 1] = lluvia;
        return true;
    }

    public boolean consultarDia(int dia, int mes) throws Exception {
        if (dia < 1 || mes < 1 || dia > anyo.length || mes > anyo[0].length) {
            System.out.println("El " + dia + " de " + mes + " está fuera del rango de registro");
            return false;
        }
        return anyo[mes - 1][dia - 1];
    }

    public int contarDiasLluviosos() throws Exception {
        int C = 0;
        for (int i = 0; i < anyo.length; i++) {
            for (int j = 0; j < anyo[i].length; j++) {
                if (anyo[i][j])
                    C++;
            }
        }
        return C;
    }

    public int trimestreLluvioso() throws Exception {
        if (anyo == null) {
            throw new IllegalStateException("El array anyo no ha sido inicializado");
        }

        int[] trimestres = new int[4]; // Array para almacenar la cantidad de días lluviosos por trimestre

        // Iteramos sobre los meses y contamos los días lluviosos por trimestre
        for (int mes = 1; mes <= 12; mes++) {
            int trimestre = (mes - 1) / 3; // Calculamos el índice del trimestre (0, 1, 2, o 3)
            for (int dia = 1; dia <= 31; dia++) {
                // Verificamos que el día consultado no se encuentre fuera del rango del array
                if (mes <= anyo.length && dia <= anyo[mes - 1].length) {
                    if (consultarDia(dia, mes)) {
                        trimestres[trimestre]++; // Incrementamos el contador de días lluviosos del trimestre actual
                    }
                }
            }
        }

        // Buscamos el trimestre con más días lluviosos
        int trimestreMasLluvioso = 0;
        int maxDiasLluviosos = trimestres[0];
        for (int i = 1; i < trimestres.length; i++) {
            if (trimestres[i] > maxDiasLluviosos) {
                trimestreMasLluvioso = i;
                maxDiasLluviosos = trimestres[i];
            }
        }

        // Retornamos el trimestre más lluvioso (añadimos 1 porque el índice comienza en 0)
        return trimestreMasLluvioso + 1;
    }
    public int primerDiaLluvia() throws Exception {
        for (int dia = 1; dia <= 365; dia++) {
            int mes = (dia - 1) / 31 + 1; // Calculamos el mes correspondiente al día
            int diaEnMes = (dia - 1) % 31 + 1; // Calculamos el día dentro del mes

            if (consultarDia(diaEnMes, mes)) {
                return dia; // Devolvemos el primer día lluvioso encontrado
            }
        }
        return -1; // Devolvemos -1 si no hay días lluviosos registrados este año
    }
    // Método auxiliar para obtener el número de días en un mes
    private int diasEnMes(int mes) {
        switch (mes) {
            case 2:
                return 28; // Simplificado para el ejemplo, considera años bisiestos en una implementación real
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
}
