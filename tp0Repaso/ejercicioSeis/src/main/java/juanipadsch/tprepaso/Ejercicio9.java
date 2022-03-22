/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanipadsch.tprepaso;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio9 {
    /*Este algoritmo, según una contraseña ingresada por el ususario, verificara
    si cumple ciertos requerimientos para que dicha contraseña sea segura*/
    public static void main(String[] args){
        String contrasenia="";
        boolean contOchoCarac, contLetra, contNumero, contSimbolo;
        System.out.println("Por favor ingrese la contraseña de su sistema. Aclaración: Debe contener, almenos ocho caracteres, una letra, un número y un símbolo");
        System.out.println("Ingresada la contraseña verificaremos el nivel de seguridad de la misma");
        TecladoIn.readLine(contrasenia);
        contOchoCarac=contieneOchoCarac(contrasenia);
        contLetra=contieneLetra(contrasenia);
        contNumero=contieneNumero(contrasenia);
        contSimbolo=contieneSimbolo(contrasenia);
        if (contOchoCarac && contLetra && contNumero && contSimbolo){
            System.out.println("Cumple con todos los requisitos para que la contraseña sea segura");
        } else {
            System.out.println("No cumple con los requisitos exigidos para que su contraseña sea segura");
        }
    }
    /*Este módulo, a partir de una contraseña ingresada por el usuario, verificara si contiene almenos ocho caracteres*/
    public static boolean contieneOchoCarac(String contrasenia){
        boolean longitudCorrecta=false;
        if (contrasenia.length()>=8){
            longitudCorrecta=true;
        }
        return longitudCorrecta;
    }
    /*Este módulo, a partir de una contraseña ingresada por el usuario, verificara si contiene almenos una letra*/
    public static boolean contieneLetra(String contrasenia){
        int i=0, longitudContras=contrasenia.length(), posAscii;
        String cadenaMinus=contrasenia.toLowerCase();
        boolean contLetra=false;
        char caracter;
        while (!contLetra && i<longitudContras){
            caracter=cadenaMinus.charAt(i);
            posAscii=caracter;
            if (posAscii>96 && posAscii<123){
                contLetra=true;
            } else{
                i++;
            }
        }
        return contLetra;
    }
    /*Este módulo, a partir de una contraseña ingresada por el usuario, verificara si contiene al menos un número*/
    public static boolean contieneNumero(String contrasenia){
        int i=0, longitudContras=contrasenia.length(), posAscii;
        String cadenaMinus=contrasenia.toLowerCase();
        boolean contNum=false;
        char caracter;
        while (!contNum && i<longitudContras){
            caracter=cadenaMinus.charAt(i);
            posAscii=caracter;
            if (posAscii>47 && posAscii<57){
                contNum=true;
            } else{
                i++;
            }
        }
        return contNum;
    }
    /*Este módulo, a partir de una contraseña ingresada por el usuario, verificara si contiene al menos un número*/
    public static boolean contieneSimbolo(String contrasenia){
        int i=0, longitudContras=contrasenia.length(), posAscii;
        String cadenaMinus=contrasenia.toLowerCase();
        boolean contSimb=false;
        char caracter;
        while (!contSimb && i<longitudContras){
            caracter=cadenaMinus.charAt(i);
            posAscii=caracter;
            if (posAscii>47 && posAscii<57){
                contSimb=true;
            } else{
                i++;
            }
        }
        return contSimb;
    }
}
