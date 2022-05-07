package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
private class Ejercicio1 {
    /*Este algoritmo nos permite cargar un arreglo de caractéres y luego mostrarlo de manera
    ordenada o invertida, según lo que elija el usuario*/
    public static void main(String[] args) {
        int elegirMostrar=0;
        System.out.println("Escriba cuantos caractéres desea que posea el arreglo: ");
        char[] arrayDeCarac = new char [TecladoIn.readLineInt()];
        llenarArrChar(arrayDeCarac);
        System.out.println("Si desea ver el arreglo en el orden ingresado, escriba 1, de lo contrario, se mostrará invertido: ");
        elegirMostrar=TecladoIn.readLineInt();
        if (elegirMostrar==1){
            mostrarArrayOrdenado(arrayDeCarac);
        } else{
            mostrarArrayInvertido(arrayDeCarac);
        }
    }
    //Este módulo nos permite llenar un arreglo de caractéres
    public static void llenarArrChar(char[] arrayDeCarac){
        int i;
        for (i=0;i<arrayDeCarac.length;i++){
            System.out.println("Cargue el caractér nro. "+(i+1)+" del arreglo");
            arrayDeCarac[i]=TecladoIn.readChar();
        }
}
    //Este módulo muestra un arreglo de caractéres de manera ordenada
    public static void mostrarArrayOrdenado(char[] arrayDeCarac){
        int i;
        for (i=0;i<arrayDeCarac.length;i++){
            System.out.print(" "+arrayDeCarac[i]+" ");
        }
    }
    //Este módulo muestra un arreglo de caractéres de manera invertida
    public static void mostrarArrayInvertido(char[] arrayDeCarac){
        int i;
        for (i=arrayDeCarac.length;i>0;i--){
            System.out.print(" "+arrayDeCarac[i]+" ");
        }        
    }
}


