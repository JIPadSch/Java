package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
private class Ejercicio4 {
    /*Este programa nos permite encontrar el valor más grande y el más
    pequeño dentro de un arreglo dado*/
    public static void main (String[] args){
        int[] arrayInt = {3,5,7,1,19,6};
        System.out.println("El número más grande en el arreglo es: "+buscarMayorArr(arrayInt));
        System.out.println("El número más pequeño en el arreglo es: "+buscarMenorArr(arrayInt));
    }
    //Este módulo busca dentro del arreglo el número más grande
    public static int buscarMayorArr(int[] arrayInt){
        int i, numMayor=0;
        for(i=0;i<arrayInt.length;i++){
            if(arrayInt[i]>numMayor){
                numMayor=arrayInt[i];
            }
        }
        return numMayor;
    }
    //Este módulo busca dentro del arreglo el número más pequeños
    public static int buscarMenorArr(int[] arrayInt){
        int i, numMenor=999;
        for(i=0;i<arrayInt.length;i++){
            if(arrayInt[i]<numMenor){
                numMenor=arrayInt[i];
            }
        }        
        return numMenor;
    }
}
