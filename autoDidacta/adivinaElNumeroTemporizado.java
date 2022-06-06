package autoDidacta;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class adivinaElNumeroTemporizado extends Thread{
    /* Este programa tiene de excusa al juego, el sentido es probar multi-threads y try-catchs */
    /* PRIMERO DECLARAMOS DOS CONSTANTES */
    public static boolean juegoTerminado=false;
    public static int tiempoSegundos = 0;
        /* Reemplazamos el metodo run() de Thread para crear nuestro temporizador */
        @Override
        public void run(){
            while(!juegoTerminado){ //Mientras no se haya terminado el juego
                tiempoSegundos++; //Suma 1 cada 1 segundo
                try {
                    Thread.sleep(1000); //Aca es donde esperamos 1 segundo para seguir sumando
                } catch (Exception e) {
                    //Excepcion vacia, sirve para que no nos tire error el Thread.sleep()
                }
            }
        }
    public static void main(String[] args) {
        try{
            juegoAdivinaElNumero();
        }catch(NumberFormatException nfe){
            System.out.println("Probando el multi-catch");
        }catch (Exception e){ //Atrapamos errores inesperadoes
            System.out.println("ERROR INESPERADO");
        }finally{ //Codigo que SIEMPRE, SIEMPRE (incluso si hay un return) se va a ejecutar despues del try-catch, haya habido Exception o no 
            System.out.println("Fin del juego"); //Si tenemos un return en finally, SIEMPRE pisa el return que tengamos antes
        }
}
/* Modulo donde esta el juego */
    public static void juegoAdivinaElNumero(){
        Scanner scan = new Scanner (System.in);
        Random randomNum = new Random();
        int numAle = randomNum.nextInt(100) + 1, adivinanzaJugador=0, cantIntentos=0;
        adivinaElNumeroTemporizado temporizador = new adivinaElNumeroTemporizado();
        temporizador.start();
        do{
            try{
                System.out.println("Escriba un numero del 1 al 100: ");
                adivinanzaJugador = scan.nextInt();
                scan.nextLine(); //Limpiando el Scanner
                cantIntentos++; //Contamos la cantidad de veces que intentaron adivinar el numero
                if (numAle>adivinanzaJugador) System.out.println("El número es mayor! Inténtelo denuevo");
                if (numAle<adivinanzaJugador) System.out.println("El número es menor! Inténtelo denuevo");
            }catch (Exception e){ //Si el usuario pone otra cosa que no sea un número en el Scanner, atrapamos el error
                System.out.println("ERROR: Ingrese un número");
            }            
        }while (adivinanzaJugador != numAle);
        juegoTerminado=true;
        System.out.println("FELICIDADES! ADIVINASTE CORRECTAMENTE! Tu cantidad de intentos fueron: "+cantIntentos+"\nTardaste "+tiempoSegundos+" segundos");
        scan.close();
    }
}