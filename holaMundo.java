import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class holaMundo {

    static final boolean amor = true; //Declaramos una constante de amor que jamás cambia

    protected static void miVersionHolaMundo(String[] args) {
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("                   .:MENU:.                   ");
            System.out.println("Ingrese como desea ver mi amor hacia Emi <3");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Mensaje impreso");
            System.out.println("2. De manera repetitiva");
            System.out.println("3. De manera recursiva");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            opcion = scan.nextInt();
        }while (opcion!=4);
    }
    /* Menu del amor */
    protected static void menuDelAmor(int opcion){
        Scanner scan = new Scanner (System.in);
        int cantidad;
        switch (opcion) {
            case 1:
                mensajeDelAmor();
                break;
            case 2:
                do{
                    System.out.println("Escriba cuantas veces desea ver el mensaje de manera repetitiva: ");
                    cantidad = scan.nextInt();
                    if (cantidad<=0) System.out.println("ERROR: La cantidad no puede ser menor o igual a 0, mi amor por Emi es infinito");
                }while (cantidad<=0);
                break;   
            case 3:
                do{
                    System.out.println("Escriba cuantas veces desea ver el mensaje de manera repetitiva: ");
                    cantidad = scan.nextInt();
                    if (cantidad<=0) System.out.println("ERROR: La cantidad no puede ser menor o igual a 0, mi amor por Emi es infinito");
                }while (cantidad<=0);     
                break;
            case 4:
                System.out.println("Adiós! Fue un placer haberle demostrado mi amor por Emi <3");
            default:
                System.out.println("Opción inválida: Por favor elija una opción para mostrarle mi amor hacia Emi");
                System.out.println("Volviendo al menú ...");
                break;
        }
    }
    /* Modulo de mensaje del amor */
    protected static void mensajeDelAmor(){
        System.out.println("Te amo mi Reina hermosa <3");
    }
    /* Modulo que muestra el mensaje del amor de manera repetitiva */
    protected static void mensajeDelAmorRepetitivo(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            mensajeDelAmor();
        }
    }
    /* Modulo que muestra el mensaje del amor de manera recursiva */
    protected static void mensajeDelAmorRecursivo(int cantidad){
        if (cantidad==0){
            mensajeDelAmor();
        } else{
            mensajeDelAmor();
            mensajeDelAmorRecursivo(cantidad-1);
        }
    }
}
