package programacionConcurrente.TrabajoPractico1;
import java.util.Scanner;

public class PruebaExcep {
    //Ejercicio 8

    //Punto a
    public static void edadValida() throws Exception{
        Scanner scan = new Scanner(System.in);
        int edad;
        System.out.println("Ingrese una edad");
        edad = scan.nextInt();
        if (edad < 18) throw new Exception("Es menor de edad");
    }

    //Punto b
    public static void ruleta() throws Exception{
        Scanner scan = new Scanner(System.in);
        int ruleta;
        System.out.println("Ingrese un nro del 1 al 10");
        ruleta = scan.nextInt();
        if (ruleta != (Math.random()*10)) throw new Exception("No acerto");
    }

    //Punto c
    public static void coleccion() throws Exception{

        Scanner scan = new Scanner(System.in);
        int[] col = new int[5];

        for (int i = 0; i < col.length; i++) {
            System.out.println("Ingrese un nro para la posicion: "+(i+1));
            col[i] = scan.nextInt();
        }

        try{

            for (int i = 0; i < 7; i++) {
                System.out.println(col[i]);
            }

        }catch (Exception e){

        }
    }
    
}
