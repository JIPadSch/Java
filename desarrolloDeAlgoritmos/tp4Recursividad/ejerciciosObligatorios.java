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
            scan.nextLine(); //Limpiamos el Scanner
        }while (opcion!=6);
        scan.close();
    } 
    /* MENU */
    public static void menu(int opcion){
        Scanner scan = new Scanner (System.in);
        int numero;
        switch (key) {
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
                //promedio[0] almacena cantidad mayor al promedio, promedio[1] almacena el promedio de los numeros
                libreriaJuanIPadSch.arreglosUni.llenarArrIntAutoS(arrInt);
                System.out.println("Trabajaremos con el siguiente arreglo cargado automáticamente");
                libreriaJuanIPadSch.arreglosUni.imprimirArrInt(arrInt);
<<<<<<< HEAD
<<<<<<< HEAD
                System.out.println("Cantidad de elementos mayores al promedio: "+cantElemMayorPromRecrusivo(arrInt, 0, 0));
=======
                int promedio = 0;
                for (int i = 0; i < arrInt.length; i++) {
                    promedio += arrInt[i]; 
                }
                System.out.println("Cantidad de elementos mayores al promedio: "+cantElemMayorPromRecrusivo(arrInt, 0, promedio));
>>>>>>> 5c02dc527b0809202bdb83851b31100cb25d52c6
=======
                System.out.println("Cantidad de elementos mayores al promedio: "+cantElemMayorPromRecrusivo(arrInt, 0, promedio)+"\nPromedio: "+promedio[1]);
>>>>>>> 7f7a9d1250e83b89bb5cb12a5b73d7677d530ad6
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
            if((num%10)+1 == (num/10)%10){ //Caso base 1
                existenDosSeguidos = true;
            } else if ((num%10)==9 && (num%100)==0){ //Caso base 2 (cuando es 9 y sigue 0)
                existenDosSeguidos = true;
            } else{ //Caso general
                existenDosSeguidos = existenDosDigitosSeguidosRecursivo(num/10);
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 7f7a9d1250e83b89bb5cb12a5b73d7677d530ad6
        /* SOLO SE ENTRA UNA VEZ QUE NOS PASAMOS DE COL, Y MIENTRAS NO NOS PASAMOS DE FILAS */
        } else if ((fil+1)<matriz.length){
            col=0;
            fil+=1;
            if (matriz[fil][col] == 0){ //Verificamos que sea 0 en la siguiente fila
                esIdentidad = esIdentidadRecursivo(matriz, fil, col);
<<<<<<< HEAD
=======
        /* SOLO SE ENTRA UNA VEZ QUE NOS PASAMOS DE COL, Y MIENBTRAS NO NOS PASAMOS DE FILAS */
        } else if (fil<matriz.length){
            col=0;
            if (fil==col){ //Primero verificamos si estamos en la diagonal
                if(matriz[fil][col] == 1){ //Verificamos que sea 1
                    esIdentidad = esIdentidadRecursivo(matriz, (fil+1), col); 
                }   else{
                    esIdentidad = false; //Si no es 1, cortamos la recursividad
                }
            } else if (matriz[fil][col] == 0){ //Si no estamos en la diagonal, verificamos que sea 0
                esIdentidad = esIdentidadRecursivo(matriz, (fil+1), col);
>>>>>>> 5c02dc527b0809202bdb83851b31100cb25d52c6
=======
>>>>>>> 7f7a9d1250e83b89bb5cb12a5b73d7677d530ad6
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
<<<<<<< HEAD
<<<<<<< HEAD
                palabraEnJeringoza = palabra.charAt(pos) + "p" + palabra.charAt(pos) + jeringozaRecursivo(palabra, (pos+1), vocales);
            } else{ //Como no es vocal, solo agregamos la letra en pos y llamo recursivamente
                palabraEnJeringoza = palabra.charAt(pos) + jeringozaRecursivo(palabra, (pos+1), vocales); 
=======
                palabraEnJeringoza = 'p'+palabra.charAt(pos)+jeringozaRecursivo(palabra, (pos+1), vocales);
            } else{ //Como no es vocal, solo agregamos la letra en pos y llamo recursivamente
                palabraEnJeringoza = palabra.charAt(pos)+jeringozaRecursivo(palabra, (pos+1), vocales); 
>>>>>>> 5c02dc527b0809202bdb83851b31100cb25d52c6
=======
                palabraEnJeringoza = palabra.charAt(pos) + "p" + palabra.charAt(pos) + jeringozaRecursivo(palabra, (pos+1), vocales);
            } else{ //Como no es vocal, solo agregamos la letra en pos y llamo recursivamente
                palabraEnJeringoza = palabra.charAt(pos) + jeringozaRecursivo(palabra, (pos+1), vocales); 
>>>>>>> 7f7a9d1250e83b89bb5cb12a5b73d7677d530ad6
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
<<<<<<< HEAD
<<<<<<< HEAD
            piramideCharRecursivo(num, caracter, fil, col-1);
=======
            mostrarPiramide(caracter, num, fil, col = col-1);
>>>>>>> 5c02dc527b0809202bdb83851b31100cb25d52c6
=======
            piramideCharRecursivo(num, caracter, fil, col-1);
>>>>>>> 7f7a9d1250e83b89bb5cb12a5b73d7677d530ad6
        }
    }
    /* FIN EJERCICIOS OBLIGATORIOS */

    /* EJERCICO EXTRA */
    /* 
    *  5) Complicado para aquellos que quieran más puntaje:
    *  a) Dado un arreglo de enteros retorne la cantidad de elementos mayores al
    *  promedio
    */
    public static int cantElemMayorPromRecrusivo (int[] arrInt, int pos, int[] prom){
        if(pos<arrInt.length){
            prom[0] += cantElemMayorPromRecrusivo(arrInt, (pos+1),(prom[1]+arrInt[pos]));
            if (arrInt[pos]>prom[1]) { //Si el elemento en pos es mayor al promedio, sumamos 1
                prom[0]+=1;
            }
        }else{ //Entramos cuando llegamos al final del arreglo
            prom[1] = prom[1] / arrInt.length; //Calculamos el promedio
            if (arrInt[pos-1]>prom[1]) { //Si el ultimo elemento de mayor al promedio, sumamos 1
                prom[0]+=1;
            }
        }
        return prom[0]; //Devolvemos la cantidad de mayores al promedio
    }
}