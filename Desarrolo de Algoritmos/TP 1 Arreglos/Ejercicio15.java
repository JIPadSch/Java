import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio15 {
    /*El programa solicita un número de 8 cifras y devuelve el número
    de DNI correspondiente (el DNI consta de 8 cifras y una letra)*/
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean esNumero=false;
        int numDni=0;
        char letDni;
        while (esNumero==false){
            System.out.println("Ingrese un DNI (numero positivo de 8 cifras): ");
            numDni=scan.nextInt();
            scan.nextLine();
            if(numDni>=10000000 && numDni<=99999999){
                esNumero=true;
            } else{
                System.out.println("Ese no es un numero de DNI valido");
            }
        }
        letDni=letraDni((restoDni(numDni)));
        System.out.println("El DNI completo es: "+numDni+letDni);
    }
    /*El módulo calcula el resto de dividir el número de DNI en 23*/
    public static int restoDni(int dni){
        int resto;
        resto=(dni%23);
        return resto;
    }
    /*El módulo devuelve una letra, la misma varía según el resto obtenido
    en el módulo "restoDni" (los números pueden variar del 0 al 22, incluidos)*/
    public static char letraDni(int resto){
        char letraDni;
        char[] tablaLetraDni = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        letraDni=tablaLetraDni[resto];
        return letraDni;
    }
}