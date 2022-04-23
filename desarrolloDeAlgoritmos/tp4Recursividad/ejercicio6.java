package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.Random;

import libreriaJuanIPadSch.*;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio6 {
    /*
    *  Diseñar e implementar un algoritmo recursivo para obtener el número
    *  mayor de un arreglo numérico.
    */
    public static void main(String[] args) {
        int arrInt[] = new int [8];
        int pos=((arrInt.length)-1), posMayor=0;
        arreglosUni.llenarArrIntAutoS(arrInt); //Llenamos el arreglo aleatoriamente con nros del -64 al 64
        arreglosUni.imprimirArrInt(arrInt);
        int resultado=numMayorArrIntRecursivo(arrInt,pos,posMayor);
        System.out.println("El mayor número se encuentra en la posición "+resultado+" y es: "+arrInt[resultado]);
    }
    /* Modulo recursivo */
    public static int numMayorArrIntRecursivo(int[] arrInt, int pos, int posMayor){
        if (pos>=0){
            if(arrInt[pos]>arrInt[posMayor]){
                posMayor=numMayorArrIntRecursivo(arrInt,pos-1,pos);
            } else{
                numMayorArrIntRecursivo(arrInt,pos-1,posMayor);
            }
        }
        return posMayor;
    }
}
