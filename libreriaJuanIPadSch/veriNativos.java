package libreriaJuanIPadSch;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class veriNativos {
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
    /*Módulo que verifica que un String tiene solo letras*/
    public static boolean stringSoloLetras (String str){
        boolean tieneSoloLetras=true;
        int i=0;
        while (tieneSoloLetras && i<str.length()){
            if (veriNativos.charEsLetra(str.charAt(i))){
                i++;
            } else{
                tieneSoloLetras=false;
            }
        }
        return tieneSoloLetras;
    }
}