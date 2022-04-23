package libreriaJuanIPadSch;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author JuanPadSch
 */
public class arreglosBidi {
    /* Módulo que permite llenar un arreglo bidimensional de enteros */
    public static void llenarArrBidInt(int[][] arrBidInt) {
        Scanner scan = new Scanner(System.in);
        int i, j;
        for (i = 0; i < arrBidInt.length; i++) {
            for (j = 0; j < arrBidInt[i].length; j++) {
                System.out.println("Llenar posición " + i + "|" + j + " : ");
                arrBidInt[i][j] = scan.nextInt();
                scan.nextLine();
            }
        }
    }
    /* Módulo que muestra por pantalla un arreglo bidimensional de enteros */
    public static void imprimirArrBidInt(int[][] arrBidInt) {
        int i, j;
        for (i = 0; i < arrBidInt.length; i++) {
            for (j = 0; j < arrBidInt[i].length; j++) {
                System.out.println(" |" + arrBidInt[i][j] + "| ");
            }
        }
    }
    /*
     * Módulo que permite verificar si dos arreglos bidimensionales de ints son
     * iguales
     */
    public static boolean arrBidIntIguales(int[][] arrInt1, int[][] arrInt2) {
        int i = 0, j;
        boolean esIgual = (arrInt1.length == arrInt2.length && arrInt2[0].length == arrInt2[0].length);
        while (esIgual && i < arrInt1.length) {
            j = 0;
            while (esIgual && j < arrInt1[0].length) {
                if (arrInt1[i][j] == arrInt2[i][j]) {
                    j++;
                } else {
                    esIgual = false;
                }
            }
            i++;
        }
        return esIgual;
    }
    /*Módulo que carga (simétricamente) automaticamente una matriz cuadrada*/
    public static void cargarAutoSimetriMatrizCuadrada(int[][] matrizCuadrada){
        int i,j;
        for (i=0;i<matrizCuadrada.length;i++){
            for (j=0;j<matrizCuadrada[0].length;j++){
                matrizCuadrada[i][j]=i+j;
            }
        }
    }
    /*Módulo que carga automaticamente una matriz con números aleatorios*/
    public static void cargarAutoMatrizCuadrada(int[][] matrizCuadrada){
        int i,j;
        for (i=0;i<matrizCuadrada.length;i++){
            for (j=0;j<matrizCuadrada[i].length;j++){
                matrizCuadrada[i][j]=ThreadLocalRandom.current().nextInt(-32,32);
            }
        }
    }
}