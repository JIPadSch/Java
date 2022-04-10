package desarrolloDeAlgoritmos.tp3TDA.ejercicio1;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class testTerreno {
    public static void main(String[] args) {
        Terreno terreno=cargarTerreno();
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("JUANI HACE EL MENU");
            opcion=scan.nextInt();
            scan.nextLine();
            menu(opcion);
        }while(opcion!=4);
    }
    /* Menu */
    public static void menu(int opcion){

    }
    /* Modulo que permite cargar un Terreno */
    public static Terreno cargarTerreno(){
        Scanner scan = new Scanner (System.in);
        Terreno terreno;
        int codigo,manzana;
        double base,altura;
        System.out.println("Ingrese el código del terreno: ");
        codigo=scan.nextInt();
        scan.nextLine();
        do{
            System.out.println("Ingrese la base del terreno: ");
            base=scan.nextDouble();
            scan.nextLine();
            if(base<=0){
                System.out.println("ERROR: La base no puede ser menor o igual a 0");
            }
        } while(base<=0);
        do{
            System.out.println("Ingrese la altura del terreno: ");
            altura=scan.nextDouble();
            scan.nextLine();
            if(base<=0){
                System.out.println("ERROR: La altura no puede ser menor o igual a 0");
            }
        }while(altura<=0);
        do{
            System.out.println("manzana");
            manzana=scan.nextInt();
            if(manzana<=0){
                System.out.println("ERROR: La manzana no puede ser menor o igual a 0");
            }
        }while(manzana<=0);
        return terreno=new Terreno(codigo, base, altura, manzana);
    }
}