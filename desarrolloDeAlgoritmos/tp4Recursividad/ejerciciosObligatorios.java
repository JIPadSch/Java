package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
import libreriaJuanIPadSch.*;
/**
 *
 * @author JuanPadSch
 */
public class ejerciciosObligatorios {
    /* 
    *  EJERCICIOS OBLIGATORIOS (GRUPO 1):
    *  1)a) - 2)a) - 3)b) - 6)a)
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("                                              MENU                                              ");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("1) Retorna verdadero si dentro del número existen dos dígitos seguido consecutivos");
            System.out.println("2) Retorna si una matriz NxN dada es de identidad");
            System.out.println("3) Retorna un texto en jeringoza agregándole p+ la vocal cada vez que se utilice una vocal");
            System.out.println("4) Dado un número entero y un caracter, genera una piramide");
            System.out.println("5) Dado un arreglo de enteros retorne la cantidad de elementos mayores al promedio");
            System.out.println("6) Salir del programa");
            System.out.println("-----------------------------------------------------------------------------------------------");
            opcion=scan.nextInt();
            menu(opcion);
            scan.nextLine(); //Limpiamos el Scanner
        }while (opcion!=6);
        scan.close();
    } 
    /* MENU */
    public static void menu(int opcion){
        Scanner scan = new Scanner (System.in);
        int numero;
        switch (opcion) {
            case 1:
                System.out.println("Escriba el numero: ");
                numero = scan.nextInt();
                System.out.println("Dentro de su número ¿Existen dos dígitos seguidos?: "+(exitenDosDigitosSeguidosRecursivo(numero)?"SI":"NO"));
                scan.nextLine(); //Limpiamos el Scanner
                break;
            case 2:
                int[][] matrizInt = new int[3][3];
                libreriaJuanIPadSch.arreglosBidi.llenarArrBidIntAleS(matrizInt);
                System.out.println("Trabajaremos con la siguiente matriz cargada automáticamente:");
                libreriaJuanIPadSch.arreglosBidi.imprimirArrBidInt(matrizInt);
                System.out.println("La matriz ¿es identidad?: "+(esIdentidadRecursivo(matrizInt, 0, 0)?"SI":"NO"));
                break;
            case 3:
                String vocales = "aeiou", palabra = "";
                System.out.println("Escriba la palabra que desea poner en jeringoza: ");
                palabra = scan.nextLine();
                System.out.println("Su palabra en jeringoza es: "+jeringozaRecursivo(palabra.toLowerCase(), 0, vocales));
                scan.nextLine(); //Limpiamos el Scanner
                break;
            case 4:
                int num = 0;
                char caracter;
                System.out.println("Escriba un numero: ");
                num = scan.nextInt();
                scan.nextLine(); //Limpiamos el Scanner
                System.out.println("Escriba una caractér: ");
                caracter = scan.next().charAt(0);
                piramideCharRecursivo(num, caracter, 0, 0);
                scan.nextLine(); //Limpiamos el Scanner
                break;
            case 5:
                int[] arrInt = new int[6], promedio = {0,0};
                libreriaJuanIPadSch.arreglosUni.llenarArrIntAutoS(arrInt);
                System.out.println("Trabajaremos con el siguiente arreglo cargado automáticamente");
                libreriaJuanIPadSch.arreglosUni.imprimirArrInt(arrInt);
                System.out.println("Cantidad de elementos mayores al promedio: "+cantElemMayorPromRecrusivo(arrInt, 0, 0));
                break;
            case 6:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("Esa no es una opción válida. Volviendo al menú");
                break;
        }
        scan.close();
    }

