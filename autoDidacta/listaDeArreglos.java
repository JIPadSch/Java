import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class listaDeArreglos {
    public static void main(String[] args) {
        ArrayList<String> primerListaArreglosStr = new ArrayList<>(); //Creamos un objeto ArrayList
        primerListaArreglosStr.add("Agregando un elemento"); //Agregamos un elemento
        System.out.println("Mostramos el primer elemento: "+primerListaArreglosStr.get(0)); //Probamos que funciona
        primerListaArreglosStr.add("Mas elementos");
        primerListaArreglosStr.add("Aguante lista de arreglos");
        System.out.println(primerListaArreglosStr.size()); //Vemos el tamaño de la lista
        primerListaArreglosStr.remove(1); //Sacamos el elemento en posicion 1, o sea, "Mas elementos"
        System.out.println(primerListaArreglosStr.size()); //Vemos el tamaño de la lista nuevamente
        System.out.println(primerListaArreglosStr);
    }
}
