package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio12 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que dado un arreglo de caracteres y un caracter
    *  indique si se encuentra el caracter en el arreglo.
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        char arrChar[] = new char [4];
        System.out.println("Llenará un arreglo de caracteres de longitud 4: ");
        libreriaJuanIPadSch.arreglosUni.llenarArrChar(arrChar);
        char caracterEncontrar;
        System.out.println("Ingrese el caracter que desea buscar en el arreglo: ");
        caracterEncontrar = scan.next().charAt(0);
        System.out.println("El caracter "+caracterEncontrar+" ¿se encuentra en el arreglo? "+caracterExisteRecursivo(arrChar, 0, caracterEncontrar));
        scan.close();
    }
    /* Metodo recursivo */
    public static boolean caracterExisteRecursivo(char[] arrChar, int pos, char caracterEncontrar){
        boolean caracterExiste=false;
        if (pos<arrChar.length){ //Caso general
            if (caracterEncontrar != arrChar[pos]){ //Si no existe llamamos nuevamente al metodo
                caracterExisteRecursivo(arrChar, pos+1, caracterEncontrar);
            } else{ //Si existe, cortamos
                caracterExiste = true;
            }
        } else{ //Caso base (se recorrio todo el arreglo y no se encontro)
            caracterExiste=false;
        }
        return caracterExiste;
    }
}
