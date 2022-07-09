package libreriaJuanIPadSch;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class Entrada {
    /* Scanner que utilizaremos en toda la clase */
    private static final Scanner scan = new Scanner(System.in);
    /*
     * @parameters
     * @return String
     */
    public static String leerLinea(){
        String lineaLeida;
        do{
            try{
                lineaLeida = scan.nextLine();
            }catch(Exception e){
                System.err.println("Error inesperado");
                lineaLeida = null;
            }
        }while(lineaLeida == null);
        scan.close();
        return lineaLeida;
    }
    /* 
     * 
     * 
     */
    public static String leerPalabra(){
        String palabraLeida = leerLinea();
        return separarPalabra(palabraLeida);
    }
    /* Modulo para separar la primer palabra */
    private static String separarPalabra(String palabraLeida){
        String palabra = null;
        int i = 0;
        boolean corte = false;
        while(!corte && i < palabraLeida.length()){
            if(palabraLeida.charAt(i) != ' '){
                palabra = ""+palabraLeida.charAt(i);
                i++;
            }else{
                corte = true;
            }
        }
        return palabra;
    }
    /*
     * @parameters 
     * @return int
     */
    public static int leerEntero(){
        Integer enteroLeido;
        do{
            try{
                enteroLeido = scan.nextInt();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un número Entero");
                System.err.println("Ingrese nuevamente el valor deseado");
                enteroLeido = null;
            }catch(Exception e){
                System.err.println("El número se fue del rango de Java");
                System.err.println("Ingrese nuevamente el número");
                enteroLeido = null;
            }
        }while(enteroLeido == null);
        scan.close();
        return enteroLeido;
    }
    /* 
     * 
     * @return
     */
    public static char leerCaracter(){
        Character caracterLeido;
        do{
            try{
                caracterLeido = scan.nextLine().charAt(0);
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un Caracter");
                System.err.println("Ingrese nuevamente el caracter deseado");
                caracterLeido = null;
            }
        } while(caracterLeido == null);
        scan.close();
        return caracterLeido;
    }
    /* 
     * 
     * 
     */
    public static boolean leerLogico(){
        Boolean logico;
        do{
            try{
                logico = scan.nextBoolean();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es una variable Lógica");
                System.err.println("Ingrese nuevamente la variable logica deseada");
                logico = null;
            }
        }while(logico == null);
        scan.close();
        return logico;
    }
    /* 
     * 
     * 
     */
    public static double leerReal(){
        Double real;
        do{
            try{
                real = scan.nextDouble();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un numero Real");
                System.err.println("Ingrese nuevamente el numero");
                real = null;
            }
        }while(real == null);
        scan.close();
        return real;
    }
    /* 
     * 
     * 
     */
    public static float leerPuntoFlotante(){
        Float puntoFlotante;
        do{
            try{
                puntoFlotante = scan.nextFloat();
            }catch(InputMismatchException ime){
                System.err.println("Eso no un numero en Punto Flotante");
                System.err.println("Ingrese nuevamente el numero");
                puntoFlotante = null;
            }
        }while(puntoFlotante == null);
        scan.close();
        return puntoFlotante;
    }
    /* 
     * 
     * 
     */
    public static byte leerByte(){
        Byte unByte;
        do{
            try{
                unByte = scan.nextByte();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un byte");
                System.err.println("Ingrese nuevamente el numero");
                unByte = null;
            }
        }while(unByte == null);
        scan.close();
        return unByte;
    }
    /* 
     * 
     * 
     */
    public static short leerCorto(){
        Short corto;
        do{
            try{
                corto = scan.nextShort();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un numero Corto");
                System.err.println("Ingrese nuevamente el numero");
                corto = null;
            }
        }while(corto == null);
        scan.close();
        return corto;
    }
    /* 
     * 
     * 
     */
    public static long leerLargo(){
        Long largo;
        do{
            try{
                largo = scan.nextLong();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un numero Largo");
                System.err.println("Ingrese nuevamente el numero");
                largo = null;
            }
        }while(largo == null);
        scan.close();
        return largo;
    }
    /*
     * @parameters char caracterIngresado
     * @return boolean esVocal
     */
    public static boolean esVocal(char caracterIngresado){
        String vocales = "aeiouAEIOU";
        return (vocales.indexOf(caracterIngresado) > -1);
    }
    /*Módulo que verifica que un String tiene solo letras*/
    public static boolean lineaSoloLetras (String linea){
        boolean tieneSoloLetras = true;
        int i = 0;
        while (tieneSoloLetras && i < linea.length()){
            if (Entrada.caracterEsLetra(linea.charAt(i))){
                i++;
            } else{
                tieneSoloLetras = false;
            }
        }
        return tieneSoloLetras;
    }
    /*Módulo que verifica si un caractér es letra*/
    public static boolean caracterEsLetra(char caracter){
        boolean esLetra = false;  
        /* 
         * Hacemos una verificación de ASCII. De la A hasta la Z, y de la a hasta la z,
         * los valores númericos van del 65 al 90 y del 97 al 122 (incluidos), respectivamente
         */
        if ((caracter >= 65 && caracter <= 90) || (caracter >= 97 && caracter <= 122)){
            esLetra = true;                
        }
        return esLetra;
    }
}