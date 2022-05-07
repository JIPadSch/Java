package desarrolloDeAlgoritmos.tp1Arreglos;
/**
 *
 * @author JuanPadSch
 */
private class Ejercicio12 {
    /*Este algoritmo nos permite cargar un arreglo de caractéres y luego realiza
    una copia de un arreglo de igual tamaño*/
    public static void main(String[] args){
        char[] arrayChar, copiaArrChar;
        System.out.println("Ingrese el tamaño deseado para su arreglo de caractéres: ");
        arrayChar = new char [TecladoIn.readLineInt()];
        System.out.println("Ahora cargará su nuevo arreglo");
        llenarArrChar(arrayChar);
        copiaArrChar = new char [arrayChar.length];
        copiaArrChar = copiarArrChar(arrayChar);
        libJuanIPadSch.imprimirArrChar(copiaArrChar);
    }
    //Este módulo nos permite llenar un arreglo de caractéres
    public static void llenarArrChar(char[] arrayDeCarac){
        int i;
        for (i=0;i<arrayDeCarac.length;i++){
            System.out.println("Cargue el caractér nro. "+(i+1)+" del arreglo");
            arrayDeCarac[i]=TecladoIn.readChar();
        }
}
    //Este módulo copia un arreglo de caractéres y devuelve dicha copia
    public static char[] copiarArrChar(char[] arrayChar){
        char[] copiaArrChar = new char [arrayChar.length];
        int i;
        for (i=0;i<arrayChar.length;i++){
            copiaArrChar[i]=arrayChar[i];
        }        
        return copiaArrChar;
    }
}
