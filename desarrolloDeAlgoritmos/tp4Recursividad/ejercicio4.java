package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio4 {
    /* Algoritmo recursivo que verifica si todos los dígitos de un número
    *  son iguales (por ejemplo si el número es 111 debe retornar true, 
    *  si el número es 12111 debe retornar false) 
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int numero;
        do{
            System.out.println("Ingrese un nuevo a verificar si todos son iguales: ");
            numero=scan.nextInt();
            if (numero<1) System.out.println("El numero debe ser mayor o igual a 1");
            scan.nextLine();
        }while(numero<1);
        System.out.println("En el numero "+numero+" los números ¿Son todos iguales?: "+todosNumIguales((numero)));
    }
    /* Metodo que verifica (dado un entero) que todos los numeros son iguales */
    public static boolean todosNumIguales(int num){
        boolean todoIgual=false;
        if(num<10){
            todoIgual=true;
        } else if((num%100)/10 == num%10){
            todoIgual=todosNumIguales(num/10);
        }
        return todoIgual;
    }
}