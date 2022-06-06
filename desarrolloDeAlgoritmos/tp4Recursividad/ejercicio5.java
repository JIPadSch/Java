package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio5 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que lea una secuencia de dígitos (en cada llamada
    *  recursiva debe leer un número) y cuente cuántos son múltiplos de 3 hasta que se ingrese el 
    *  valor 0
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int digitos;
        System.out.println("--------------------------------");
        System.out.println("COMO CREIA QUE ERA EL EJERCICIO: ");
        System.out.println("--------------------------------");
        do{
            System.out.println("Ingrese el número a contar cuantos de los dígitos son multiplos de 3: ");
            digitos = scan.nextInt();
            if(digitos<=0) System.out.println("ERROR: El numero no puede ser menor o igual a 0");
        }while(digitos<=0);
        System.out.println("En el número "+digitos+" hay "+contarMult3(digitos)+" numeros multiplos de 3");
        System.out.println("--------------------------------");
        System.out.println("COMO ES EL EJERCICIO REALMENTE: ");
        System.out.println("--------------------------------");
        int contador = contar3();
        System.out.println("Usted escribió "+contador+" números múltiplos de 3");
        scan.close();
    }
    /* Modulo que dado un digito cuenta cuantos de los numeros multiplos de 3 */
    public static int contarMult3(int digitos){
        int contador=0;
        if (digitos==0){
            contador = 0;
        } else if((digitos%10)%3 == 0){
            contador=contarMult3(digitos/10)+1;
        } else{
            contador=contarMult3(digitos/10);
        }
        return contador;
    }
    /* 
    *  Modulo que pide un digito y luego evalua si es multiplo de 3, si es asi, suma 1.
    *  Al final retorna cuantas veces se ingreso un numero multiplo de 3 
    */
    public static int contar3(){
        Scanner scan = new Scanner(System.in);
        int contador=0, num;
        System.out.println("Ingrese un valor: ");
        num = scan.nextInt();
        if(num!=0){
            if(num%3==0){
                contador=contar3()+1;
            } else{
                contador=contar3();
            }
        } else{
            contador = 0;
        }
        scan.close();
        return contador;
    }
}