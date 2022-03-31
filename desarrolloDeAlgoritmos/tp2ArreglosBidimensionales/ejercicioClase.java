package desarrolloDeAlgoritmos.tp2ArreglosBidimensionales;
public class ejercicioClase {
    //Módulo que permite verificar si dos arreglos bidimensionales de ints son iguales
    public static boolean arrBidIntIguales (int[][] arr1, int[][] arr2){
        int i=0,j;
        boolean esIgual = (arr1.length==arr2.length && arr2[0].length==arr2[0].length);
        while (esIgual && i<arr1.length){
            j=0;
            while (esIgual && j<arr1[0].length){
                if (arr1[i][j] == arr2[i][j]){
                    j++;
                } else{
                    esIgual = false;
                }
            }
            i++;
        }
        return esIgual;
    }
}
