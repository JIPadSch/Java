package desarrolloDeAlgoritmos.tpFinalPromocion.src;
/**
 *
 * @author JuanPadSch
 */
public class metodosDeOrdenamientoCiudad {
    /* PUNTOS 3 Y 5 */
    /* ME TOCO EL METODO DE SELECCION (1646 % 3 = 2) */

    /* MENOR A MAYOR (ASCENDENTE) */
    /* Método de Ordenamiento Selección Ascendente */
    public static void seleccionCiudadDescendente(Ciudad[] arrCiudad){
        int i, posMayor;
        
        for (i = 0; i < arrCiudad.length; i++) {
            posMayor = buscarMayor(i,arrCiudad);
            if(arrCiudad[posMayor].compareTo(arrCiudad[i].getNombre()) > 0){
                //O sea, que si la palabra en pos menor tiene prioridad realizamos el intercambio
                intercambioSeleccionCiudad(i, posMayor, arrCiudad);
            }
        }
        
    }
    /* Módulo que busca el menor del Método Selección */
    private static int buscarMayor(int i, Ciudad[] arrCiudad){
        String mayor = arrCiudad[i].getNombre();
        int posMayor = i;

        for (i=i; i < arrCiudad.length; i++) {
            if(arrCiudad[posMayor].compareTo(arrCiudad[i].getNombre()) < 0){
                //Si la palabra en "i" es menor a la que tenemos guardada, cambiamos el menor
                mayor = arrCiudad[i].getNombre();
                posMayor = i;
            }            
        }

        return posMayor;
    }

    /* MAYOR A MENOR (DESCENDENTE) */
    /* Metodo de Ordenamiento Selección Descendente */
    public static void seleccionCiudadAscendente(Ciudad[] arrCiudad){
        int i, posMenor;

        for (i = 0; i < arrCiudad.length; i++) {
            posMenor = buscarMenor(i,arrCiudad);
            if(arrCiudad[posMenor].compareTo(arrCiudad[i].getNombre()) < 0){
                //O sea, que si la palabra en pos mayor tiene prioridad realizamos el intercambio
                intercambioSeleccionCiudad(i, posMenor, arrCiudad);
            }
        }

    }
    /* Módulo que busca el mayor del Método Selección */
    private static int buscarMenor(int i, Ciudad[] arrCiudad){
        String menor = arrCiudad[i].getNombre();
        int posMenor = i;

        for (i=i; i < arrCiudad.length; i++) {
            if(arrCiudad[posMenor].compareTo(arrCiudad[i].getNombre()) > 0){
                //Si la palabra en "i" es menor a la que tenemos guardada, cambiamos el menor
                menor = arrCiudad[i].getNombre();
                posMenor = i;
            }
        }

        return posMenor;
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
    public static void quickSortDescendente(Ciudad[] arrCiudad, int ini, int fin){
        if(ini < fin){
            int indexParticion = particionDescendente(arrCiudad,ini,fin);
            quickSortDescendente(arrCiudad, ini, (indexParticion-1));
            quickSortDescendente(arrCiudad, (indexParticion+1), fin);
        }
    }
    /* Modulo de particion de quickSort para el Metodo Ascendente */
    private static int particionDescendente(Ciudad[] arrCiudad, int ini, int fin){
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
    public static void quickSortAscendente(Ciudad[] arrCiudad, int ini, int fin){
        if (ini < fin){
            int indexParticion = particionAscendente(arrCiudad, ini, fin);
            quickSortAscendente(arrCiudad, ini, (indexParticion-1));
            quickSortAscendente(arrCiudad, (indexParticion+1), fin);
        }
    }
    /* Modulo de particion de QuickSort para el Metodo Descendente */
    private static int particionAscendente(Ciudad[] arrCiudad, int ini, int fin){
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

    /* METODOS MERGESORT Y HEAPSORT */
    /* Fueron creados para poder hacer calculos empiricos sobre la velocidad de los algoritmos */

    /* Metodo de Ordenamiento MergeSort */
    /* Guia utilizada para crear el meotod mergeSort: https://www.baeldung.com/java-merge-sort */
    public static void mergeSort(Ciudad[] arrCiudad, int longitud){
        if(longitud >= 2){
            int medio = longitud/2;
            Ciudad[] izq = new Ciudad[medio];
            Ciudad[] der = new Ciudad[(longitud-medio)];
    
            for (int i = 0; i < medio; i++) {
                izq[i] = arrCiudad[i];
            }
            for (int i = medio; i < longitud; i++) {
                der[(i-medio)] = arrCiudad[i];
            }
    
            mergeSort(arrCiudad, medio);
            mergeSort(arrCiudad, (longitud-medio));
    
            merge(arrCiudad, izq, der, medio, (longitud-medio));
        }
    }
    /* Modulo utilizado en el Metodo mergeSort */
    private static void merge(Ciudad[] arrCiudad,Ciudad[] izq,Ciudad[] der, int izquierda, int derecha){
        int i = 0, j = 0, k = 0;

        while(i < izquierda && j < derecha){
            if(izq[i].compareTo(der[j].getNombre()) <= 0){
                arrCiudad[k++] = izq[i++];
            }else{
                arrCiudad[k++] = der[j++];
            }
        }

        while(i < izquierda){
            arrCiudad[k++] = izq[i++];
        }

        while(j < derecha){
            arrCiudad[k++] = der[j++];
        }
    }

    /* Metodo de Ordenamiento HeapSort */
    /* Guia utilizada para crear el metodo heapSort: https://stackabuse.com/heap-sort-in-java/ */
    public static void heapSort(Ciudad[] arrCiudad){
        int longitud = (arrCiudad.length-1);
        
        for (int i = longitud/2-1 ; i >= 0; i--) {
           heapify(arrCiudad,longitud,i);
        }

        for (int i = longitud-1; i > 0; i--) {
            Ciudad ciudadAux = arrCiudad[0];
            arrCiudad[0] = arrCiudad[i];
            arrCiudad[i] = ciudadAux;
            heapify(arrCiudad, i, 0);
        }
    }
    /* Modulo utilizado en el Metodo heapSort */
    private static void heapify(Ciudad[] arrCiudad, int longitud, int i){
        int izq = 2*i+1;
        int der = 2*i+2;
        int masGrande = i;
        if(izq < longitud && arrCiudad[izq].compareTo(arrCiudad[der].getNombre()) > 0){
            masGrande = izq;
        }
        if(der < longitud && arrCiudad[der].compareTo(arrCiudad[masGrande].getNombre()) > 0){
            masGrande = der;
        }
        if(masGrande != i){
            Ciudad ciudadAux = arrCiudad[i];
            arrCiudad[i] = arrCiudad[masGrande];
            arrCiudad[masGrande] = ciudadAux;
            heapify(arrCiudad, longitud, masGrande);
        }
    }
}