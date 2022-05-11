package desarrolloDeAlgoritmos.tp2ArreglosBidimensionales;
import java.util.*;
import libreriaJuanIPadSch.*;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio1 {
    /*Este algoritmo permite cargar una matriz de eneteros y luego mostrarla por pantalla,
    mostrando a los elementos de una misma fila juntos y cuando se cambia de fila, se muestra
    los números en el siguiente renglón. El usuario elige cantidad de filas y columnas*/
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);
        int filas=0, columnas=0;
        boolean filaColuCorrecto=false;
        int[][] arrBidInt;
        while (!filaColuCorrecto){
            System.out.println("Ingrese un número de filas: ");
            filas = scan.nextInt();
            scan.nextLine();
            System.out.println("Ingrese un número de columnas: ");
            columnas = scan.nextInt();
            scan.nextLine();
            if (filas>0 && columnas>0){
                filaColuCorrecto=true;
            } else{
                System.out.println("ERROR: Las filas y columnas deben ser mayor a 0");
            }
        }
        arrBidInt = new int[filas][columnas];
        llenarArrBidInt(arrBidInt);
        imprimirArrBidInt(arrBidInt);
    }
        /*Módulo que permite llenar un arreglo bidimensional de enteros*/
        public static void llenarArrBidInt (int[][] arrBidInt){
            Scanner scan = new Scanner (System.in);
            int i,j;
            for (i=0;i<arrBidInt.length;i++){
                for(j=0;j<arrBidInt[i].length;j++){
                    System.out.println("Llenar posición "+i+"|"+j+" : ");
                    arrBidInt[i][j] = scan.nextInt();
                    scan.nextLine();
                }
            }
        }
        /*Módulo que muestra por pantalla un arreglo bidimensional de enteros*/
        public static void imprimirArrBidInt (int[][] arrBidInt){
            int i,j;
            for (i=0;i<arrBidInt.length;i++){
                for(j=0;j<arrBidInt[i].length;j++){
                    System.out.println(" |"+arrBidInt[i][j]+"| ");
                }
                System.out.println();
            }
        }        
}
