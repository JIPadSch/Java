package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
private class Ejercicio5 {
   //Este programa calcula el promedio de los valores almacenados en un arreglo 
   public static void main(String[] args){
       int[] arrayInt = {3,5,7,1,19,6};              
       System.out.println("El promedio de todos los valores del arreglo es: "+promedioArrInt(arrayInt));
   }
   //Este módulo saca el promedio de los valores dentro de un arreglo
   public static int promedioArrInt(int[] arrayInt){
       int i, promedio=0;
       for (i=0;i<arrayInt.length;i++){
           promedio+=arrayInt[i];
       }
       return (promedio/arrayInt.length);
   }    
}
