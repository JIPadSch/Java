package desarrolloDeAlgoritmos.tp2ArreglosBidimensionales;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
private class Ejercicio4 {
    /*Algoritmo que permite cargar 6 notas de 10 alumnos en una matriz y luego permite realizar varias operaciones*/
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);
        int[][] notasAlus = new int[10][6];
        char opcion;
        System.out.println("Ingrese las notas 6 notas de sus 10 alumnos: ");
        llenarArrBidInt(notasAlus);
        do {
            System.out.println("Elija una opción del menú: ");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("a. Calcular el promedio de todos sus alumnos y mostrarlos por pantalla");
            System.out.println("b. Mostrar por pantalla las notas del alumno 'i'");
            System.out.println("c. Mostrar por pantalla la mayor nota que han sacado los alumnos en el último examen y quien fue el alumno que logró esa nota");
            System.out.println("d. Terminar y salir del programa");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            opcion = scan.next().charAt(0);
            scan.nextLine();
            menu(opcion,notasAlus);
        } while (opcion!='d');
    }
    /*Menú del programa, nos lleva a los módulos según invocación*/
    public static void menu (int opcion, int[][] notasAlus){
        Scanner scan = new Scanner (System.in);
        switch (opcion) {
            case 'a':
                int[] promedioAlus = new int[10];
                promedioAlus=calcularPromedio(notasAlus);
                imprimirArrInt(promedioAlus);
                break;
            case 'b':
                int alu;
                System.out.println("Indique las notas de que alumno desea ver: ");
                do{
                    alu = scan.nextInt();
                    scan.nextLine();
                    if ((alu<0 || alu>9)){
                        System.out.println("ERROR: Número de alumno inválido. Ingrese nuevamente: ");
                    }
                } while(alu>=0 && alu<=9);
                mostrarNotasAluElegido(notasAlus,alu);
                break;
            case 'c':
                int posMayorNota=mayorNotaAluUltimoEx(notasAlus);
                System.out.println("La mayor nota fue: "+notasAlus[posMayorNota][6]+". Y fue del alumno: "+posMayorNota);
                break;
            case 'd':
                System.out.println("Adiós!");
                break;        
            default:
                System.out.println("ERROR: Esa no es una opción válida");
                break;
        }
    }
    /*Módulo que permite llenar un arreglo bidimensional de enteros*/
    public static void llenarArrBidInt (int[][] arrBidInt){
        Scanner scan = new Scanner (System.in);
        int i,j;
        for (i=0;i<arrBidInt.length;i++){
            for(j=0;j<arrBidInt[i].length;j++){
                System.out.println("Llenar posición "+i+"|"+j+" : ");
                arrBidInt[i][j] = scan.nextInt();
                scan.nextLine();
            }
        }
    }
    /*Módulo que muestra por pantalla un arreglo bidimensional de enteros*/
    public static void imprimirArrBidInt (int[][] arrBidInt){
        int i,j;
        for (i=0;i<arrBidInt.length;i++){
            for(j=0;j<arrBidInt[i].length;j++){
                System.out.println(" |"+arrBidInt[i][j]+"| ");
            }
        }
    }
    /*Módulo que calcula el promedio de notas entre todos los alumnos*/
    public static int[] calcularPromedio(int[][] arrAlu){
        int[] promedioAlus = new int [10];
        int i,j, promedio;
        for (i=0;i<arrAlu.length;i++){
            promedio=0;
            for(j=0;i<arrAlu[0].length;i++){
                promedio+=arrAlu[i][j];
            }
            promedioAlus[i]=promedio/6;
        }
        return promedioAlus;
    }
    /*Módulo que muestra por pantalla un arreglo de ints*/
    public static void imprimirArrInt (int[] arrInt){
        int i;
        for (i=0;i<arrInt.length;i++){
             System.out.println(" "+arrInt[i]+" ");
        }
    }
    /*Módulo que muestra por pantalla las notas de un alumno específico*/
    public static void mostrarNotasAluElegido (int[][] arrAlu, int aluElegido){
        int j;
        System.out.println("Usted eligió ver las notas del alumno : "+aluElegido);
        for (j=0;j<arrAlu[0].length;j++){
            System.out.println(" "+arrAlu[aluElegido][j]+" ");
        }
    }
    /*Módulo que busca y devuelve el alumno que sacó la mayor nota en el último examen*/
    public static int mayorNotaAluUltimoEx (int[][] notasAlus){
        int i, posMayorNotaAlu=0;
        for (i=0;i<notasAlus.length;i++){
            if (notasAlus[posMayorNotaAlu][6]<notasAlus[i][6]){
                posMayorNotaAlu=i;
            }
        }
        return posMayorNotaAlu;
    }
}
