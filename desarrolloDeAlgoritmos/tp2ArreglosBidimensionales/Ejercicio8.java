package desarrolloDeAlgoritmos.tp2ArreglosBidimensionales;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio8 {
<<<<<<< HEAD
    /*Dada una matriz de números enteros de dimensión NxN, se desea verificar si la matriz es simétrica o
    antisimétrica con respecto a la diagonal principal. Implemente un algoritmo que luego de cargar una
    matriz realice la verificación solicitada y muestre por pantalla un cartel adecuado*/
=======
>>>>>>> f41e816fb61ad05abf18109b044fba107f8e2a20
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
<<<<<<< HEAD
    }
    /*Este modulo permite cargar los elementos de la matriz*/
=======
        scan.close();
    }
    /* Este modulo permite cargar los elementos de la matriz */
>>>>>>> f41e816fb61ad05abf18109b044fba107f8e2a20
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
<<<<<<< HEAD
    /*Este modulo verifica que la matriz sea cuadrada*/
=======
    /* Verifica si la matriz es cuadrada */
>>>>>>> f41e816fb61ad05abf18109b044fba107f8e2a20
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
<<<<<<< HEAD
    }    
=======
    }
>>>>>>> f41e816fb61ad05abf18109b044fba107f8e2a20
}