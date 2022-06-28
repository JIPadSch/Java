package desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad.src;
import desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad.Ciudad;
/**
 *
 * @author JuanPadSch
 */
public class metodosDeOrdenamientoCiudad {
    /* ME TOCO EL METODO DE SELECCION (1646 % 3 = 2) */

    /* MENOR A MAYOR (ASCENDENTE) */
    /* Método de Ordenamiento Selección */
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
    public static int buscarMenor(int i, Ciudad[] arrCiudad){
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
    /* Módulo que realiza el intercambio del Método Selección */
    public static void intercambioSeleccionCiudad(int i, int j, Ciudad[] arrCiudad){
        Ciudad aux = arrCiudad[i];
        arrCiudad[i] = arrCiudad[j];
        arrCiudad[j] = aux;
    }

    /* MAYOR A MENOR (DESCENDENTE) */
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
    /* Módulo que busca el menor del Método Selección */
    public static int buscarMayor(int i, Ciudad[] arrCiudad){
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
}