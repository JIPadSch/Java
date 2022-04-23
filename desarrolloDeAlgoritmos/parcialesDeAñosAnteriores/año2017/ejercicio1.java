package desarrolloDeAlgoritmos.parcialesDeAñosAnteriores.año2017;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio1 {
    /*
    *  Implementar en Java un programa que permita ingresar un arreglo de N cadenas de caracteres,
    *  (donde cada una contiene una sola palabra) y obtenga la palabra con mayor cantidad de vocales.
    *  Modularizar convenientemente
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int cant;
        do{
            System.out.println("Ingrese la longitud del arreglo: ");
            cant = scan.nextInt();
            if (cant<=0) System.out.println("La longitud no puede ser menor o igual a 0");
        }while(cant<=0);
        String arrStr[] = new String [cant];
        cargarArreglo(arrStr);
        System.out.println("La palabra con más vocales es: "+arrStr[palabraMasVocales(arrStr)]);
    }
    /* Modulo que permite cargar el arreglo de String */
    public static void cargarArreglo(String arrString[]){
        Scanner scan = new Scanner (System.in);
        for (int i = 0; i < arrString.length; i++) {
            System.out.println("Ingrese la palabra de la posicion "+(i+1));
            arrString[i] = scan.nextLine();
        }
    }
    /* Modulo que permite contar la cantidad de vocales */
    public static int palabraMasVocales(String[] arrStr){
        int contador, contadorAux=0, posMasVocales=0;
        for (int i = 0; i < arrStr.length; i++) {
            contador=0;
            for (int j = 0; j < arrStr[i].length(); j++) {
                if (esVocal(arrStr[i].charAt(j))) contador++;
            }
            if (contador>contadorAux){
                posMasVocales=i;
                contadorAux=contador;
            }
        }
        return posMasVocales;
    }
    /* Modulo que verifica si un caracter es vocal o no */
    public static boolean esVocal(char letra){
        boolean vocal=false;
        switch(letra){
            case 'a':
                vocal=true;
                break;
            case 'e':
                vocal=true;
                break;
            case 'i':
                vocal=true;
                break;
            case 'o':
                vocal=true;
                break;
            case 'u':
                vocal=true;
                break;
            default:
                vocal=false;
                break;
        }
        return vocal;
    }
}
