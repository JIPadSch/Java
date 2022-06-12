package desarrolloDeAlgoritmos.tp6MetodosOrdenamiento;
import java.util.*;
public class ejercicioClase {
    public static void main (String[] args){
        /* Algoritmo principal */
        Scanner scan = new Scanner (System.in);
        int[] arrInt = new int[verificarLongitud()];
        System.out.println("RECUERDE QUE EL ARREGLO DEBE ESTAR ORDENADO");
        llenarArrInt(arrInt);
        int num;
        System.out.println("Ingrese un número que desee buscar: ");
        num = scan.nextInt();
        int posicion = busquedaBinariaRecursivo(arrInt, 0, arrInt.length, num);
        if (posicion > -1){
            System.out.println("La posicion es: "+(posicion+1));
        } else{
            System.out.println("Ese número no existe en el arreglo");
        }
        scan.close();
    }
    /* Modulo que permite verificar una longitud valida */
    public static int verificarLongitud(){
        Scanner scan = new Scanner (System.in);
        int longitud = 0;
        while(longitud <= 0){
            System.out.println("Ingrese la longitud de su arreglo: ");
            longitud = scan.nextInt();
            if (longitud <= 0) System.out.println("ERROR: La longitud no puede ser menor o igual a 0");
        }
        return longitud;
    }
    /* Modulo que permite cargar el arreglo */
    public static void llenarArrInt(int[] arrInt) {
        Scanner scan = new Scanner(System.in);
        int i;
        for (i = 0; i < arrInt.length; i++) {
            System.out.println("Llenar posición " + (i+1) + " : ");
            arrInt[i] = scan.nextInt();
            scan.nextLine();
        }
    }
    /* Modulo que realiza busqueda binaria de manera recursiva */
    public static int busquedaBinariaRecursivo(int[] arrInt, int ini, int fin, int num){
        int existe = -1, medio = (ini+fin)/2;
        if(ini < fin){
            if(num < arrInt[medio]){
                existe = busquedaBinariaRecursivo(arrInt, ini, (medio-1), num);
            } else{
                if(num == arrInt[medio]){
                    existe = medio;
                }else{
                    existe = busquedaBinariaRecursivo(arrInt, (medio+1), fin, num);
                }
            }
        }
        return existe;
    }
}