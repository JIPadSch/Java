package desarrolloDeAlgoritmos.tp1Arreglos;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class Ejercicio16 {
    /*El programa verifica que dado un arreglo de String, tenga almenos una
    longitud de 5, y que cada String posea solo letras, caso contrario, dicho String
    queda eliminado del arreglo y es reemplazado por el de la siguiente posición.
    Al finalizar se imprime por pantalla el resutlado*/
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);
        String[] arrString;
        int longArr=0;
        while (longArr<5){
            System.out.println("Ingrese la longitud del arreglo (mínimo 5): ");
            longArr=scan.nextInt();
            scan.nextLine();
            if (longArr<5){
                System.out.println("ERROR: La longitud debe ser almenos 5");
            }
        }
        arrString = new String [longArr];
        llenarArrayString(arrString);
        reemplazarStrSoloLetras(arrString);
        mostrarArrayString(arrString);
    }
    /*Este módulo nos permite llenar un arreglo de String*/
    public static void llenarArrayString (String[] arrString){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrString.length;i++){
            arrString[i]=scan.nextLine();
            scan.nextLine();
        }
    }
    /*Este módulo verifica que los Strings del array posean solo letras, caso
    contrario el String de ese lugar es reemplazado por el siguiente String
    y luego vaciamos la siguiente posición*/
    public static void reemplazarStrSoloLetras (String[] arrString){
        int i;
        for (i=0;i<arrString.length;i++){
            int j=0;
            boolean movido=false;
            while (j<arrString[i].length() && movido==false){
                if (charEsLetra(arrString[i].charAt(j)) == false){
                    /*Verificamos que no nos pasemos de los límites del Array y borramos
                    el String en caso de ser necesario*/
                    if (i+1==arrString.length){
                        arrString[i]="";
                    } else{
                        //Reemplazamos el String
                        arrString[i]=arrString[i+1];
                        //Vaciamos el siguiente espacio
                        arrString[i+1]="";
                        movido=true;
                    }
                } else{
                    j++;
                }
            }
        }
    }
    /*Este módulo nos dice si el caracter ingresado por parámetro es una letra*/
    public static boolean charEsLetra(char caracter){
        boolean esLetra=false;
        /*Hacemos una verificación de ASCII. De la A hasta la Z,
        los valores númericos van del 33 al 126 (incluidos)*/
        if (caracter>=33 && caracter<=126){
            esLetra=true;                
        }
        return esLetra;
    }
    /*Este módulo nos muestra el arreglo en pantalla*/
    public static void mostrarArrayString (String[] arrStr){
        int i;
        for (i=0;i<arrStr.length;i++){
            System.out.println(" "+arrStr[i]+" ");
        }
    }
}