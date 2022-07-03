package libreriaJuanIPadSch;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author JuanPadSch
 */
public class Entrada {
    private static final Scanner scan = new Scanner(System.in);
    /*
     * @parameters
     * @return String
     */
    public static String leerLinea(){
        String lineaLeida = "";
        try{
            lineaLeida = scan.nextLine();
        }catch(Exception e){
            System.err.println("Error inesperado");
        }
        scan.close();
        return lineaLeida;
    }
    /*
     * @parameters 
     * @return int
     */
    public static int leerEntero(){
        int enteroLeido = 0;
        do{
            try{
            enteroLeido = scan.nextInt();
            }catch(InputMismatchException e){
                System.err.println("Eso no es un número o se fue del rango posible en Java");
                System.out.println("Ingrese nuevamente el valor deseado");
            }
        }while();
        return enteroLeido;
    }
}
