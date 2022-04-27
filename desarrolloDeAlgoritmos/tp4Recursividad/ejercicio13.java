package desarrolloDeAlgoritmos.tp4Recursividad;
import desarrolloDeAlgoritmos.tp1Arreglos.libJuanIPadSch;
import libreriaJuanIPadSch.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio13 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que obtenga el número mayor de una matriz
    *  numérica.
    */
    public static void main(String[] args) {
        int matriz[][] = new int [4][4];
        libreriaJuanIPadSch.arreglosBidi.llenarArrBidIntAleS(matriz);
        System.out.println("Trabajaremos con la siguiente matriz (llenada aleatoriamente): ");
        libreriaJuanIPadSch.arreglosBidi.imprimirArrBidInt(matriz);
        System.out.println("El numero mayor es: "+numMayorMatrizRecursivo(matriz, 0, 0, 0));
    }
    /* Metodo recursivo */
    public static int numMayorMatrizRecursivo(int[][] matriz, int fil, int col, int numMayor){
        int numAux=0;
        if (col<matriz[0].length) {
            numAux=numMayorMatrizRecursivo(matriz, fil, col+1,numMayor); //Caso general
            if(col-1 > -1) { //Si no nos vamos de rango
                numMayor=matriz[fil][col-1];
                if(numAux>numMayor){ //Si numAux es mayor que numMayor, cambiamos a numMayor
                    numMayor=numAux;
                }
            }
        } else { //Si llegamos al final de las columnas, asignamos el ultimo valor a numMayor
            numMayor=matriz[fil][col-1];
        }
        //Aumentamos la fila
        if (fil<matriz[0].length && (col-1)==-1){ //Entramos siempre que falten filas y que estemos en col 0
            if(fil+1<matriz.length){ //Entramos solo si no nos pasamos de filas
                numAux=numMayorMatrizRecursivo(matriz,fil+1,0,numMayor);
            }
        }
        return numMayor;
    }
}
