package desarrolloDeAlgoritmos.simulacrosDeParciales.año2022;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejerciciosString {
    /* 
    *  a. Determine la cantidad de las palabras con más de 3 vocales diferentes.
    *     Realice una traza para: “ Modularizar no es problematico.”, (debe retornar 2)
    *  b. Determine todos las palabras que tienen al menos una letra igual pegada.
    *     Realice una traza para el siguiente texto: “corriendo bajo la lluvia “ (debe retornar 2)
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Ingrese un String para ver cuantas palabras tienen más de 3 vocales distintas: ");
        String unStr = scan.nextLine();
        System.out.println("Hay "+stringConMas3VocalesDistintas(unStr)+" palabras con almenos 3 vocales distintas");
        scan.nextLine(); //Limpiamos el Scanner
        System.out.println("Igrese un String para ver cuantas palabras tiene almenos 2 letras pegadas: ");
        unStr = scan.nextLine();
        System.out.println("Hay "+stringDosLetrasPegadas(unStr)+" palabras con almenos 2 letras pegadas");
        scan.close();
        System.out.println("Adiós!");
    }
    /* 
    *  Módulo que determina si dado un String,
    *  las palabrás en el mismo tienen más de 3 vocales diferentes 
    */
    public static int stringConMas3VocalesDistintas(String unStr){
        String strAux = unStr.toLowerCase(), subStrAux="";
        int posGuardada=0, cantPalConMas3Vocales=0;
        boolean tieneMas3VocalesDistintas;
        for (int i = 0; i < strAux.length(); i++) {
            if((strAux.charAt(i) == ' ' && (i-1>0)) || (i+1)==strAux.length()){
                subStrAux = strAux.substring(posGuardada, (i-1));
                tieneMas3VocalesDistintas = verificarMas3VocalesDistintas(subStrAux);
                System.out.println("La palabra "+subStrAux+" ¿tiene más de 3 vocales?"+tieneMas3VocalesDistintas);
                posGuardada=(i+1);
                if (tieneMas3VocalesDistintas) cantPalConMas3Vocales++; 
            }
        }
        return cantPalConMas3Vocales;
    }
    /* Modulo que dado una palabra verifica si la misma tiene más de tres vocales */
    public static boolean verificarMas3VocalesDistintas(String subStr){
        boolean tieneMas3VocalesDistintas=false;
        int cantVocalesDist=0;
        String vocales = "aeiou", vocalesDistintas="";
        int i=0;
        while(!tieneMas3VocalesDistintas && i<subStr.length()){
            if(cantVocalesDist<3){
                tieneMas3VocalesDistintas=true;
            }else if(vocalesDistintas.indexOf(subStr.charAt(i)) == -1 && vocales.indexOf(subStr.charAt(i)) > -1){
                //Primero verificamos que el caracter en la posicion i no haya sido ya encontrado
                //Luego verificamos que el caracter en la posicion i sea una vocal
                cantVocalesDist++;
                vocalesDistintas+=subStr.charAt(i);
            }
            i++;
        }
        return tieneMas3VocalesDistintas;
    }
    /* Modulo que verifica, dado un String, si cada palabra tiene almenos una letra igual pegada */
    public static int stringDosLetrasPegadas(String unStr){
        int cantPal2LetrasPegadas=0, posGuardada=0;
        String strAux = unStr.toLowerCase(), subStrAux="";
        boolean cumpleCondicion=false;
        for (int i = 0; i < unStr.length(); i++) {
            if (strAux.charAt(i) == ' ' || (i+1)==unStr.length()){
                subStrAux=unStr.substring(posGuardada, (i-1));
                cumpleCondicion = verificar2PalabrasIgualesPegadas(subStrAux);
                if (cumpleCondicion) cantPal2LetrasPegadas++;
                posGuardada=i+1;
            }
        }
        return cantPal2LetrasPegadas;
    }
    /* Modulo que dado una palabra, verifica si en ella existen almenos 2 palabras iguales pegadas */
    public static boolean verificar2PalabrasIgualesPegadas(String palabra){
        boolean tiene2PalabrasIgualesPegadas=false;
        int i=0;
        while(!tiene2PalabrasIgualesPegadas && i<palabra.length()){
            if((i-1>=0) && (palabra.charAt(i)==palabra.charAt(i-1))){
                tiene2PalabrasIgualesPegadas=true;
            }
            i++;
        }
        return tiene2PalabrasIgualesPegadas;
    }
}