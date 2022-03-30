/**
 *
 * @author JuanPadSch
 */
public class Ejercicio6 {
    /*Este programa permite almacenar letras en un arreglo, cuya dimensión máxima
    es 100. El algoritmo verifica que el caracter leído sea una letra antes de
    ser guardado. Al finalizar la carga, el algoritmo muestra la cantidad de
    letras guardadas en el arreglo*/
    public static void main(String[] args){
        char[] arrayLetras = new char[100];
        char letra;
        System.out.println("Ahora cargará el arreglo hasta que usted desee parar");
        System.out.println("ATENCIÓN: Solo puede cargar un máximo de cien letras");
        cargarArrayLetrasCien(arrayLetras);
    }
   /*Este módulo permite cargar un array, hasta que el espacio se agote 
    (máximo 100 letras), o hasta que el usuario desee parar*/
    public static void cargarArrayLetrasCien(char[] arrayLetras){
        int i=0;
        boolean seguir=true;
        String continuar;
        while (seguir==true && i<arrayLetras.length){
            System.out.println("Ingrese la letra del espacio "+i);
            arrayLetras[i]=charEsLetra(TecladoIn.readChar());
            System.out.println("Si desea continuar escriba SI, de lo contrario la carga finalizará");
            continuar=TecladoIn.readLine();
            if(continuar.toUpperCase()=="SI"){
                i++;
            } else{
                arrayLetras[i+1]=' ';
                seguir=false;
            }
        }
    }
    /*Este módulo comprueba de que el caracter ingresado sea una letra*/
    public static char charEsLetra(char charEle){
        boolean esLetra=false;
        char letra=charEle;
        while (esLetra==false){
            /*Hacemos una verificación de ASCII. De la A hasta la Z,
            los valores númericos van del 33 al 126 (incluidos)*/
            if (letra>=33 && letra<=126){
                esLetra=true;                
            } else{
                System.out.println("Eso no es una letra. Ingrese nuevamente: ");
                letra=TecladoIn.readChar();
            }
        }
        return letra;
    }
    //Este módulo cuenta la cantidad de letras guardads en el arreglo
    public static int cantLetras(char[] arrayLetras){
        int contador=0, i=0;        
        while (arrayLetras[i]!=' ' && i<arrayLetras.length){
            contador++;
            i++;
        }
        return contador;
    }
}
