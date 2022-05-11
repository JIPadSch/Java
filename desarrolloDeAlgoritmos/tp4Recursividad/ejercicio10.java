package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio10 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que lea una secuencia de caracteres hasta que
    *  se ingrese el punto y retorne una frase formada por los caracteres en el orden leído.
    */
    public static void main(String[] args) {
        System.out.println("Usted formó el String: "+caracteresAString());
    }
    /* Modulo recursivo */
    public static String caracteresAString(){
        Scanner scan = new Scanner(System.in);
        String strDeCarac="";
        char caracter;
        caracter = scan.next().charAt(0);
        if(caracter!='.'){ //Caso general
            strDeCarac=+caracter+caracteresAString();
        } else{ //Caso base
            strDeCarac="";
        }
        return strDeCarac;
    }
}