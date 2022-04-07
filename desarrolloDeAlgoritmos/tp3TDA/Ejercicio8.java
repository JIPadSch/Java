package desarrolloDeAlgoritmos.tp3TDA;
import desarrolloDeAlgoritmos.tp3TDA.ejercicio5.*;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio8 {
    /* 
    *  Algoritmo que permite almacenar aviones en un arreglo de Avion(es),
    *  en el mismo vamos a poder cargar todos los aviones y luego vamos a
    *  permitir que el usuario realice las siguientes acciones:
    *  1. Mostrar el avión que tiene mayor velocidad (en caso de iguales se devuelve el útlimo encontrado)
    *  2. Mostrar la cantidad de asientos que tiene un cierto avión (dado su ID)
    *  3. Mostrar cuantos aviones de un cierto modelo tiene la empresa
    *  4. Mostrar el promedio de Kms recorridos por todos los aviones
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Avion arrAvion[] = new Avion [verificarLongitud()];
        int opcion;
        do{
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("1. Mostrar el avión que tiene mayor velocidad (en caso de iguales se muestra el útlimo encontrado)");
            System.out.println("2. Mostrar la cantidad de asientos que tiene un cierto avión (dado su ID)");
            System.out.println("3. Mostrar cuantos aviones de un cierto modelo tiene la empresa");
            System.out.println("4. Mostrar el promedio de Kms recorridos por todos los aviones");
            System.out.println("5. Salir del programa");
            System.out.println("----------------------------------------------------------------------------------------------------");
            opcion=scan.nextInt();
            scan.nextLine();
            menu(opcion,arrAvion);
        }while(opcion!=5);        
    }
    /* Menu */
    public static void menu(int opcion, Avion[] arrAvion){
        Scanner scan = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("El avión con mayor velocidad es el avión: "+buscarArrAvionMayorVelocidad(arrAvion));
                break;
            case 2:
                int idAux;
                System.out.println("Escriba el Identificador del avión: ");
                idAux=scan.nextInt();                
                if(identificadorExiste(arrAvion,idAux)){
                    System.out.println("El avión "+idAux+" tiene "+cantAsientosPorIdentificador(arrAvion, idAux)+" asientos");
                } else{
                    System.out.println("Ese Identificador no está registrado o es inválido");
                }
                break;
            case 3:
                String modelo;
                System.out.println("Ingrese el modelo de los aviones que desea ver: ");
                modelo=scan.nextLine();
                if(modeloExiste(arrAvion,modelo)){
                    System.out.println("La empresa tiene "+cantAvionesPorModelo(arrAvion,modelo)+" aviones del mismo modelo");
                } else{
                    System.out.println("El modelo no existe dentro de la empresa o es inválido");
                }
                break;
            case 4:
                System.out.println("El promedio de todos los Kms recorridos por los aviones es de: "+promedioKmsRecorridoAviones(arrAvion));
                break;
            case 5:
                System.out.println("Adiós");        
            default:
                System.out.println("OPCIÓN INVÁLIDA");
                break;
        }
    }
    /* Modulo que verifica que la longitud del arreglo sea mayor a 0 */
    public static int verificarLongitud(){
        Scanner scan = new Scanner(System.in);
        int longitud;
        do{
            System.out.println("Ingrese la cantidad de aviones que desea almacenar: ");
            longitud = scan.nextInt();
            if (longitud<=0){
                System.out.println("ERROR: La longitud debe ser mayor a 0");
            }
        } while(longitud<=0);
        return longitud;        
    }
    /* Modulo que permite cargar cada avión del arreglo de Avion(es) */
    public static void cargarArrAvion(Avion[] arrAvion){
        int i;
        for (i=0;i<arrAvion.length;i++){
            arrAvion[i]=testAvion.cargarAvion();
        }
    }
    /* Modulo que devuelve el avión que tiene mayor velocidad */
    public static int buscarArrAvionMayorVelocidad(Avion[] arrAvion){
        Avion avionAux = new Avion (arrAvion[0].getIdentificador(),arrAvion[0].getModelo(),arrAvion[0].getCantAsientos(),arrAvion[0].getKmRecorridos(),arrAvion[0].getVelPromedio());
        int i,mayorVel=0;
        for (i=0;i<arrAvion.length;i++){
            if(arrAvion[i].getVelPromedio()>=avionAux.getVelPromedio()){
                avionAux=arrAvion[i];
                mayorVel=i;
            }
        }
        return mayorVel;
    }
    /* Modulo que verifica que el Identificador existe */
    public static boolean identificadorExiste(Avion[] arrAvion, int idAux){
        boolean idExiste=false;
        int i=0;
        while(!idExiste && i<arrAvion.length){
            if(arrAvion[i].getIdentificador()==idAux){
                idExiste=true;
            } else{
                i++;
            }
        }
        return idExiste;
    }
    /* Modulo que devuelve la cantidad de asientos que tiene un avion según su identificador*/
    public static int cantAsientosPorIdentificador(Avion[] arrAvion, int idAux){
        int i=0;
        boolean idEncontrado=false;
        while(!idEncontrado){
            if(arrAvion[i].getIdentificador()==idAux){
                idEncontrado=true;
            } else{
                i++;
            }
        }
        return arrAvion[i].getCantAsientos();
    }
    /* Modulo que verifica que el modelo de avión existe en la empresa */
    public static boolean modeloExiste(Avion[] arrAvion, String modelo){
        boolean modExiste=false;
        int i=0;        
        while(!modExiste){
            if (arrAvion[i].getModelo().equalsIgnoreCase(modelo)){
                modExiste=true;
            } else{
                i++;
            }
        }
        return modExiste;
    }
    /* Modulo que muestra la cantidad de aviones que tiene la empresa según el modelo */
    public static int cantAvionesPorModelo(Avion[] arrAvion, String modelo){
        int i, cantMismoMod=0;
        for(i=0;i<arrAvion.length;i++){
            if(arrAvion[i].getModelo().equalsIgnoreCase(modelo)){
                cantMismoMod++;
            }
        }
        return cantMismoMod;
    }
    /* Modulo que devuelve la cantidad de Kms recorrido por todos los aviones */
    public static double promedioKmsRecorridoAviones(Avion[] arrAvion){
        double promedioKmsRecorridos=0;
        int i;
        for (i=0;i<arrAvion.length;i++){
            promedioKmsRecorridos+=arrAvion[i].getKmRecorridos();
        }
        return promedioKmsRecorridos/arrAvion.length;
    }
}