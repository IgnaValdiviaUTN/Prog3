public class Parcial {
    public static void main(String[] args) {
        //Caso Verdadero
        //String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
        //String[] dna = {"ATGCGA", "CATTAC", "TTGTGA", "TGAATG", "TCCCTA", "TCACTA"};
        //Caso Falso
        String[] dna = {"ATGCGA","CAGTGC","TTGTGT","AGAATG","CCGCTA","TCACTG"};
        //String[] dna = {"ATGCGA","CAGTAC","TTGTGA","AGAAGG","TCCCTA","TCACTA"};
        //String[] dna = new String[]{"ATGCAA", "CAGTGC", "TATTCT", "AGACGG", "GCCTCA", "TTACTG"};
        //String[] dna = {"ATGCGA", "CAGTGC", "TTGTGT", "AGAATG", "CCGCTA", "TCACTG"};


        System.out.println(isMutant(dna));

    }
    public static boolean isMutant(String[] dna) {
        int filas = dna.length;
        int columnas = dna[0].length();
        int contador = 0;

        //Llamamos a las funciones para buscar secuencias
        //Tanto horizontales,verticales como diagonales
        contador += buscarHorizontales(filas,columnas,dna) + buscarVerticales(filas,columnas,dna) + buscarDiagonales(filas,columnas,dna);

        System.out.println("Se econtraron: " + contador + " genes");
        return (contador >= 2);
    }
    public static int buscarHorizontales(int filas,int columnas,String[] dna){
        //Busqueda de secuencias horizontales
        int contador=0;

        /*Recorro el for tal que tome las posiciones posibles, al ser busqueda horizontal
        * lo necesario es solo hacer 2 movimientos hacia la derecha para verificar toda la logitud del string*/
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j + 1) &&
                        dna[i].charAt(j) == dna[i].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    contador++;
                }
            }
        }
        return contador;
    }
    public static int buscarVerticales(int filas,int columnas,String[] dna){
        int contador = 0;
        /*Recorro el for tal que tome las posiciones posibles, al ser busqueda vertical
         * lo necesario es solo hacer 2 movimientos hacia abajo para verificar toda la logitud del string*/
        for (int i = 0; i <= filas - 4; i++) {
            for (int j = 0; j < columnas; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static int buscarDiagonales(int filas,int columnas,String[] dna){
        int contador = 0;

        /*Recorro el for tal que tome las posiciones posibles, al ser busqueda diagonal en los primeros fors
        * recorro diagonales hacia abajo y despues verifico a partir de una fila y columna posible las diagonales hacia arriba*/

        for (int i = 0; i <= filas - 4; i++) {
            for (int j = 0; j <= columnas - 4; j++) {

                //Hacia abajo
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1) &&
                        dna[i].charAt(j) == dna[i + 2].charAt(j + 2) &&
                        dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    contador++;
                }

                if (dna[i].charAt(j + 3) == dna[i + 1].charAt(j + 2) &&
                        dna[i].charAt(j + 3) == dna[i + 2].charAt(j + 1) &&
                        dna[i].charAt(j + 3) == dna[i + 3].charAt(j)) {
                    contador++;
                }

                //Hacia arriba
                if (i >= 3) {
                    if (dna[i].charAt(j) == dna[i - 1].charAt(j + 1) &&
                            dna[i].charAt(j) == dna[i - 2].charAt(j + 2) &&
                            dna[i].charAt(j) == dna[i - 3].charAt(j + 3)) {
                        contador++;
                    }

                    if (j >= 3) {
                        if (dna[i].charAt(j) == dna[i - 1].charAt(j - 1) &&
                                dna[i].charAt(j) == dna[i - 2].charAt(j - 2) &&
                                dna[i].charAt(j) == dna[i - 3].charAt(j - 3)) {
                            contador++;
                        }
                    }
                }
            }
        }
        return contador;
    }
}
