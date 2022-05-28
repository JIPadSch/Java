package desarrolloDeAlgoritmos.tp4Recursividad;
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
        if((num%10)+1 == (num%100)){ //Caso base 1
            existenDosSeguidos = true;
        } else if ((num%10)==9 && (num%100)==0){ //Caso base 2 (cuando es 9 y sigue 0)
            existenDosSeguidos = true;
        } else{ //Caso general
            existenDosSeguidos = existenDosDigitosSeguidosRecursivo(num/10);
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
        /* SOLO SE ENTRA UNA VEZ QUE NOS PASAMOS DE COL, Y MIENBTRAS NO NOS PASAMOS DE FILAS */
        } else if (fil<matriz.length){
            if (fil==col){ //Primero verificamos si estamos en la diagonal
                if(matriz[fil][col] == 1){ //Verificamos que sea 1
                    esIdentidad = esIdentidadRecursivo(matriz, (fil+1), 0); 
                }   else{
                    esIdentidad = false; //Si no es 1, cortamos la recursividad
                }
            } else if (matriz[fil][col] == 0){ //Si no estamos en la diagonal, verificamos que sea 0
                esIdentidad = esIdentidadRecursivo(matriz, (fil+1), 0);
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
                palabraEnJeringoza = jeringozaRecursivo(palabra, (pos+1), vocales)+'p'+palabra.charAt(pos);
            } else{ //Como no es vocal, solo agregamos la letra en pos y llamo recursivamente
                palabraEnJeringoza = jeringozaRecursivo(palabra, (pos+1), vocales)+palabra.charAt(pos); 
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
    public static char[][] piramideCharRecursivo(int num, char caracter, int numAux){
        char[][] piramide = new char[num][num];
        if(){
            
        } else{

        }
        return piramide;
    }
    /* FIN EJERCICIOS OBLIGATORIOS */

    /* EJERCICO EXTRA */
    /* 
    *  5) Complicado para aquellos que quieran más puntaje:
    *  a) Dado un arreglo de enteros retorne la cantidad de elementos mayores al
    *  promedio
    */
    public static int cantElemMayorPromRecrusivo (int[] arrInt, int pos, int prom){
        int cantMayoresPromedio = 0;
        if (){

        } else{

        }
        return cantMayoresPromedio;
    }
}