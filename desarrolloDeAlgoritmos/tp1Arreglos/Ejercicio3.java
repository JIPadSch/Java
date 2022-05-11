package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio3 {
    /*El algoritmo, dado un entero y un arreglo, reemplaza los valores en las
    posiciones pares del arreglo por el valor dado y luego muestra el arreglo*/
    public static void main(String[] args){
        int num;
        int[] arrayDeEnt = new int [10];
        System.out.println("Llene el arreglo (contiene 10 espacios): ");
        llenarArrInt(arrayDeEnt);
        System.out.println("Ahora ingrese el número por el cual desea cambiar las posiciones pares del arreglo: ");
        num=TecladoIn.readLineInt();
        cambiarPosPar(arrayDeEnt,num);
        System.out.println("A continuación se mostrará el arreglo ordenado por posición: ");
        mostrarArrayOrdenadoInt(arrayDeEnt);
    }
     //Este módulo permite cargar un arreglo de enteros
    public static void llenarArrInt(int[] arrayDeInt){
        int i;
        for (i=0;i<arrayDeInt.length;i++){
            System.out.println("Cargue el número de la posición "+(i+1)+" del arreglo");
            arrayDeInt[i]=TecladoIn.readLineInt();
        }
    }
    //Este módulo pone el valor N dado en las posiciones pares del arreglo
    public static void cambiarPosPar(int[] arrayDeEnt, int num){
        int i;
        for (i=0;i<arrayDeEnt.length;i++){
            if (i%2==0){
                arrayDeEnt[i]=num;
            }
        }
    }
    //Este módulo muestra un arreglo de enteros de manera ordenada
    public static void mostrarArrayOrdenadoInt(int[] arrayDeInt){
        int i;
        for (i=0;i<arrayDeInt.length;i++){
            System.out.print(" "+arrayDeInt[i]+" ");
        }
    }
}
