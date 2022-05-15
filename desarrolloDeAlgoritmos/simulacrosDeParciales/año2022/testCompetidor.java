package desarrolloDeAlgoritmos.simulacrosDeParciales.año2022;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class testCompetidor {
    /*
    *  Algoritmo que permite crear un arreglo de Competidores, buscar los competidores (y mostrarlos) con un IMC
    *  menor a 18.5 y además verificar si existe almenos un Competidor con un IMC dado
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Competidor[] arrCompetidores = new Competidor[verificarLongitud()];
        int opcion;
        do{
            System.out.println("--------------------------------------------------------------");
            System.out.println("                             MENU                             ");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Buscar en el arreglo los Competidores con IMC menor a 18.5");
            System.out.println("2. Verificar si existe almenos un Competidor con un IMC dado");
            System.out.println("3. Salir del programa");
            System.out.println("--------------------------------------------------------------");
            opcion = scan.nextInt();
            scan.nextLine(); //Limpiamos el Scanner
        }while(opcion!=3);
        scan.close();
    }    
    /* MENU */
    public static void menu (int opcion, Competidor[] arrCompetidores){
        Scanner scan = new Scanner (System.in);
        switch (opcion) {
            case 1:
                Competidor[] compsImcBajoPeso = compIMCBajo(arrCompetidores);
                System.out.println(compsImcBajoPeso.toString());
                break;
            case 2:
                double imcDado = scan.nextDouble();
                System.out.println("¿Existe almenos un competidor con ese IMC?: "+existeCompConIMC(arrCompetidores, imcDado));
            case 3:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("Opción inválida. Volviendo al menú");
                break;
        }
        scan.close();
    }
    /* Módulo que verifica la longitud para poder crear un arreglo de Competidores */
    public static int verificarLongitud(){
        Scanner scan = new Scanner (System.in);
        int longitud=0;
        do{
            System.out.println("Ingrese la longitud del arreglo: ");
            longitud = scan.nextInt();
            if (longitud<=0) System.out.println("ERROR: La longitud no puede ser menor o igual a 0");
            scan.nextLine(); //Limpiamos el Scanner
        }while (longitud<=0);
        scan.close();
        return longitud;
    }
    /* Módulo que permite cargar un arreglo de Competidores */
    public static void cargarArrCompetidores(Competidor[] arrCompetidores){
        Scanner scan = new Scanner (System.in);
        int unDni=0;
        for (int i = 0; i < arrCompetidores.length; i++) {
            unDni= cargarDNI(arrCompetidores);
            Competidor competidorAux = new Competidor(unDni, nom, ape, unaEdad, ciudadO, pes, alt);
            arrCompetidores[i] = competidorAux;
        }
        scan.close();
    }
    /* Modulo que verifica y devuelve un dni de Competidor */
    public static int cargarDNI(Competidor[] arrCompetidores){
        Scanner scan = new Scanner (System.in);
        int dni=0;
        boolean existe=false;
        do{
            System.out.println("Ingrese el DNI: ");
            dni = scan.nextInt();
            existe = dniExiste(arrCompetidores, dni);
            if (existe) System.out.println("Ese DNI ya existe");
            scan.nextLine(); //Limpiamos el Scanner
        } while (existe);
        scan.close();
        return dni;
    }
    /* Verifica que el DNI no existe ya en otro Competidor */
    public static boolean dniExiste(Competidor[] arrCompetidores,int dniBuscado){
        Competidor compAux = new Competidor(dniBuscado);
        boolean existe=false, parar=false;
        int i=0;
        while(!existe && i<arrCompetidores.length && !parar){
            if(arrCompetidores[i] == null){
                parar = true;
            } else if (arrCompetidores[i].equals(compAux)){
                existe=true;
            } else{
                i++;
            }            
        }
        return existe;
    }
    /* 
    *  Realice un método que recorra el arreglo de competidores retorne otro arreglo con los
    *  competidores que tienen un IMC de bajo peso (< 18.5) 
    */
    public static Competidor[] compIMCBajo(Competidor[] arrCompetidores){
        Competidor[] arrCompBajoPeso = new Competidor[arrCompetidores.length];
        int j=0; //Posiciones del nuevo arreglo
        double imcAux=0;
        for (int i = 0; i < arrCompetidores.length; i++) {
            imcAux=Competidor.IMC(arrCompetidores[i].getPeso(), arrCompetidores[i].getAltura());
            if(imcAux < 18.5){
                arrCompBajoPeso[j] = arrCompetidores[i];
                j++;
            }
        }
        return arrCompBajoPeso;
    }
    /* 
    *  Realice un método que dado un IMC específico retorne si existe al menos un competidor con
    *  dicho IMC en el arreglo.
    */
    public static boolean existeCompConIMC(Competidor[] arrCompetidores,double imcDado){
        boolean existe=false;
        int i=0;
        double imcAux=0;
        while(!existe && i<arrCompetidores.length){
            imcAux = Competidor.IMC(arrCompetidores[i].getPeso(), arrCompetidores[i].getAltura()); //Asignamos los valores IMC del comp en pos "i"
            if(imcDado == imcAux ) existe = true;
            i++;
        }
        return existe;
    }
}