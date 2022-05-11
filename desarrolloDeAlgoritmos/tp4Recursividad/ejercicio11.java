package desarrolloDeAlgoritmos.tp4Recursividad;
/**
 *
 * @author JuanPadSch
 */
public class ejercicio11 {
    /*
    *  Diseñar e implementar un algoritmo recursivo que dado un arreglo de números realice dos
    *  sumas separadas, por un lado los números en las posiciones pares y por el otro las posiciones
    *  impares.
    */
    public static void main(String[] args) {
        int[] sumaParImpar = new int[2]; //arr[0] = Par ; Pos 1 = Impar
    }
    /* Modulo recursivo */
    public static int sumaArreglosParImpar(int[] arrInt, int pos, int[] sumaParImpar){
        int sumaAux=0;
        if (pos<arrInt.length){ //Caso general
            if (pos%2 == 0){ //Si la posición es par
                sumaAux+=sumaArreglosParImpar(arrInt, pos+1,sumaParImpar);
                sumaParImpar[0]+=sumaAux;
            }else{ //Si la posición es impar
                sumaAux+=sumaArreglosParImpar(arrInt, pos+1,sumaParImpar);
                sumaParImpar[1]+=sumaAux;
            }
        } else{ //Caso base
            if(pos%2 == 0){
                sumaAux+=arrInt[pos];
                sumaParImpar[0]+=sumaAux;
            } else{
                sumaAux+=arrInt[pos];
                sumaParImpar[1]+=sumaAux;
            }
        }
        return sumaAux;
    }    
}