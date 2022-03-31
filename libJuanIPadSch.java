import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class libJuanIPadSch {
    /*Módulo que verifica si un caractér es letra*/
    public static boolean charEsLetra(char caracter){
        boolean esLetra=false;
        /*Hacemos una verificación de ASCII. De la A hasta la Z,
        los valores númericos van del 65 al 122 (incluidos)*/
        if (caracter>=65 && caracter<=122){
            esLetra=true;                
        }
        return esLetra;
    }
    /*Módulo que permite llenar un arreglo de ints*/
    public static void llenarArrInt (int[] arrInt){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrInt.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrInt[i] = scan.nextInt();
            scan.nextLine();
        }
    }
    /*Módulo que muestra por pantalla un arreglo de ints*/
    public static void imprimirArrInt (int[] arrInt){
        int i;
        for (i=0;i<arrInt.length;i++){
            System.out.println(" "+arrInt[i]+" ");
        }
    }
    /*Módulo que devuelve el elemento mayor de un arreglo de ints*/
    public static int numMayorArrInt (int[] arrInt){
        int i, numMayor=arrInt[0];
        for (i=0;i<arrInt.length;i++){
            if (arrInt[i]>numMayor){
                numMayor=arrInt[i];
            }
        }
        return numMayor;
    }
    /*Módulo que devuelve el elemento menor de un arreglo de ints*/
    public static int numMenorArrInt (int[] arrInt){
        int i, numMenor=arrInt[0];
        for (i=0;i<arrInt.length;i++){
            if (arrInt[i]<numMenor){
                numMenor = arrInt[i];
            }
        }
        return numMenor;
    }
    /*Módulo que devuelve el número mayor y el menor de un arreglo dentro
    de un nuevo arreglo, donde el mayor se ubica en el espacio [0]
    y el menor se ubica en el espacio [1]*/
    public static int[] numMayorMenorArrInt (int[] arrInt){
        int i;
        int[] numMayorMenor = new int [2];
        numMayorMenor[0] = arrInt[0]; //numMayor
        numMayorMenor[1] = arrInt[0]; //numMenor
        for (i=0;i<arrInt.length;i++){
            if (arrInt[i]>numMayorMenor[0]){
                numMayorMenor[0] = arrInt[i];
            } else if (arrInt[i]<numMayorMenor[1]){
                numMayorMenor[1] = arrInt[i];
            }
        }
        return numMayorMenor;
    }
    /*Módulo que permite llenar un arreglo de chars*/
    public static void llenarArrChar (char[] arrChar){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrChar.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrChar[i] = scan.next().charAt(0);
            scan.nextLine();
        }
    }
    /*Módulo que muestra por pantalla un arreglo de chars*/
    public static void imprimirArrChar (char[] arrChar){
        int i;
        for (i=0;i<arrChar.length;i++){
            System.out.println(" "+arrChar[i]+" ");
        }
    }
    /*Módulo que permite llenar un arreglo de Strings*/
    public static void llenarArrString (String[] arrString){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrString.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrString[i] = scan.nextLine();
            scan.nextLine();
        }
    }
    /*Módulo que muestra por pantalla un arreglo de Strings*/
    public static void imprimirArrString (String[] arrString){
        int i;
        for (i=0;i<arrString.length;i++){
            System.out.println(" "+arrString[i]+" ");
        }
    }
    /*Módulo que permite llenar un arreglo de doubles*/
    public static void llenarArrDouble (double[] arrDouble){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrDouble.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrDouble[i] = scan.nextDouble();
            scan.nextLine();
        }
    }
    /*Módulo que muestra por pantalla un arreglo de doubles*/
    public static void imprimirArrDouble (double[] arrDouble){
        int i;
        for (i=0;i<arrDouble.length;i++){
            System.out.println(" "+arrDouble[i]+" ");
        }
    }
    /*Módulo que permite llenar un arreglo de booleans*/
    public static void llenarArrBoolean (boolean[] arrBoolean){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrBoolean.length;i++){
            System.out.println("Llenar posición "+i+" : ");
            arrBoolean[i] = scan.nextBoolean();
            scan.nextLine();
        }
    }
    /*Módulo que muestra por pantalla un arreglo de booleans*/
    public static void imprimirArrBoolean (boolean[] arrBoolean){
        int i;
        for (i=0;i<arrBoolean.length;i++){
            System.out.println(" "+arrBoolean[i]+" ");
        }
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
        }
    }
    /*Módulo que permite verificar si dos arreglos bidimensionales de ints son iguales*/
    public static boolean arrBidIntIguales (int[][] arrInt1, int[][] arrInt2){
        int i=0,j;
        boolean esIgual = (arrInt1.length==arrInt2.length && arrInt2[0].length==arrInt2[0].length);
        while (esIgual && i<arrInt1.length){
            j=0;
            while (esIgual && j<arrInt1[0].length){
                if (arrInt1[i][j] == arrInt2[i][j]){
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