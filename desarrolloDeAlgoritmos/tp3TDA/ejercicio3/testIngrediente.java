package desarrolloDeAlgoritmos.tp3TDA.ejercicio3;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class testIngrediente {
    /* Test simple, permite ver y cambiar la información de un Ingrediente creado */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Ingrediente ingrediente = cargarIngrediente();
        int opcion;
        do{
            System.out.println("                MENU                ");
            System.out.println("--------------------------------------");
            System.out.println("1. Mostrar info del ingrediente");
            System.out.println("2. Cambiar información del ingredente");
            System.out.println("3. Salir del programa");
            opcion=scan.nextInt();
            scan.nextLine();
        }while(opcion!=3);
    }
    /* Menu */
    public static void menu(int opcion,Ingrediente ingrediente){
        switch (opcion) {
            case 1:
                ingrediente.toString();
                break;
            case 2:
                cambiarInfoIngrediente(ingrediente);
                break;
            case 3:
                System.out.println("Adiós!");
                break;        
            default:
                System.out.println("ERROR: Opcion inválida");
                break;
        }
    }
    /* Modulo que nos permite cargar un objeto Ingrediente */
    public static Ingrediente cargarIngrediente(){
        Scanner scan = new Scanner (System.in);
        Ingrediente ingredienteAux;
        String nom, unDeMed;
        int cant;
        System.out.println("Ingrese el nombre de ingrediente: ");
        nom=scan.nextLine();
        scan.nextLine();
        System.out.println("Ingrese la cantidad que se desea del producto: ");
        cant=scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese la unidad de medida: ");
        unDeMed=scan.nextLine();
        scan.nextLine();
        return ingredienteAux = new Ingrediente(nom, cant, unDeMed);
    }
    /* Modulo que permite elegir que ingrediente desea cambiar */
    
}
