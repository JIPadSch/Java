import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class libJuanIPadSch {
    //Módulo que verifica si un caractér es letra
    public static boolean charEsLetra(char caracter){
        boolean esLetra=false;
        /*Hacemos una verificación de ASCII. De la A hasta la Z,
        los valores númericos van del 65 al 122 (incluidos)*/
        if (caracter>=65 && caracter<=122){
            esLetra=true;                
        }
        return esLetra;
    }
    //Módulo que permite llenar un arreglo de ints
    public static void llenarArrInt (int[] arrInt){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrInt.length;i++){
            System.out.println("Llenar posición "+i+" : ");
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
            System.out.println("Llenar posición "+i+" : ");
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
            System.out.println("Llenar posición "+i+" : ");
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
    //Módulo que permite llenar un arreglo de doubles
    public static void llenarArrDouble (double[] arrDouble){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrDouble.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrDouble[i] = scan.nextDouble();
            scan.nextLine();
        }
    }
    //Módulo que muestra por pantalla un arreglo de doubles
    public static void imprimirArrDouble (double[] arrDouble){
        int i;
        for (i=0;i<arrDouble.length;i++){
            System.out.println(" "+arrDouble[i]+" ");
        }
    }
    //Módulo que permite llenar un arreglo de booleans
    public static void llenarArrBoolean (boolean[] arrBoolean){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrBoolean.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrBoolean[i] = scan.nextBoolean();
            scan.nextLine();
        }
    }
    //Módulo que muestra por pantalla un arreglo de booleans
    public static void imprimirArrBoolean (boolean[] arrBoolean){
        int i;
        for (i=0;i<arrBoolean.length;i++){
            System.out.println(" "+arrBoolean[i]+" ");
        }
    }
    //Módulo que permite llenar un arreglo bidimensional de enteros
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
    //Módulo que muestra por pantalla un arreglo bidimensional de enteros
    public static void imprimirArrBidInt (int[][] arrBidInt){
        int i,j;
        for (i=0;i<arrBidInt.length;i++){
            for(j=0;j<arrBidInt[i].length;j++){
                System.out.println(" |"+arrBidInt[i][j]+"| ");
            }
        }
    }
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