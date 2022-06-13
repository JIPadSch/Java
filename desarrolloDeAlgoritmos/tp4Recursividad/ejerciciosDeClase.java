package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejerciciosDeClase {
    /* Main para invocar los módulos */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("--------------------------------------------------");
            System.out.println("1. Calcular factorial");            
            System.out.println("2. Calcular Fibonacci");
            System.out.println("3. Contar iteraciones de un número dentro de otro");
            System.out.println("4. Saber si un numero es primo o no");
            System.out.println("5. Suma los numeros pares de una matriz");
            System.out.println("6. Hace traspuesta una matriz");
            System.out.println("7. Suma los digitos de un numero");
            System.out.println("8. Dada una palabra, pone las consonantes primero y dsp la vocales");
            System.out.println("9. Dada una palabra, repite la letra segun la posicion");
            System.out.println("10. Salir del programa");
            System.out.println("--------------------------------------------------");
            opcion=scan.nextInt();
            scan.nextLine();
            menu(opcion);
        }while(opcion!=10);
        scan.close();
    }
    /* Menu */
    public static void menu(int opcion){
        Scanner scan = new Scanner(System.in);
        int n;
        switch(opcion){
            case 1:
                do{
                    System.out.println("Ingrese un número para mostrar su factorial: ");
                    n=scan.nextInt();
                    if (n<1) System.out.println("El número ingresado debe ser mayor o igual a 1");
                    scan.nextLine();
                }while (n<1);
                System.out.println("El factorial de "+n+" es :"+factorial(n));
                break;
            case 2:
                do{
                    System.out.println("Ingrese el número que desea ver en Fibonacci: ");
                    n=scan.nextInt();
                    if (n<1) System.out.println("El número ingresado debe ser mayor o igual a 1");
                    scan.nextLine();
                }while(n<1);
                System.out.println("El Fibonacci de "+n+" es: "+fibonacci(n));        
                break;
            case 3:
                    int chequear;
                    System.out.println("Ingrese el numero a revisar: ");
                    n=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese que numero desea buscar: ");
                    chequear=scan.nextInt();
                    scan.nextLine();
                    System.out.println("El numero "+chequear+" se encuentra "+contarVeces(n,chequear)+" veces en "+n);
                break;
            case 4:
                do{
                    System.out.println("Ingrese un número a verificar si es primo: ");
                    n=scan.nextInt();
                    if (n<=0) System.out.println("El numero no puede ser menor o igual a 0");
                    scan.nextLine();
                } while (n<=0);
                System.out.println("El numero "+n+" ¿Es primo? "+esPrimo(n,n-1));
                break;
            case 5:
                int[][] matriz = new int[4][4];
                libreriaJuanIPadSch.arreglosBidi.cargarAutoMatrizCuadradaInts(matriz);
                System.out.println("Trabajaremos con la siguiente matriz:");
                libreriaJuanIPadSch.arreglosBidi.imprimirArrBidInt(matriz);
                int sumaPares = sumarParesMatriz(matriz, 0, 0);
                System.out.println("La suma de los números pares de la matriz es: "+sumaPares);
                break;
            case 6:
                int[][] matriz2 = new int[4][4];
                libreriaJuanIPadSch.arreglosBidi.cargarAutoMatrizCuadradaInts(matriz2);
                System.out.println("Trabajaremos con la siguiente matriz:");
                libreriaJuanIPadSch.arreglosBidi.imprimirArrBidInt(matriz2);
                matrizTraspuestaRecursivo(matriz2, 0, 0, 0);
                System.out.println("La matriz traspuesta es:");
                libreriaJuanIPadSch.arreglosBidi.imprimirArrBidInt(matriz2);
                break;
            case 7:
                do{
                    System.out.println("Ingrese el numero al que desee sumar sus digitos: ");
                    n = scan.nextInt();
                    if (n<=0) System.out.println("ERROR: El numero no puede ser menor o igual a 0");
                    scan.nextLine(); //Limpiamos el Scanner
                }while (n<=0);
                int sumaDigitos = sumarDigitos(n);
                System.out.println("La suma de los digitos es: "+sumaDigitos);
                break;
            case 8:
                System.out.println("Ingrese una palabra: ");
                String palabra = scan.nextLine();
                String palabraAcom = consonantesVocalesRecursivo(palabra, 0);
                System.out.println("Su palabra acomodada es: "+palabraAcom);
                break;
            case 9:
                System.out.println("Ingrese una palabra: ");
                String palabra2 = scan.nextLine();
                String palabraRepetidaLetras = repetirLetraSegunPosRecursivo(palabra2, 0, 0);
                System.out.println("La palabra nueva es: "+palabraRepetidaLetras);
                break;
            case 10:
                System.out.println("Adios!");
                break;
            default:
                System.out.println("ERROR: Opcion invalida. Volviendo al menu");
                break;
        }
        scan.close();
    }
    /* Método para sacar factorial */
    public static int factorial(int n){
        int resultado;
        if (n==1){
            resultado=1;
        } else{
            resultado=n*factorial(n-1);
        }
        return resultado;
    }
    /* Metodo para sacar Fibonacci */
    public static int fibonacci(int n){
        int resultado;
        if(n==0){
            resultado=0;
        }else if(n==1){
            resultado=1;
        } else {
            resultado=fibonacci(n-2)+fibonacci(n-1);
        }
        return resultado;
    }
    /* Metodo para contar las iteraciones dentro de un numero */
    public static int contarVeces(int num, int chequear){
        int contadorT=0;
        if (num!=0){
            if(num%10==chequear){
                contadorT=contarVeces(num/10,chequear)+1;
            } else{
                contadorT=contarVeces(num/10,chequear);
            }
        }
        return contadorT;
    }
    /* Hacer una funcion recursiva para saber si un numero es primo */
    public static boolean esPrimo(int aVerificar, int num){
        boolean primoBoolean=false;
        if(aVerificar!=1 || (aVerificar%2)==0){ //Verificamos las excepciones
            if (num==1){ //Caso base, si llegas al final, es primo
                primoBoolean=true;
            } else{ //Caso general
                if ((aVerificar%num) != 0){ //Si no es divisible por el numero, entramos en recursividad
                    primoBoolean=esPrimo(aVerificar,num-1);
                } else{ //Si es divisible por un numero que no sea si mismo, entonces no es primo
                    primoBoolean=false;
                }
            }
        } else{
            primoBoolean=false; //Excepciones, si aVerificar es 1 o es par, no es primo
        }
        return primoBoolean;
    }
    /* Método para sumar los nros. pares de una matriz (recursivamente) */
    public static int sumarParesMatriz(int[][] matriz, int fil, int col){
        int sumaPares = 0;
        if(fil<matriz.length){
            if(col<matriz[0].length){
                if((matriz[fil][col])%2 == 0){
                    sumaPares = sumarParesMatriz(matriz, fil, (col+1)) + (matriz[fil][col]);
                }else{
                    sumaPares = sumarParesMatriz(matriz, fil, (col+1));
                }
            }else{
                sumaPares = sumarParesMatriz(matriz, (fil+1), 0);
            }
        }        
        return sumaPares;
    }
    /* Método que dada una Matriz devuelve su traspuesta */
    public static void matrizTraspuestaRecursivo(int[][] matriz, int fil, int col, int iniCol){
        int aux = 0;
        if(fil<matriz.length){
            if(col<matriz[0].length){
                    aux = matriz[col][fil];
                    matriz[col][fil] = matriz[fil][col];
                    matriz[fil][col] = aux;
                    matrizTraspuestaRecursivo(matriz, fil, (col+1), iniCol);
            } else{
                matrizTraspuestaRecursivo(matriz, (fil+1), (iniCol+1), (iniCol+1));
            }
        }
    }
    /* Método para sumar digitos de un numero */
    public static int sumarDigitos (int numero){
        int suma = 0;
        if(numero>=10){
            suma = (numero%10) + sumarDigitos(numero/10);
        }else{
            suma = numero;
        }
        return suma;
    }
    /* Método que dado un String pone primero las consonantes y despues las vocales */
    public static String consonantesVocalesRecursivo(String palabra, int pos){
        String palabraAcomodada = "", vocales = "aeiouAEIOU";
        if(pos<palabra.length()){
            if (vocales.indexOf(palabra.charAt(pos)) > -1 ){ //Si es vocal
                palabraAcomodada = consonantesVocalesRecursivo(palabra, (pos+1)) + palabra.charAt(pos);
            }else{ //Si es consonante
                palabraAcomodada = palabra.charAt(pos) + consonantesVocalesRecursivo(palabra, (pos+1));
            }
        }
        return palabraAcomodada.replace(" ", "");
    }
    /* Método (recursivo) que dada una palabra, repita la cantidad de veces igual a la posición */
    public static String repetirLetraSegunPosRecursivo(String palabra, int pos, int cantRep){
        String palabraLetrasRepetidas = "";
        if(cantRep<pos){
            if(pos<palabra.length()){
                palabraLetrasRepetidas = palabra.charAt(pos) + repetirLetraSegunPosRecursivo(palabra, pos, (cantRep+1));
            }else{
                palabraLetrasRepetidas = "";
            }
        }else{
            if(pos<palabra.length()){
                palabraLetrasRepetidas = palabra.charAt(pos) + repetirLetraSegunPosRecursivo(palabra, (pos+1), 0);
            }else{
                palabraLetrasRepetidas = "";
            }
        }
        return palabraLetrasRepetidas;
    }
}