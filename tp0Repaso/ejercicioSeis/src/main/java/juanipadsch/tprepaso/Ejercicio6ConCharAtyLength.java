/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanipadsch.tprepaso;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio6ConCharAtyLength {
    /*Este algoritmo, según la frase y palabra que haya ingresado el usuario, tendremos
    que contar la/s frecuencias con las que aparece dicha palabra en la oración*/
    public static void main(String[] args){
        String frase="", palabra="";
        int contador;
        System.out.println("Por favor ingrese una frase en la que desee buscar una palabra");
        TecladoIn.readLine(frase);
        System.out.println("Por favor ingrese la palabra que desee buscar en la frase");
        TecladoIn.readLine(palabra);
        contador=palabraEncontrada(frase,palabra);
        if (contador>0){
            System.out.println("La palabra se encontró en la frase "+contador+" vez/veces");
        } else{
            System.out.println("La palabra NO se encontró");
        }
    }
    /*Este módulo, dada una grase y palabra que ingreso el usuario, contara la 
    cantidad de veces que aparece la palabra*/
    public static int palabraEncontrada(String frase, String palabra){
        int contador=0, i=0, j=0, limite=frase.length();
        String nuevaCad;
        while (i<limite){
            nuevaCad="";
            nuevaCad=armarPalabra(frase,i);
            if ((palabra.length()==nuevaCad.length()) && (compararCadenas(nuevaCad,palabra))){
                contador=contador+1;
            }
            j=nuevaCad.length()+1;
            i=i+j;
        }
        return contador;
    }
    /*Este módulo, según la frase ingresada por el usuario, ira separando palabra por palabra cada frase hasta llegar 
    al límite de la misma*/
    public static String armarPalabra(String frase, int i){
        String palabra="";
        int longitud=frase.length();
        while (i<longitud && frase.charAt(i)!=' '){
            palabra=palabra+frase.charAt(i);
            i=i+1;
    }
        return palabra;
    }
    /*Módulo que comparará dos cadenas ingresadas por el usuario sin diferencias entre mayus/minus*/
    public static boolean compararCadenas(String cadena1, String cadena2){
        int i=0;
        boolean iguales=true;
        String enMinus1="", enMinus2="";
        if (cadena1.length()==cadena2.length()){
            enMinus1=cadena1.toLowerCase();
            cadena1=cadena2;
            enMinus2=cadena1.toLowerCase();
            while (iguales==true && i<cadena1.length()){
                if (enMinus1.charAt(i)== enMinus2.charAt(i)){
                    i++;
                } else{
                    iguales=false;
                }
            }
        } else{
            iguales=false;
        }
        return iguales;
    }
    /*Módulo que dada una cadena devolverá su equivalente en minúscula*/
    public static String aMinuscula(String cadena1){
        String nuevaCad="";
        int i, posicionNumericaCarac, limite=cadena1.length()-1;
        for (i=0;i<limite;i++){
            posicionNumericaCarac=cadena1.charAt(i);
            if (cadena1.charAt(i)=='Ñ'){
                nuevaCad=nuevaCad+"ñ";
            } else{
                if (posicionNumericaCarac>64 && posicionNumericaCarac<91){
                    posicionNumericaCarac=posicionNumericaCarac+32;
                    nuevaCad=nuevaCad+posicionNumericaCarac;
                } else{
                    nuevaCad=nuevaCad+cadena1.charAt(i);
                }
            }
        }
        return nuevaCad;
    }
}
