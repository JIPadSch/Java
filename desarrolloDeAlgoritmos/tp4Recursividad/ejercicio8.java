package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio8 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que retorne true si una oración es un palíndromo.
    *  Un palíndromo es una oración capicúa (no se contabiliza las mayúsculas y minúsculas ni los
    *  espacios en blanco):
    *  Ejemplos de palíndromos: “NEUQUEN”; “Somos o no somos”; “Yo hago yoga hoy” “Anita lava la
    *  tina”; “Sé verlas al revés”.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        boolean palinn=false;
        System.out.println("Ingrese una cadena de caracteres: ");
        str = scan.nextLine();
        System.out.println("La cadena de caracteres "+str+" ¿Es palindromo?: "+esPalindromoRecursivo((str.replaceAll(" ","")).toLowerCase(),0));
    }
    /* Metodo recursivo */
    public static boolean esPalindromoRecursivo(String str,int aux){
        int mitad=str.length()/2;
        boolean esPali=true;
        if(str.charAt(aux) == str.charAt(str.length()-1-aux)){ //Comparamos si es Palindromo
            if(aux==mitad){ //Caso base
                esPali=true;
            }else{ //Caso general
                esPali=esPalindromoRecursivo(str, aux+1);
            }
        }else{ //En caso de no ser Palindromo, cortamos
            esPali=false;               
        }
        return esPali;
    }
}
