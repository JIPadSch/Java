package desarrolloDeAlgoritmos.tp3TDA.ejercicio5;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class testAvion {
    /* Test de la Clase Avion */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Avion unAvion;
        System.out.println("A continuación cargará la información del avión");
        unAvion=cargarAvion();
        int opcion;
        do{
            System.out.println("---------------------------");
            System.out.println("1. Cambiar info de avión");
            System.out.println("2. Ver info de avión");
            System.out.println("3. Salir");
            System.out.println("---------------------------");
            opcion = scan.nextInt();
            scan.nextLine();
            menu(opcion,unAvion);
        }while(opcion!=3);
    }
    public static void menu(int opcion, Avion unAvion){
        switch (opcion) {
            case 1:
                cambiarInfoAvion(unAvion);
                break;
            case 2:
                imprimirAvion(unAvion);
                break;
            case 3:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("ERROR: Esa no es una opción válida");
                break;
        }
    }
    /* Modulo que permite cargar la información de un Avion */
    public static Avion cargarAvion (){
        /*  El objeto Avion tiene 5 atributos, estos son:
        1-int identificador; 2-String modelo; 3-int cantidadAsientos;
        4-double kmRecorridos; 5-double velocidadPromedio; */
        Scanner scan = new Scanner (System.in);
        Avion unAvion;
        int id, cantAsi;
        String mod;
        double kmRec, velProm;
        System.out.println("Ingrese el Identificador del avión: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el modelo del avión: ");
        mod = scan.nextLine();
        scan.nextLine();
        cantAsi=ponerCambiarAsientos();
        kmRec=ponerCambiarKm();
        velProm=ponerCambiarVelProm();   
        return unAvion = new Avion (id,mod,cantAsi,kmRec,velProm);
    }
    /* Modulo que permite cambiar la información del avión */
    public static void cambiarInfoAvion (Avion unAvion){
        Scanner scan = new Scanner (System.in);
        int opcion;
        System.out.println("¿Que desea cambiar?");
        System.out.println("1. Cantidad de asientos");
        System.out.println("2. Kms recorridos");
        System.out.println("3. Velocidad promedio");
        System.out.println("4. Volver al menú");
        opcion=scan.nextInt();
        scan .nextLine();
        switch (opcion) {
            case 1:            
                System.out.println("La cantidad actual de asientos es: "+unAvion.getCantAsientos());                
                unAvion.setCantAsientos(ponerCambiarAsientos());
                break;
            case 2:
                System.out.println("La cantidad actual de Kms recorridos es: "+unAvion.getKmRecorridos());
                unAvion.setKmRecorridos(ponerCambiarKm());
                break;
            case 3:
                System.out.println("La cantidad actual de velocidad promedio es: "+unAvion.getVelPromedio());
                unAvion.setVelPromedio(ponerCambiarVelProm());
                break;
            case 4:
                System.out.println("Volviendo al menú");
                break;
            default:
                System.out.println("OPCION INVALIDA. Volviendo al menú");
                break;
        }
    }
    /* Modulo que reutilizamos para setear y cambiar cantidadAsientos */
    public static int ponerCambiarAsientos(){
        Scanner scan = new Scanner(System.in);
        int cantAsi;
        do{
            System.out.println("Ingrese la nueva cantidad de asientos: ");
            cantAsi = scan.nextInt();
            scan.nextLine();
            if (cantAsi<=0){
                System.out.println("NO PUEDE PONER ASIENTOS NEGATIVOS O NINGUN ASIENTO");
            }
        } while (cantAsi<=0);
        return cantAsi;
    }
    /* Modulo que reutilizamos para setear y cambiar kmRecorridos */
    public static double ponerCambiarKm(){
        Scanner scan = new Scanner(System.in);
        double kmRec;
        do{
            System.out.println("Ingrese la cantidad de Km recorridos: ");
            kmRec = scan.nextDouble();
            scan.nextLine();
            if(kmRec<0){
                System.out.println("NO PUEDE PONER KMs NEGATIVOS");
            }
        }while (kmRec<0);  
        return kmRec;
    }
    /* Modulo que reutilizamos para setear y cambiar la velocidadPromedio */
    public static double ponerCambiarVelProm(){
        Scanner scan = new Scanner(System.in);
        double velProm;
        do{
            System.out.println("Ingrese la velocidad promedio: ");
            velProm = scan.nextDouble();
            scan.nextLine();
            if (velProm<=0){
                System.out.println("NO PUEDE PONER VELOCIDAD PROMEDIO NEGATIVO O 0");
            }
        }while(velProm<=0);
        return velProm;
    }
    /* Modulo que imprime la información de un Avion */
    public static void imprimirAvion(Avion unAvion){
        System.out.println("La ID del avión es: "+unAvion.getIdentificador());
        System.out.println("El modelo del avión es: "+unAvion.getModelo());
        System.out.println("El avión tiene "+unAvion.getCantAsientos()+" asientos");
        System.out.println("El avión recorrió "+unAvion.getKmRecorridos()+" Kms");
        System.out.println("El avión viaja a una velocidad promedio de "+unAvion.getVelPromedio());
    }
}
