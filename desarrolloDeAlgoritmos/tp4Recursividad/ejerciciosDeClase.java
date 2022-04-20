package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejerciciosDeClase {
    /* Main para invocar los módulos */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("Ingrese un número para mostrar su factorial: ");
            n=scan.nextInt();
            if (n<1) System.out.println("El número ingresado debe ser mayor o igual a 1");
            scan.nextLine();
        }while (n<1);
        System.out.println("El factorial de "+n+" es :"+factorial(n));
        do{
            System.out.println("Ingrese el número que desea ver en Fibonacci: ");
            n=scan.nextInt();
            if (n<1) System.out.println("El número ingresado debe ser mayor o igual a 1");
            scan.nextLine();
        }while(n<1);
        System.out.println("El Fibonacci de "+n+" es: "+fibonacci(n));
    }
    /* Método para sacar factorial */
    public static int factorial(int n){
        int resultado;
        if (n==1){
            resultado=1;
        } else{
            resultado=n*factorial(n-1);
        }
        return resultado;
    }
    /* Metodo para sacar Fibonacci */
    public static int fibonacci(int n){
        int resultado;
        if(n==0){
            resultado=0;
        }else if(n==1){
            resultado=1;
        } else {
            resultado=fibonacci(n-2)+fibonacci(n-1);
        }
        return resultado;
    }
    /* Metodo para contar las iteraciones dentro de un numero */
    public int contarT(int n, int t){
        int contadorT=0;
        if (n!=0){
            if(n%10==t){
                contadorT=contarT(n/10, t)+1;
            } else{
                contadorT=contarT(n/10, t);
            }
        }
        return contadorT;
    }
}