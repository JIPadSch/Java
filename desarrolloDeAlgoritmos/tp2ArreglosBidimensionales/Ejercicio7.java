package desarrolloDeAlgoritmos.tp2ArreglosBidimensionales;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio7 {
    /*Dada una matriz numérica, se hacen 4 tipos de recorridos
    1- Por filas de atrás hacia adelante; 2- Por columnas de arriba hacia abajo;
    3- En espiral; 4- En zig-zag*/
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        char opcion;
        int random = ThreadLocalRandom.current().nextInt(2,9);
        int[][] matrizCuadrada = new int [random][random];
        cargarAutoMatrizCuadrada(matrizCuadrada);
        System.out.println("Trabajaremos con la siguiente matriz:");
        imprimirArrBidInt(matrizCuadrada);
        System.out.println("\n");
        do{
            System.out.println("Elija una opción del menú: ");
            System.out.println("------------------------------------------------------------------");
            System.out.println("a. Ver el recorrido de la matriz (filas) de atrás hacia adelante");
            System.out.println("b. Ver el recorrido de la matriz (columnas) de arriba hacia abajo");
            System.out.println("c. Ver el recorrido de la matriz en espiral");
            System.out.println("d. Ver el recorrido de la matriz en zig-zag");
            System.out.println("e. Terminar y salir del programa");
            System.out.println("------------------------------------------------------------------");
            opcion=scan.next().charAt(0);
            scan.nextLine();
            menu(Character.toLowerCase(opcion),matrizCuadrada); 
        }while (opcion!='e');
    }
    /*Menú*/
    public static void menu(char opcion, int[][] matrizCuadrada){
        switch (opcion) {
            case 'a':
                recorrerAtrasAdelante(matrizCuadrada);  
                break;
            case 'b':
                recorrerArribaAbajo(matrizCuadrada);
                break;
            case 'c':
                recorrerEspiral(matrizCuadrada);
                break;
            case 'd':
                recorrerZigZag(matrizCuadrada);
                break;
            case 'e':
                System.out.println("ADIÓS");
                break;        
            default:
            System.out.println("ERROR: Elija una opción válida");
                break;
        }
    }
    /*Módulo que muestra por pantalla un arreglo bidimensional de enteros*/
    public static void imprimirArrBidInt (int[][] arrBidInt){
        int i,j;
        for (i=0;i<arrBidInt.length;i++){
            for(j=0;j<arrBidInt[i].length;j++){
                System.out.print(" |"+arrBidInt[i][j]+"| ");
            }
            System.out.println("\n");
        }
    }
    /*Módulo que carga automaticamente una matriz cuadrada*/
    public static void cargarAutoMatrizCuadrada(int[][] matrizCuadrada){
        int i,j;
        for (i=0;i<matrizCuadrada.length;i++){
            for (j=0;j<matrizCuadrada[0].length;j++){
                matrizCuadrada[i][j]=i+j;
            }
        }
    }
    /*Módulo que recorre (y muestra) la matriz por filas de atrás hacia adelante*/
    public static void recorrerAtrasAdelante(int[][] matrizCuadrada){
        int i,j;
        for(i=0;i<matrizCuadrada.length;i++){
            for(j=matrizCuadrada[0].length-1;j>0;j--){
                System.out.print(" |"+matrizCuadrada[i][j]+"| ");
            }
            System.out.println("\n");
        }
    }
    /*Modulo que recorre (y muestra) la matriz por columnas de arriba hacia abajo*/
    public static void recorrerArribaAbajo(int[][] matrizCuadrada){
        int i,j;
        for (j=0;j<matrizCuadrada[0].length;j++){
            for (i=0;i<matrizCuadrada.length;i++){
                System.out.print(" |"+matrizCuadrada[i][j]+"| ");
            }
            System.out.println("\n");
        }
    }
    /*Módulo que recorre (y muestra) la matriz en espiral*/
    public static void recorrerEspiral(int[][] matrizCuadrada){
        int i=0,j=0,finIda=matrizCuadrada[0].length, finBajada=matrizCuadrada.length, finVuelta=0,finSubida=1,limite=(matrizCuadrada.length+matrizCuadrada[0].length)-1,aux=0;
        boolean yendo=true,bajando=false,volviendo=false,subiendo=false;
        while(yendo){
            if (j==finIda && aux<limite){
                bajando=true;
                finIda--;
                aux++;
                i++; //Corrijo imprimir
                j--; //Corrijo el hecho de llegar a lenght
                System.out.println("\n");
            } else if (aux==limite){
                yendo=false;
            } else{
                System.out.print(" |"+matrizCuadrada[i][j]+"| ");
                j++;
            }
            while(bajando){
                if (i==finBajada && aux<limite){
                    bajando=false;
                    volviendo=true;
                    finBajada--;
                    aux++;
                    j--; //Corrijo imprimir
                    i--; //Corrijo el hecho de llegar a lenght
                    System.out.println("\n");
                } else if (aux==limite){
                    bajando=false;
                } else{
                    System.out.print(" |"+matrizCuadrada[i][j]+"| ");
                    i++;
                }
                while(volviendo){
                    if (j<finVuelta && aux<limite){
                        volviendo=false;
                        subiendo=true;
                        finVuelta++;
                        aux++;
                        i--; //Corrijo el imprimir
                        j++; //Corrijo el hecho de llegar a -1
                        System.out.println("\n");
                    } else if (aux==limite){
                        volviendo=false;
                    } else{
                        System.out.print(" |"+matrizCuadrada[i][j]+"| ");
                        j--;
                    }
                    while (subiendo){
                        if (i<finSubida && aux<limite){
                            subiendo=false;
                            finSubida++;
                            aux++;
                            j++; //Corrijo el imprimir
                            i++; //Corrijo el hecho de llegar a -1
                            System.out.println("\n");
                        } else if (aux==limite){
                            subiendo=false;
                        } else{
                            System.out.print(" |"+matrizCuadrada[i][j]+"| ");
                            i--;
                        }
                    }
                }
            }

        }
    }
    /*Módulo que recorre (y muestra) la matriz en zig-zag*/
    public static void recorrerZigZag(int[][] matrizCuadrada){
        int i=0,j=0;
        boolean yendo=true, volviendo=false;
        while(yendo){
            if(i==matrizCuadrada.length){
                yendo=false;
            }else if (j==matrizCuadrada[0].length && i<matrizCuadrada.length){
                volviendo=true;
                i++;
                j--; //Corrijo el hecho de llegar a length
                System.out.println("\n");
            } else{
                System.out.print(" |"+matrizCuadrada[i][j]+"| ");
                j++;
            }            
            while (volviendo){
                if(i==matrizCuadrada.length){
                    yendo=false;
                } else if(j<0){
                    volviendo=false;
                    i++;
                    j++; //Corrijo el hecho de llegar a -1
                    System.out.println("\n");
                } else{
                    System.out.print(" |"+matrizCuadrada[i][j]+"| ");
                    j--;
                }                
            }
        }
    }   
}