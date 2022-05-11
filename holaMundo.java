import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class holaMundo {

    private static final boolean AMOR = true; //Declaramos una constante de amor que jamás cambia

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("                   .:MENU:.                   ");
            System.out.println("Ingrese como desea ver mi amor hacia Emi <3");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Mensaje impreso");
            System.out.println("2. De manera repetitiva");
            System.out.println("3. De manera recursiva");
            System.out.println("4. Con un método While (ATENCIÓN: rompera el programa)");
            System.out.println("5. Salir del programa");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            opcion = scan.nextInt();
            scan.nextLine();
            menuDelAmor(opcion);
        }while (opcion!=5);
    }
    /* Menu del amor */
    public static void menuDelAmor(int opcion){
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
                    scan.nextLine();
                }while (cantidad<=0);
                mensajeDelAmorRepetitivo(cantidad);
                break;   
            case 3:
                do{
                    System.out.println("Escriba cuantas veces desea ver el mensaje de manera recursiva: ");
                    cantidad = scan.nextInt();
                    if (cantidad<=0) System.out.println("ERROR: La cantidad no puede ser menor o igual a 0, mi amor por Emi es infinito");
                    scan.nextLine();
                }while (cantidad<=0);    
                mensajeDelAmorRecursivo(cantidad); 
                break;
            case 4:
                String dobleChequeo;
                System.out.println("¿Está seguro que desea ejecutar esta opción?");
                System.out.println("Romperá el programa ya que 'amor' es una constante siempre verdadera" );
                System.out.println("El programa se ejecutará hasta quedarse sin memoria");
                System.out.println("En caso de desear continuar, escriba 'SI' (no importan las Mayusculas), cualquier otra opción lo hará volver al menú");
                dobleChequeo = scan.nextLine();
                if (dobleChequeo.equalsIgnoreCase("SI")){
                    mensajeDelAmorRompePrograma();
                }else{
                    System.out.println("Mi amor por Emi es infinito, usted se acaba de salvar de romper el programa");
                    System.out.println("Volviendo al menú ...");
                    scan.nextLine();    
                }
                break;
            case 5:
                System.out.println("Adiós! Fue un placer haberle demostrado mi amor por Emi <3");
                break;
            default:
                System.out.println("Opción inválida: Por favor elija una opción para mostrarle mi amor hacia Emi");
                System.out.println("Volviendo al menú ...");
                break;
        }
    }
    /* Modulo de mensaje del amor */
    public static void mensajeDelAmor(){
        System.out.println("Te amo mi Reina hermosa <3");
    }
    /* Modulo que muestra el mensaje del amor de manera repetitiva */
    public static void mensajeDelAmorRepetitivo(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            mensajeDelAmor();
        }
    }
    /* Modulo que muestra el mensaje del amor de manera recursiva */
    public static void mensajeDelAmorRecursivo(int cantidad){
        if (cantidad==0){
            mensajeDelAmor();
        } else{
            mensajeDelAmor();
            mensajeDelAmorRecursivo(cantidad-1);
        }
    }
    /* Modulo que muestra el mensaje del amor hasta que la constante amor cambie (lo cual es nunca y rompera el programa) */
    public static void mensajeDelAmorRompePrograma(){
        System.out.println("Usted decidió la muerte del programa, disfrute");
        while(AMOR){
            mensajeDelAmor();
        }
    }
}
