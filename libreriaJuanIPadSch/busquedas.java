package libreriaJuanIPadSch;
/**
 *
 * @author JuanPadSch
 */
public class busquedas {
    /* Método de Búsqueda Secuencial */   
    public static int secuencialInts(int[] arrInt, int valorBuscado){
        boolean encontrado = false;
        int i = 0, pos = -1;
        while (i<arrInt.length && !encontrado){
            if(arrInt[i] == valorBuscado){
                pos = i;
                encontrado = true;
            }
            i++;
        }
        return pos; //Retorna la posición o -1 si no lo encontró
    }
    /* Método de Búsqueda Secuencial de Adelante hacia Atrás */
    public static int secuencialAdelanteAtrasInts(int[] arrInt, int valorBuscado){
        boolean encontrado = false;
        int i = arrInt.length, pos = -1;
        while (i>=0 && !encontrado){
            if(arrInt[i] == valorBuscado){
                pos = i;
                encontrado = true;
            }
            i--;
        }
        return pos; //Retorna la posición o -1 si no lo encontró
    }
    /* Método de Búsqueda Binario */
    public static int binarioInts(int[] arrInt, int valorBuscado){
        boolean encontrado = false;
        int ini = 0, fin = arrInt.length-1, pos = -1, medio;
        while (ini<fin && !encontrado){
            medio = (ini+fin)/2;
            if(arrInt[medio] == valorBuscado){
                pos = medio;
                encontrado = true;
            }else{
                if(arrInt[medio] > valorBuscado){
                    fin = medio-1;
                }else{
                    ini = medio+1;
                }
            }
        }
        return pos; //Retorna la posición o -1 si no lo encontró
    }
    /* Método de Búsqueda Binario Decreciente */
    public static int binarioDecrecienteInts(int[] arrInt, int valorBuscado){
        boolean encontrado = false;
        int ini = 0, fin = arrInt.length-1, pos = -1, medio;
        while (ini<fin && !encontrado){
            medio = (ini+fin)/2;
            if(arrInt[medio] == valorBuscado){
                pos = medio;
                encontrado = true;
            }else{
                if(arrInt[medio] < valorBuscado){
                    ini = medio+1;
                }else{
                    fin = medio-1;
                }
            }
        }
        return pos; //Retorna la posición o -1 si no lo encontró
    }
}