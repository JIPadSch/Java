package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio11 {
    //Este algoritmo nos permite cargar dos arreglos de números y luego verifica si son iguales o no
    public static void main(String[] args){
        int[] array1, array2;
        int cantElem;
        System.out.println("¿Cuantos elementos desea que contengan los arreglos?: ");
        cantElem=TecladoIn.readLineInt();
        array1=new int [cantElem];
        array2=new int [cantElem];
        System.out.println("A continuación cargará los datos del primer arreglo");
        llenarArrInt(array1);
        System.out.println("A continuación cargará los datos del segundo arreglo");
        llenarArrInt(array2);
        System.out.println("Los arreglos, ¿son iguales? "+sonIguales(array1,array2));        
    }
    //Este módulo permite cargar un arreglo de enteros
    public static void llenarArrInt(int[] arrayDeInt){
        int i;
        for (i=0;i<arrayDeInt.length;i++){
            System.out.println("Cargue el número de la posición "+(i+1)+" del arreglo");
            arrayDeInt[i]=TecladoIn.readLineInt();
        }
    }
    //Este módulo verifica si dos arreglos de enteros son iguales y retorna true o false, según corresponda
    public static boolean sonIguales(int[] array1, int[] array2){
        int i=0;
        boolean sonIguales=true;
        while (sonIguales==true && i<array1.length){
            if (array1[i]==array2[i]){
                i++;
            } else{
                sonIguales=false;
            }
        }
        return sonIguales;
    }
}
