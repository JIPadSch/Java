package libreriaJuanIPadSch;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author JuanPadSch
 */
public class Entrada {
    private static final Scanner scan = new Scanner(System.in);
    /*
     * @parameters
     * @return String
     */
    public static String leerLinea(){
        String lineaLeida = null;
        do{
            try{
                lineaLeida = scan.nextLine();
            }catch(Exception e){
                System.err.println("Error inesperado");
            }
        }while(lineaLeida == null);
        scan.close();
        return lineaLeida;
    }
    /*
     * @parameters 
     * @return int
     */
    public static int leerEntero(){
        Integer enteroLeido = null;
        do{
            try{
            enteroLeido = scan.nextInt();
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un número o se fue del rango posible en Java");
                System.err.println("Ingrese nuevamente el valor deseado");
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
        Character caracter = null; //Caracter nulo
        do{
            try{
                caracter = scan.nextLine().charAt(0);
            }catch(InputMismatchException ime){
                System.err.println("Eso no es un caracter");
                System.err.println("Ingrese nuevamente el caracter deseado");
            }
        } while(caracter == null);
        scan.close();
        return caracter;
    }
    /* 
     * 
     * 
     */
    public static boolean leerLogico(){
        Boolean logico = null;
        do{
            try{

            }catch(IndexOutOfBoundsException ime){
                System.err.println("Eso no es una variable lógica");
                System.err.println("Ingrese nuevamente la variable logica deseada");
            }
        }while(logico == null);
        scan.close();
        return logico;
    }
    /*
     * @parameters char caracterIngresado
     * @return boolean esVocal
     */
    public static boolean esVocal(char caracterIngresado){
        String vocales = "aeiouAEIOU";
        return (vocales.indexOf(caracterIngresado) > -1);
    }
    /*Módulo que verifica si un caractér es letra*/
    public static boolean caracterEsLetra(char caracter){
        boolean esLetra=false;
        /*Hacemos una verificación de ASCII. De la A hasta la Z,
        los valores númericos van del 65 al 122 (incluidos)*/
        if (caracter>=65 && caracter<=122){
            esLetra=true;                
        }
        return esLetra;
    }
    /*Módulo que verifica que un String tiene solo letras*/
    public static boolean lineaSoloLetras (String str){
        boolean tieneSoloLetras=true;
        int i=0;
        while (tieneSoloLetras && i<str.length()){
            if (Entrada.caracterEsLetra(str.charAt(i))){
                i++;
            } else{
                tieneSoloLetras=false;
            }
        }
        return tieneSoloLetras;
    }
}
