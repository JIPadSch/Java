package desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad.src;
import desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad.Ciudad;
/**
 *
 * @author JuanPadSch
 */
public class metodosDeOrdenamientoCiudad {
    /* ME TOCO EL METODO DE SELECCION (1646 % 3 = 2) */

    /* MENOR A MAYOR (ASCENDENTE) */
    /* Método de Ordenamiento Selección Ascendente */
    public static void seleccionCiudadAscendente(Ciudad[] arrCiudad){
        int i, posMenor;
        
        for (i = 0; i < arrCiudad.length; i++) {
            posMenor = buscarMenor(i,arrCiudad);
            if(arrCiudad[posMenor].compareTo(arrCiudad[i].getNombre()) > 0){
                //O sea, que si la palabra en pos menor tiene prioridad realizamos el intercambio
                intercambioSeleccionCiudad(i, posMenor, arrCiudad);
            }
        }
        
    }
    /* Módulo que busca el menor del Método Selección */
    private static int buscarMenor(int i, Ciudad[] arrCiudad){
        String menor = arrCiudad[i].getNombre();
        int posMenor = i;

        for (i=i; i < arrCiudad.length; i++) {
            if(arrCiudad[posMenor].compareTo(arrCiudad[i].getNombre()) < 0){
                //Si la palabra en "i" es menor a la que tenemos guardada, cambiamos el menor
                menor = arrCiudad[i].getNombre();
                posMenor = i;
            }            
        }

        return posMenor;
    }

    /* MAYOR A MENOR (DESCENDENTE) */
    /* Metodo de Ordenamiento Selección Descendente */
    public static void seleccionCiudadDescendente(Ciudad[] arrCiudad){
        int i, posMayor;

        for (i = 0; i < arrCiudad.length; i++) {
            posMayor = buscarMayor(i,arrCiudad);
            if(arrCiudad[posMayor].compareTo(arrCiudad[i].getNombre()) > 0){
                //O sea, que si la palabra en pos mayor tiene prioridad realizamos el intercambio
                intercambioSeleccionCiudad(i, posMayor, arrCiudad);
            }
        }

    }
    /* Módulo que busca el mayor del Método Selección */
    private static int buscarMayor(int i, Ciudad[] arrCiudad){
        String mayor = arrCiudad[i].getNombre();
        int posMayor = i;

        for (i=i; i < arrCiudad.length; i++) {
            if(arrCiudad[posMayor].compareTo(arrCiudad[i].getNombre()) > 0){
                //Si la palabra en "i" es menor a la que tenemos guardada, cambiamos el menor
                mayor = arrCiudad[i].getNombre();
                posMayor = i;
            }
        }

        return posMayor;
    }

    /* MODULO UTILIZADO POR LOS 2 METODOS DE SELECCION */
    /* Módulo que realiza el intercambio del Método Selección */
    private static void intercambioSeleccionCiudad(int i, int j, Ciudad[] arrCiudad){
        Ciudad aux = arrCiudad[i];
        arrCiudad[i] = arrCiudad[j];
        arrCiudad[j] = aux;
    }

    
    /* METODO DE ORDEN n log(n) ELEGIDO: QUICKSORT (opcion b) */
    /* Guia utilizada para crear los metodos quickSort: https://www.baeldung.com/java-quicksort */

    /* MENOR A MAYOR (ASCENDENTE) */

    /* Metodo de Ordenamiento QuickSort Ascendente */
    public static void quickSortAscendente(Ciudad[] arrCiudad, int ini, int fin){
        if(ini < fin){
            int indexParticion = particionAscendente(arrCiudad,ini,fin);
            quickSortAscendente(arrCiudad, ini, (indexParticion-1));
            quickSortAscendente(arrCiudad,(indexParticion+1), fin);
        }
    }
    /* Modulo de particion de quickSort para el Metodo Ascendente */
    private static int particionAscendente(Ciudad[] arrCiudad, int ini, int fin){
        Ciudad pivote = arrCiudad[fin];
        int i = (ini-1);

        for (int j = ini; j < fin; j++) {
            if(arrCiudad[j].compareTo(pivote.getNombre()) >= 0 ){ //Si arrCiudad[j] tiene prioridad
                i++;
                Ciudad ciudadAux = arrCiudad[i];
                arrCiudad[i] = arrCiudad[j];
                arrCiudad[j] = ciudadAux;
            }
        }

        Ciudad ciudadAux = arrCiudad[(i+1)];
        arrCiudad[(i+1)] = arrCiudad[fin];
        arrCiudad[fin] = ciudadAux;

        return (i+1);
    }

    /* MAYOR A MENOR (DESCENDENTE) */

    /* Metodo de Ordenamiento Quicksort Descendente */
    public static void quickSortDescendente(Ciudad[] arrCiudad, int ini, int fin){
        if (ini < fin){
            int indexParticion = particionDescendente(arrCiudad, ini, fin);
            quickSortDescendente(arrCiudad, ini, (indexParticion-1));
            quickSortDescendente(arrCiudad, (indexParticion+1), fin);
        }
    }
    /* Modulo de particion de QuickSort para el Metodo Descendente */
    public static int particionDescendente(Ciudad[] arrCiudad, int ini, int fin){
        Ciudad pivote = arrCiudad[fin];
        int i = (ini-1);

        for (int j = ini; j < fin; j++) {
            if(arrCiudad[j].compareTo(pivote.getNombre()) < 0 ){ //Si arrCiudad[j] NO tiene prioridad
                i++;
                Ciudad ciudadAux = arrCiudad[i];
                arrCiudad[i] = arrCiudad[j];
                arrCiudad[j] = ciudadAux;
            }
        }

        Ciudad ciudadAux = arrCiudad[(i+1)];
        arrCiudad[(i+1)] = arrCiudad[fin];
        arrCiudad[fin] = ciudadAux;

        return (i+1);
    }
}