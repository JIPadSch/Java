package desarrolloDeAlgoritmos.tp3TDA.ejercicio2;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class testMascota {
    /* 
    *  Algoritmo que carga una mascota y luego permite:
    *  -Mostrar el nombre de la mascota
    *  -Aumentar la edad de la mascota en 1
    *  -Cambiar el peso de la mascota según lo ingresado
    *  -Mostrar todos los datos de la mascota
    */ 
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Mascota mascota=cargarMascota();
        int opcion;
        do{
            System.out.println("                     MENU                         ");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Mostrar el nombre de la mascota");
            System.out.println("2. Aumentar la edad de la mascota en 1");
            System.out.println("3. Cambiar el peso de la mascota (ingresará valor)");
            System.out.println("4. Mostrar todos los datos de la mascota");
            System.out.println("5. Salir del programa");
            opcion=scan.nextInt();
            scan.nextLine();
        }while(opcion!=5);
    }
    /* Menu */
    public static void menu(int opcion,Mascota mascota){
        switch(opcion){
            case 1:
                System.out.println("El nombre de la mascota es "+mascota.getNombre());
                break;
            case 2:
                mascota.cumpleaños();
                System.out.println("FELIZ CUMPLEAÑOS "+mascota.getNombre());
                break;
            case 3:
                cambiarPeso(mascota);
                break;
            case 4:
                System.out.println("Info de la mascota: "+mascota.toString());
                break;
            case 5:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("ERROR: Opción inválida");
                break;
        }
    }
    /* Modulo que nos permite cargar una mascota */
    public static Mascota cargarMascota(){
        Scanner scan = new Scanner (System.in);
        Mascota mascota;
        int codigo, edad;
        String nombre;
        double peso;
        System.out.println("Ingrese el código de la mascota: ");
        codigo=scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el nombre de su mascota: ");
        nombre=scan.nextLine();
        scan.nextLine();
        do{
            System.out.println("Ingrese el peso de su mascota: ");
            peso=scan.nextDouble();
            scan.nextLine();
            if(peso<=0){
                System.out.println("ERROR: El peso no puede ser menor o igual a 0");
            }
        }while(peso<=0);
        do{
            System.out.println("Ingrese la edad de su mascota: ");
            edad=scan.nextInt();
            scan.nextLine();
            if(edad<0){
                System.out.println("ERROR: La edad no puede ser menor a 0");
            }
        }while(edad<0);
        return mascota = new Mascota(codigo,nombre,peso,edad);
    }
    /* Modulo que permite cambiar el peso de la mascota según lo que ingrese el usario */
    public static void cambiarPeso(Mascota mascota){
        Scanner scan = new Scanner (System.in);
        double nuevoPeso;
        do{
            System.out.println("Ingrese el nuevo peso de su mascota: ");
            nuevoPeso=scan.nextDouble();
            scan.nextLine();
            if(nuevoPeso<=0){
                System.out.println("ERROR: El peso no puede ser menor o igual a 0");
            }
        }while(nuevoPeso<=0);
        mascota.setPeso(nuevoPeso);
    }
}