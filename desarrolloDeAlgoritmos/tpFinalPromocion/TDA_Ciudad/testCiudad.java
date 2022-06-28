package desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad;
import java.util.*;
import java.io.*;
/**
 *
 * @author JuanPadSch
 */
public class testCiudad {
    public static void main(String[] args) {
        Ciudad[] arrCiudad = new Ciudad[100];
    }
    /* Metodo clonar que clona un arreglo de ciudades */
    public static Ciudad[] clonarOrdenarArrCiudad(Ciudad[] arrCiudad){
        Ciudad[] nuevoArrCiudadOrd = new Ciudad[100];
        for (int i = 0; i < nuevoArrCiudadOrd.length; i++) {
            nuevoArrCiudadOrd[i] = arrCiudad[i];
        }
        char metodoElegido = eleccionDeMetodo();
        switch(metodoElegido){ //Segun lo elegido, llamamos al metodo
            case 'a':
                metodosDeOrdenamientoCiudad.burbuja(nuevoArrCiudadOrd);
                break;
            case 'b':
                metodosDeOrdenamientoCiudad.insercion(nuevoArrCiudadOrd);
                break;
            case 'c':
                metodosDeOrdenamientoCiudad.seleccion(nuevoArrCiudadOrd);
                break;
        }
        return nuevoArrCiudadOrd;
    }
    /* Metodo utilizado para elegir con que metodo desea el usuario ordenar un arreglo */
    public static char eleccionDeMetodo(){
        Scanner sc = new Scanner (System.in);
        char eleccion = ' ';
        boolean corte = false;
        String opciones = "abcABC";
        while(!corte){ //Solo corta cuando el usuario ponga alguna de las opciones validas
            System.out.println("¿Mediante que método desea ordenar este arreglo?");
            System.out.println("a) Burbuja");
            System.out.println("b) Inserción");
            System.out.println("c) Selección");
            try{
                eleccion = sc.next().charAt(0);
            }catch(Exception e){
                System.out.println("ERROR: Input inválido. Eso no es un caracter");
            }
            if(opciones.indexOf(eleccion) > -1){ //Si la eleccion es correcta, cortamos
                corte = true;
            }else{ //Sino, tiramos error
                System.out.println("ERROR: Elija una opcion válida");
            }
        }
        sc.close();
        return eleccion;
    }
}