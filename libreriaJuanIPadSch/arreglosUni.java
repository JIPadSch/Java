
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class arreglosUni {
    /* Módulo que permite llenar un arreglo de ints */
    public static void llenarArrInt(int[] arrInt) {
        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < arrInt.length; i++) {
            System.out.println("Llenar posición " + i + " : ");
            arrInt[i] = scan.nextInt();
            scan.nextLine();
        }
    }
    /* Módulo que llena automáticamente un arreglo de ints */
    public static void llenarArrIntAutoS(int[] arrInt){
        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i]=intAleatorio.S();
        }
    }
    /* Módulo que muestra por pantalla un arreglo de ints */
    public static void imprimirArrInt(int[] arrInt) {
        int i;
        for (i = 0; i < arrInt.length; i++) {
            System.out.println(" " + arrInt[i] + " ");
        }
    }
    /* Módulo que devuelve el elemento mayor de un arreglo de ints */
    public static int numMayorArrInt(int[] arrInt) {
        int i, numMayor = arrInt[0];
        for (i = 0; i < arrInt.length; i++) {
            if (arrInt[i] > numMayor) {
                numMayor = arrInt[i];
            }
        }
        return numMayor;
    }
    /* Módulo que devuelve el elemento menor de un arreglo de ints */
    public static int numMenorArrInt(int[] arrInt) {
        int i, numMenor = arrInt[0];
        for (i = 0; i < arrInt.length; i++) {
            if (arrInt[i] < numMenor) {
                numMenor = arrInt[i];
            }
        }
        return numMenor;
    }
    /*
     * Módulo que devuelve el número mayor y el menor de un arreglo (int) dentro
     * de un nuevo arreglo (int), donde el mayor se ubica en el espacio [0]
     * y el menor se ubica en el espacio [1]
     */
    public static int[] numMayorMenorArrInt(int[] arrInt) {
        int i;
        int[] numMayorMenor = new int[2];
        numMayorMenor[0] = arrInt[0]; // numMayor
        numMayorMenor[1] = arrInt[0]; // numMenor
        for (i = 0; i < arrInt.length; i++) {
            if (arrInt[i] > numMayorMenor[0]) {
                numMayorMenor[0] = arrInt[i];
            } else if (arrInt[i] < numMayorMenor[1]) {
                numMayorMenor[1] = arrInt[i];
            }
        }
        return numMayorMenor;
    }
    /* Módulo que permite llenar un arreglo de chars */
    public static void llenarArrChar(char[] arrChar) {
        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < arrChar.length; i++) {
            System.out.println("Llenar posición " + i + " : ");
            arrChar[i] = scan.next().charAt(0);
            scan.nextLine();
        }
    }
    /* Módulo que muestra por pantalla un arreglo de chars */
    public static void imprimirArrChar(char[] arrChar) {
        int i;
        for (i = 0; i < arrChar.length; i++) {
            System.out.println(" " + arrChar[i] + " ");
        }
    }
    /* Módulo que permite llenar un arreglo de Strings */
    public static void llenarArrString(String[] arrString) {
        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < arrString.length; i++) {
            System.out.println("Llenar posición " + i + " : ");
            arrString[i] = scan.nextLine();
            scan.nextLine();
        }
    }
    /* Módulo que muestra por pantalla un arreglo de Strings */
    public static void imprimirArrString(String[] arrString) {
        int i;
        for (i = 0; i < arrString.length; i++) {
            System.out.println(" " + arrString[i] + " ");
        }
    }
    /* Módulo que verifica si un arreglo de String tiene solo letras */
    public static boolean arrStringSoloLetras(String[] arrString) {
        boolean tieneSoloLetras = true;
        int i = 0;
        while (tieneSoloLetras && i < arrString[i].length()) {
            tieneSoloLetras = veriNativos.stringSoloLetras(arrString[i]);
            i++;
        }
        return tieneSoloLetras;
    }
    /* Módulo que permite llenar un arreglo de doubles */
    public static void llenarArrDouble(double[] arrDouble) {
        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < arrDouble.length; i++) {
            System.out.println("Llenar posición " + i + " : ");
            arrDouble[i] = scan.nextDouble();
            scan.nextLine();
        }
    }
    /* Módulo que muestra por pantalla un arreglo de doubles */
    public static void imprimirArrDouble(double[] arrDouble) {
        int i;
        for (i = 0; i < arrDouble.length; i++) {
            System.out.println(" " + arrDouble[i] + " ");
        }
    }
    /* Módulo que devuelve el número mayor de un arreglo de doubles */
    public static double numMayorArrDouble(double[] arrDouble) {
        double numMayor = arrDouble[0];
        int i;
        for (i = 0; i < arrDouble.length; i++) {
            if (arrDouble[i] > numMayor) {
                numMayor = arrDouble[i];
            }
        }
        return numMayor;
    }
    /* Módulo que devuelve el número menor de un arreglo de doubles */
    public static double numMenorArrDouble(double[] arrDouble) {
        double numMenor = arrDouble[0];
        int i;
        for (i = 0; i < arrDouble.length; i++) {
            if (arrDouble[i] < numMenor) {
                numMenor = arrDouble[i];
            }
        }
        return numMenor;
    }
    /*
     * Módulo que devuelve el número mayor y el menor de un arreglo (double) dentro
     * de un nuevo arreglo (double), donde el mayor se ubica en el espacio [0]
     * y el menor se ubica en el espacio [1]
     */
    public static double[] numMayorMenorArrDouble(double[] arrDouble) {
        double[] numMayorMenor = new double[2];
        numMayorMenor[0] = arrDouble[0]; // numMayor
        numMayorMenor[1] = arrDouble[0]; // numMenor
        int i;
        for (i = 0; i < arrDouble.length; i++) {
            if (numMayorMenor[0] > arrDouble[i]) {
                numMayorMenor[0] = arrDouble[i];
            } else if (numMayorMenor[1] < arrDouble[i]) {
                numMayorMenor[1] = arrDouble[i];
            }
        }
        return numMayorMenor;
    }
    /* Módulo que permite llenar un arreglo de booleans */
    public static void llenarArrBoolean(boolean[] arrBoolean) {
        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < arrBoolean.length; i++) {
            System.out.println("Llenar posición " + i + " : ");
            arrBoolean[i] = scan.nextBoolean();
            scan.nextLine();
        }
    }
    /* Módulo que muestra por pantalla un arreglo de booleans */
    public static void imprimirArrBoolean(boolean[] arrBoolean) {
        int i;
        for (i = 0; i < arrBoolean.length; i++) {
            System.out.println(" " + arrBoolean[i] + " ");
        }
    }
}
