package desarrolloDeAlgoritmos.tp3TDA.ejercicio1;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class testTerreno {
    /* 
    *  ALgoritmo que permite cargar los datos de un terreno y luego permite:
    *  -Mostrar el perímetro del terreno y la cantidad de alambre si se desea
    *  poner un cerco que de tres vueltas alrededor del terreno
    *  -Calcular la superficie del terreno y el costo de limparlo si la
    *  limpieza cuesta $150 por metro cuadrado
    *  -Calcular el valor del terreno solicitandole al usuario que ingrese el
    *  costo por metro cuadrado del terreno
    */
    public static void main(String[] args) {
        Terreno terreno=cargarTerreno();
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("                                   MENU                                       ");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1. Mostrar el perímetro del terreno y la cantidad de alambre para tres vueltas");
            System.out.println("2. Muestra la superficie del terreno y el costo de limpiarlo ($150xm^2)");
            System.out.println("3. Muestra el valor del terreno según el costo del m^2 (ingresado)");
            System.out.println("4. Salir del programa");
            opcion=scan.nextInt();
            scan.nextLine();
            menu(opcion,terreno);
        }while(opcion!=4);
    }
    /* Menu */
    public static void menu(int opcion, Terreno terreno){
        switch (opcion) {
            case 1:
                imprimirPerimetroYAlambre(terreno);
                break;
            case 2:
                imprimirSuperficieYCostoLimpieza(terreno);
                break;
            case 3:
                imprimirValorTerreno(terreno);
                break;
            case 4:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("ERROR: Esa no es una opción válida");
                break;
        }
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
    /* Modulo que muestra el perimetro y la cantidad de alambre necesario para dar 3 vueltas al terreno */
    public static void imprimirPerimetroYAlambre(Terreno terreno){
        System.out.println("El perimetro es de "+terreno.perimetro()+" mts.");
        System.out.println("Necesitariamos "+(terreno.perimetro()*3)+" mts.");
    }
    /* Modulo que imprime la superficie y el costo de limpiarlo ($150xm^2) */
    public static void imprimirSuperficieYCostoLimpieza(Terreno terreno){
        System.out.println("La superficie es de "+terreno.superficie()+" mts^2");
        System.out.println("El costo de limpiar el terreno es de $"+(terreno.superficie()*150));
    }
    /* Modulo que muestra el valor del terreno segun el precio por m^2 ingresado por el usuario */
    public static void imprimirValorTerreno(Terreno terreno){
        Scanner scan = new Scanner (System.in);
        double precioMtCuadrado;
        do{
            System.out.println("Ingrese el valor del m^2 de terreno: ");
            precioMtCuadrado=scan.nextDouble();
            if(precioMtCuadrado<=0){
                System.out.println("ERROR: El precio no puede ser menor o igual a 0");
            }
        }while(precioMtCuadrado<=0);
        System.out.println("El valor del terreno es de $"+(terreno.superficie()*precioMtCuadrado));       
    }
}