//package autoDidacta;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class adivinaElNumeroTemporizado{
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Random randomNum = new Random();
        int numAle = randomNum.nextInt(100) + 1, adivinanzaJugador, cantIntentos=0;
        do{
            System.out.println("Escriba un numero del 1 al 100: ");
            adivinanzaJugador = scan.nextInt();
            scan.nextLine(); //Limpiando el Scanner
            cantIntentos++; //Contamos la cantidad de veces que intentaron adivinar el numero
            if (numAle>adivinanzaJugador) System.out.println("El número es mayor! Inténtelo denuevo");
            if (numAle<adivinanzaJugador) System.out.println("El número es menor! Inténtelo denuevo");
        }while (adivinanzaJugador != numAle);
        System.out.println("FELICIDADES! ADIVINASTE CORRECTAMENTE! Tu cantidad de intentos fueron: "+cantIntentos);
        scan.close();
    }    
}