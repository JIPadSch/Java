/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_4;

import java.util.Scanner;
public class buscarPalabMasLarga {
    /*Este algoritmo, según una frase ingresada por el usuario, tendremos
    que buscar cuál es la palabra mas larga en la oración*/
    public static void main(String[] args){
        //Declaración de variables
        String frase, palabMasLarg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese una frase");
        frase = sc.nextLine();
        palabMasLarg = palabraMasLarga(frase);
        System.out.println("La palabra mas larga es: "+palabMasLarg);
        
    }
    /*Este módulo, dada una frase ingresada por el usuario, verificara cuál es la 
    palabra mas larga*/
    public static String palabraMasLarga(String frase){
        //Declaración e Inicialización de variables
        int i=0, j=0, limite = frase.length();
        String nuevaCad, palabMasLarga="";
        boolean esMayor;
        while(i<limite){
            nuevaCad = "";
            if(frase.charAt(0)!=' '){
                nuevaCad = armarPalabra(frase,i);
            } 
            else{
                frase = frase.substring(i);
                nuevaCad = armarPalabra(frase,i);
            }
            esMayor = palabraMasLarga(palabMasLarga,nuevaCad);
            if(esMayor){
                palabMasLarga= palabMasLarga;
            }
            else{
                palabMasLarga= nuevaCad;
            }
            j= nuevaCad.length()+1;
            i= i+j;
        }
        return palabMasLarga;
    }
    /*Este módulo, según la frase ingresada por el usuario, ira separando palabra
    por palabra cada frase hasta llegar al límite de la misma*/
    public static String armarPalabra(String frase, int i){
        //Declaración de variables
        String palabra;
        int longitud;
        //Inicialización de variables
        longitud = frase.length();
        palabra = "";
        while(i<longitud && frase.charAt(i)!=' '){
            palabra=palabra+frase.charAt(i);
            i++;
        }
        return palabra;
    }
    /*Este módulo comparará dos palabras y devolverá booleano si la palabra más larga 
    es más grande en longitud que una palabra también extraída de la frase*/
    public static boolean palabraMasLarga(String palabMasLarg, String palabra){
        return palabMasLarg.length()>palabra.length();
    }
    
}