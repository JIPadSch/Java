package libreriaJuanIPadSch;
/**
 *
 * @author JuanPadSch
 */
public class metodosDeOrdenamiento {
    /* Método de Ordenamiento Selección */
    public static void seleccionInts(int[] arrInt){
        int i, posMenor;
        for (i = 0; i < arrInt.length; i++) {
            posMenor = buscarMenor(i,arrInt);
            if(arrInt[posMenor] < arrInt[i]){
                intercambioSeleccion(i, posMenor, arrInt);
            }
        }
    }
    /* Módulo que busca el menor del Método Selección */
    public static int buscarMenor(int i, int[] arrInt){
        int menor = arrInt[i], posMenor = i;
        for (i=i; i < arrInt.length; i++) {
            if(arrInt[i] < menor){
                menor = arrInt[i];
                posMenor = i;
            }            
        }
        return posMenor;
    }
    /* Módulo que realiza el intercambio del Método Selección */
    public static void intercambioSeleccion(int i, int posMenor, int[] arrInt){
        int aux = arrInt[i];
        arrInt[i] = arrInt[posMenor];
        arrInt[posMenor] = aux;
    }
    /* Método de Ordenamiento Burbuja */
    public static void burburjaInts(int[] arrInt){
        int i, j;
        for (i = 0; i < arrInt.length; i++) {
            for (j = 1; j < arrInt.length-i-1; j++) {
                if (arrInt[j] > arrInt[j+1]){
                    intercambioBurbuja(j,(j+1),arrInt);
                }
            }
        }
    }
    /* Módulo que reliza el intercambio del Método Burbuja */
    public static void intercambioBurbuja(int j, int j2, int[] arrInt){
        int aux = arrInt[j2]; //Guardamos el numero en j2
        arrInt[j2] = arrInt[j]; //El numero en j2 es cambiado por el de j
        arrInt[j] = aux; //El numero j2 lo ponemos en j
    }
    /* Método de Ordenamiento Burbuja Mejorado */
    public static void burbujaMejoradoInts(int[] arrInt){
        boolean ordenado = false;
        int i = 0;
        while ((i < arrInt.length) && !ordenado){
            ordenado = true;
            for (int j = 0; j < arrInt.length-i-1; j++) {
                if(arrInt[j] > arrInt[j+1]){
                    ordenado = false;
                    intercambioBurbuja(j,(j+1), arrInt);
                }
            }
            i++;
        }
    }
    /* Método de Ordenamiento Inserción */
    public static void insercionInts(int[] arrInt){
        int i,j,aux;
        for (i = 1; i < arrInt.length; i++) {
            aux = arrInt[i];
            j = i;
            while(j>0 && arrInt[j-1] > aux){
                arrInt[j] = arrInt[j-1];
                j--;
            }
            arrInt[j] = aux;
        }
    }
}