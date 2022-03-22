/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package juanipadsch.tprepaso;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio8 {
    public static void main(String[] args){
        /*Según una cadena ingresada por el usuario, mostrara por pantalla el mensaje.
        Aunque si este contiene vocales, estas serán encriptadas*/
        String mensaje="", nuevaCad;
        System.out.println("Por favor ingrese un mensaje. Aclaración: si usted ingresa vocale en dicha cadena, estas serán encriptadas");
        TecladoIn.readLine(mensaje);
        if (mensaje.length()>1){
            nuevaCad=encriptarMensaje(mensaje);
        } else {
            System.out.println("Error. Tenía que ingresar un mensaje");
        }
        
    }
    /*Este módulo, según un mensaje ingresado por el usuario, generara y retornara dicha cadena encriptada*/
    public static String encriptarMensaje(String cadena){
        String nuevaCad="", mensajeMinus=cadena.toLowerCase();
        int i, cantCaract=cadena.length()-1;
        char letra;
        for (i=0;i<=cantCaract;i++){
            /*El mensaje se pasa a minúscula para comparar las vocales, pero en minúscula. Esto nos sirve para el caso de que haya una vocal en mayúscula*/
            letra=mensajeMinus.charAt(i);
            if (esVocal(letra)){
                nuevaCad=nuevaCad+encriptarLetra(letra);
            } else{
                nuevaCad=nuevaCad+cadena.charAt(i);
            }
        }
        return nuevaCad;
    }
    /*Este módulo, según la letra de una cadena, encriptara dicho caractér*/
    public static char encriptarLetra(char letra){
        char letraEncrip=' ';
        switch (letra){
            case 'a': letraEncrip='*';
            break;
            case 'e': letraEncrip='/';
            break;
            case 'i': letraEncrip='+';
            break;
            case 'o': letraEncrip='-';
            break;
            case 'u': letraEncrip='#';
            break;
            default: 
                break;
        }
        return letraEncrip;
    }
    /*Este módulo, según una letra, verificara si es vocal o no*/
    public static boolean esVocal(char letra){
        boolean vocal;
        vocal = (letra=='a')||(letra=='e')||(letra=='i')||(letra=='o')||(letra=='u');
        return vocal;
    }
    
}
