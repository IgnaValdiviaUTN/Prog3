import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParcialMejorado {

    public static void main(String[] args) {
        //Caso Verdadero
        //String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
        //String[] dna = {"ATGCGA", "CATTAC", "TTGTGA", "TGAATG", "TCCCTA", "TCACTA"};
        //Caso Falso
        //String[] dna = {"ATGCGA","CAGTGC","TTGTGT","AGAATG","CCGCTA","TCACTG"};
        //String[] dna = {"ATGCGA","CAGTAC","TTGTGA","AGAAGG","TCCCTA","TCACTA"};
        //String[] dna = new String[]{"ATGCAA", "CAGTGC", "TATTCT", "AGACGG", "GCCTCA", "TTACTG"};
        //String[] dna = {"ATGCGA", "CAGTGC", "TTGTGT", "AGAATG", "CCGCTA", "TCACTG"};
        boolean result = isMutant(dna);
        System.out.println(result); // Debe imprimir "true"
    }

    public static boolean isMutant(String[] dna) {

        // Crear una matriz de caracteres a partir del array de Strings
        char[][] dnaMatrix = new char[6][6];
        for (int i = 0; i < 6; i++) {
            dnaMatrix[i] = dna[i].toCharArray();
        }

        // Patrones de expresión regular para buscar las secuencias
        String regexHorizontal = "(A{4}|T{4}|C{4}|G{4})";
        String regexVertical = "([ATCG])\\1{3}";
        String regexDiagonal = "([ATCG])\\1{3}";

        // Comprobar las filas y columnas
        for (int i = 0; i < 6; i++) {
            String row = new String(dnaMatrix[i]);
            String column = "";
            for (int j = 0; j < 6; j++) {
                column += dnaMatrix[j][i];
            }
            if (row.matches(regexHorizontal) || column.matches(regexVertical)) {
                return true;
            }
        }

        // Comprobar las diagonales
        for (int i = 0; i < 3; i++) {
            String diagonal1 = "";
            String diagonal2 = "";
            for (int j = 0; j < 6 - i; j++) {
                diagonal1 += dnaMatrix[j][j + i];
                diagonal2 += dnaMatrix[j + i][j];
            }
            if (diagonal1.matches(regexDiagonal) || diagonal2.matches(regexDiagonal)) {
                return true;
            }
        }

        return false;
    }


}
