package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
private class ejercicio9 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que dados dos números (divisor y dividendo)
    *  realice la división por restas sucesivas.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int dividendo, divisor;
        do{
            System.out.println("Ingrese el dividendo: ");
            dividendo = scan.nextInt();
            if(dividendo<=0) System.out.println("ERROR: El dividendo no puede ser menor o igual a 0");
            scan.nextLine();
        }while(dividendo<=0);
        do{
            System.out.println("Ingrese el divisor: ");
            divisor = scan.nextInt();
            if(divisor<=0) System.out.println("ERROR: El divisor no puede ser menor o igual a 0");
            scan.nextLine();
        }while(divisor<=0);
        System.out.println("El numero "+divisor+" dividió a "+dividendo+": "+restaSucesiva(dividendo, divisor)+" veces");
    }
    /* Modulo recursivo */
    public static int restaSucesiva (int dividendo, int divisor){
        int contador=0;
        if(dividendo>divisor){ //Caso general
            contador+=restaSucesiva(dividendo-divisor, divisor)+1;
        }else{ //Caso base: Dividendo menor a divisor
            contador=0;
        }
        return contador;
    }
}
