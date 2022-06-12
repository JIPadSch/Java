package desarrolloDeAlgoritmos.tp2ArreglosBidimensionales;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int [][] matriz;
        int longitudFila,longitudColumna;
        System.out.println("Ingrese el numero de filas de su matriz");
        longitudFila= sc.nextInt();
        System.out.println("Ingrese el numero de columnas de su matriz");
        longitudColumna= sc.nextInt();
        matriz = new int [longitudFila][longitudColumna];
        cargarMatriz(matriz);
        if(esSimetrica(matriz)){
            System.out.println("Su matriz es simetrica");
        }else{
            System.out.println("Su matriz NO es simetrica");
        }
        scan.close();
    }
    /* Este modulo permite cargar los elementos de la matriz */
    public static void cargarMatriz(int[][]matriz){
        Scanner sc= new Scanner(System.in);
        int i=0,j=0;
        for(i=0;i<matriz.length; i++){
            for(j=0;j<matriz[0].length; j++){
                System.out.println("Ingrese el elemento");
                matriz[i][j] =sc.nextInt();
            }
        }
        scan.close();
    }
    /* Verifica si la matriz es cuadrada */
    public static boolean esCuadrada(int [][] matriz ){
    return matriz.length==matriz[0].length;
    }
    /*Modulo que verificia si la matriz es simetrica*/
    public static boolean esSimetrica(int [][] matriz ){
    int  fila, col;
    boolean simetrica;
    fila=0;
    col=0;
    simetrica=esCuadrada(matriz);
    while(simetrica && fila<matriz.length){
    col=fila+1;
        while(simetrica &&  col<matriz.length){
            if(matriz[fila][col] != matriz[col][fila]){
             simetrica=false;
            }else{
            col++;
            }
        }
       fila++; 
      }
      return simetrica;
    }
}