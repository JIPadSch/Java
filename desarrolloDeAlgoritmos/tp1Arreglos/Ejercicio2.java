package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
private class Ejercicio2 {
    /*Este algoritmo lee un valor entero y genera un arreglo con los
    10 primeros múltiplos del mismo*/
    public static void main(String[] args){
        int[] arrNumMult = new int [10];
        int i, num=0;
        System.out.println("Escriba que número desea que se multiplique: ");
        num=TecladoIn.readLineInt();
        llenarArrMult(arrNumMult,num);
        System.out.println("Ahora se mostrará el arreglo ordenado: ");
        for (i=0;i<10;i++){
            System.out.println(" "+arrNumMult[i]+" ");
        }
    }
    //Este módulo llena el array con los 10 primeros múltiplos de num
    public static void llenarArrMult(int[] arrNumMult, int num){
        int i, multi=1;
        for (i=0;i<10;i++){
            arrNumMult[i]=num*multi;
            multi++;
        }
    }
    
}
