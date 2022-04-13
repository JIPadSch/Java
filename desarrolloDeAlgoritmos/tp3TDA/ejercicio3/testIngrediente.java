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
            scan.nextLine(); //Limpiamos el Scanner
            menu(opcion, ingrediente);
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
        scan.nextLine(); //Limpiamos el Scanner
        System.out.println("Ingrese la cantidad que se desea del producto: ");
        cant=scan.nextInt();
        scan.nextLine(); //Limpiamos el Scanner
        System.out.println("Ingrese la unidad de medida: ");
        unDeMed=scan.nextLine();
        scan.nextLine(); //Limpiamos el Scanner
        return ingredienteAux = new Ingrediente(nom, cant, unDeMed);
    }
    /* Modulo que permite elegir que desea cambiar del ingrediente */
    public static void cambiarInfoIngrediente(Ingrediente ingrediente){
        Scanner scan = new Scanner (System.in);
        int opcionCambio=menuCambio();
        switch (opcionCambio) {
            case 1:
                int cant;
                do{
                    cant=scan.nextInt();
                    if (cant<=0){
                        System.out.println("ERROR: La cantidad no puede ser menor o igual a 0");
                        scan.nextLine(); //Si puso mal la opcion, limpiamos el Scanner
                    }
                } while(cant<=0);
                ingrediente.setCantidad(cant);
                break;
            case 2:
                ingrediente.setUnidadDeMedida(scan.nextLine());
                break;        
            default:
                System.out.println("ERROR: Opción inválida");
                break;
        }
    }
    /* Menu para elegir la opcion de cambiarInfoIngrediente */
    public static int menuCambio(){
        Scanner scan = new Scanner (System.in);
        int opcion;
        System.out.println("Elija que cambiar:");
        System.out.println("--------------------");
        System.out.println("1. Cantidad");
        System.out.println("2. Unidad de medida");
        return opcion=scan.nextInt();
    }
}
