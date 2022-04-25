package desarrolloDeAlgoritmos.tp4Recursividad;

import desarrolloDeAlgoritmos.tp3TDA.ejercicio12.intAleatorio;

/**
 *
 * @author JuanPadSch
 */
public class ejercicio7 {
    /* 
    *  Diseñar e implementar un algoritmo recursivo para calcular y mostrar la suma de cada una de
    *  las filas de una matriz de enteros.
    */
    public static void main(String[] args) {
        int fil=0, col=0;
        int[][] matriz = new int[12][4];
        libreriaJuanIPadSch.arreglosBidi.cargarAutoMatrizCuadrada(matriz);
        libreriaJuanIPadSch.arreglosBidi.imprimirArrBidInt(matriz);
        System.out.println("-------------------------------");
        sumaFilasMuestraRecursivo(matriz, fil, col);
    }
    /* Modulo recursivo */
    public static int sumaFilasMuestraRecursivo(int[][] matriz, int fil, int col){
        int suma=0;
        //Recorremos las columnas
        if (col<matriz[0].length) {
            suma+=sumaFilasMuestraRecursivo(matriz, fil, col+1);
            if ((col-1)>=0){
                suma+=matriz[fil][col-1];
            }
        } else {
            suma=matriz[fil][col-1];
        }
        //Aumentamos la fila
        if (fil<matriz[0].length && (col-1)==-1){
            System.out.println("Suma de la fila "+(fil+1)+" es: "+suma);
            if(fil+1<matriz.length){ //Entramos solo si no nos pasamos de filas
                suma+=sumaFilasMuestraRecursivo(matriz,fil+1,0);
            }
        }
        return suma; 
    }
}