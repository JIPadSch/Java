package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.Random;
import libreriaJuanIPadSch.*;
/**
 *
 * @author JuanPadSch
 */
private class ejercicio6 {
    /*
    *  Diseñar e implementar un algoritmo recursivo para obtener el número
    *  mayor de un arreglo numérico.
    */
    public static void main(String[] args) {
        int arrInt[] = new int [8];
        int pos=0;
        arreglosUni.llenarArrIntAutoS(arrInt); //Llenamos el arreglo aleatoriamente con nros del -64 al 64
        arreglosUni.imprimirArrInt(arrInt);
        int resultado=numMayorArrIntRecursivo(arrInt,pos);
        System.out.println("El mayor número se encuentra en la posición "+(resultado+1)+" y es: "+arrInt[resultado]);
    }
    /* Modulo recursivo */
    public static int numMayorArrIntRecursivo(int[] arrInt, int pos){
        int posMayor=0, auxPos=0;
        if (pos<arrInt.length-1) {
            auxPos=numMayorArrIntRecursivo(arrInt, pos+1);
            if (arrInt[pos]>arrInt[auxPos]) {
                posMayor=pos;
            } else {
                posMayor=auxPos;
            }
        } else {
            posMayor=pos;
        }
        return posMayor;
    }
}