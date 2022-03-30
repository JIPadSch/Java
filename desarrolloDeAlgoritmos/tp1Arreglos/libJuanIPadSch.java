package desarrolloDeAlgoritmos.tp1Arreglos;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class libJuanIPadSch {
    //Módulo que permite llenar un arreglo de ints
    public static void llenarArrInt (int[] arrInt){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrInt.length;i++){
            System.out.println("Llenar pos "+i+" : ");
            arrInt[i] = scan.nextInt();
            scan.nextLine();
        }
    }
    //Módulo que muestra por pantalla un arreglo de ints
    public static void imprimirArrInt (int[] arrInt){
        int i;
        for (i=0;i<arrInt.length;i++){
            System.out.println(" "+arrInt[i]+" ");
        }
    }
    //Módulo que permite llenar un arreglo de chars
    public static void llenarArrChar (char[] arrChar){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrChar.length;i++){
            System.out.println("Llenar pos "+i+" : ");
            arrChar[i] = scan.next().charAt(0);
            scan.nextLine();
        }
    }
    //Módulo que muestra por pantalla un arreglo de chars
    public static void imprimirArrChar (char[] arrChar){
        int i;
        for (i=0;i<arrChar.length;i++){
            System.out.println(" "+arrChar[i]+" ");
        }
    }
    //Módulo que permite llenar un arreglo de Strings
    public static void llenarArrString (String[] arrString){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrString.length;i++){
            System.out.println("Llenar pos "+i+" : ");
            arrString[i] = scan.nextLine();
            scan.nextLine();
        }
    }
    //Módulo que muestra por pantalla un arreglo de Strings
    public static void imprimirArrString (String[] arrString){
        int i;
        for (i=0;i<arrString.length;i++){
            System.out.println(" "+arrString[i]+" ");
        }
    }
    //Modulo que permite verificar si dos arreglos bidimensionales de ints son iguales
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