    /* INICIO EJERCICIOS OBLIGATORIOS */
    /*
    *  1) Con dígitos enteros:
    *  a) Retornar verdadero si dentro del número existen dos dígitos seguidos
    *  consecutivos: (luego del 9 iría el 0)
    *  Parármetro Retorna
    *  4235 true
    *  4215 false
    *  9044 true
    */
    public static boolean exitenDosDigitosSeguidosRecursivo (int num){
        boolean existenDosSeguidos = false;
        if (num>=10){ //Si no tenemos un solo digito  
            if((num%10) == (num%100)+1){ //Caso base 1
                existenDosSeguidos = true;
            } else if ((num%10)==9 && (num%100)==0){ //Caso base 2 (cuando es 9 y sigue 0)
                existenDosSeguidos = true;
            } else{ //Caso general
                existenDosSeguidos = exitenDosDigitosSeguidosRecursivo(num/10);
            }
        }
        return existenDosSeguidos;
    }
    /* 
    *  2) Con matrices:
    *  a) Retornar si una matriz nxn (o sea, dada una matriz cuadrada) dada es de identidad
    */
    public static boolean esIdentidadRecursivo(int[][] matriz, int fil, int col){
        boolean esIdentidad = false;
        /* SI NO NOS PASAMOS DE COLUMNAS */
        if(col<matriz[0].length){
            if (fil==col){ //Primero verificamos si estamos en la diagonal
                if(matriz[fil][col] == 1){ //Verificamos que sea 1
                    esIdentidad = esIdentidadRecursivo(matriz, fil, (col+1));
                }   else{
                    esIdentidad = false; //Si no es 1, cortamos la recursividad
                }
            } else if (matriz[fil][col] == 0){ //Si no estamos en la diagonal, verificamos que sea 0
                esIdentidad = esIdentidadRecursivo(matriz, fil, (col+1));
            } else{ //Si alguna de las 2 no se cumple, no es identidad y corto
                esIdentidad = false;
            }
        /* SOLO SE ENTRA UNA VEZ QUE NOS PASAMOS DE COL, Y MIENTRAS NO NOS PASAMOS DE FILAS */
        } else if ((fil+1)<matriz.length){
            col=0;
            fil+=1;
            if (matriz[fil][col] == 0){ //Verificamos que sea 0 en la siguiente fila
                esIdentidad = esIdentidadRecursivo(matriz, fil, col);
            } else{ //Si alguna de las 2 no se cumple, no es identidad y corto
                esIdentidad = false;
            }
        }
        return esIdentidad;
    }
    /*
    *  3) Con String
    *  b) Retorne un texto en jeringoza agregándole p+la vocal cada vez que se utilice
    *  una vocal. No se consideran mayúsculas o minúsculas.
    *  Palabra jeringoza
    *  Ejemplo epejepemplopo
    *  Fui fupuipi
    */
    public static String jeringozaRecursivo(String palabra, int pos, String vocales){
        String palabraEnJeringoza="";
        if(pos<palabra.length()){ //Si no nos pasamos de la longitud
            if(vocales.indexOf(palabra.charAt(pos)) > -1){ //Si el charAt(pos) esta dentro de las vocales
                palabraEnJeringoza = palabra.charAt(pos) + "p" + palabra.charAt(pos) + jeringozaRecursivo(palabra, (pos+1), vocales);
            } else{ //Como no es vocal, solo agregamos la letra en pos y llamo recursivamente
                palabraEnJeringoza = palabra.charAt(pos) + jeringozaRecursivo(palabra, (pos+1), vocales); 
            }
        } else{ //Si nos pasamos, cortamos la recursividad
            palabraEnJeringoza="";
        }
        return palabraEnJeringoza;
    }
    /* 
    *  6) Pirámides
    *  Escribir los algoritmos recursivos necesarios para que dado un número entero y
    *  un caracter, genere las siguientes pirámides de caracteres:
    *  Por ejemplo: si n =4 y el caracter es un * (asterisco)
    *  a) Piramide 1
    *  *
    *  * * 
    *  * * * 
    *  * * * *
    */
    public static void piramideCharRecursivo(int num, char caracter, int fil, int col){
        if (col<0) {
            fil = fil+1;
            col = fil;
            System.out.println("");
        }
        if (fil<num) {
            System.out.print(caracter+" ");
            piramideCharRecursivo(num, caracter, fil, col-1);
        }
    }
    /* FIN EJERCICIOS OBLIGATORIOS */

    /* EJERCICO EXTRA */
    /* 
    *  5) Complicado para aquellos que quieran más puntaje:
    *  a) Dado un arreglo de enteros retorne la cantidad de elementos mayores al
    *  promedio
    */
    public static int cantElemMayorPromRecrusivo (int[] arrInt, int pos, int prom){
        int cantidad=0;
        if(pos<arrInt.length){
            cantidad += cantElemMayorPromRecrusivo(arrInt, pos+1,(prom+arrInt[pos]));
            prom = prom / arrInt.length;
            if (arrInt[pos]>prom) {
                cantidad+=1;
            }
        }else{
            prom = prom / arrInt.length;
            if (arrInt[pos-1]>prom) {
                cantidad+=1;
            }
        }
        return cantidad;
    }
}