package desarrolloDeAlgoritmos.tpFinalPromocion;
import desarrolloDeAlgoritmos.tpFinalPromocion.src.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author JuanPadSch
 */
public class testCiudad {
    /* 
     *  Algoritmo del TP Final y Promocion de Desarrollo de Algoritmos:
     *  Los puntos a desarrollar se pueden encontrar en el PDF "TP Final y de Promocion"
     */
    public static void main(String[] args) {
        Ciudad[] arrCiudad = new Ciudad[100];
        String debuggerScan = "", archivoInfoCiudades = "R:/Programación/gitHub/Java/desarrolloDeAlgoritmos/tpFinalPromocion/src/ciudades.txt";
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        //Llenamos el arreglo de Ciudades con la información del .txt
        leerGuardarCiudadDesdeTxtAUnArray(arrCiudad, archivoInfoCiudades);
        //Inicio del loop del menu
        do{
                System.out.println("                                       MENU                                       ");
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println("1) Ver el arreglo de Ciudades original");
                System.out.println("2) Copia y ordena el arreglo de ciudades (eligirá como desea hacerlo)");
                System.out.println("3) Dada una posición del arreglo, se le mostrará el nombre de la ciudad abreviado");
                System.out.println("4) Verifica si 2 Ciudades tienen 2 letras iguales");
                System.out.println("5) Muestra la velocidad de los algoritmos de ordenamiento de manera empírica");
                System.out.println("6) Salir");
                System.out.println("-----------------------------------------------------------------------------------");
                debuggerScan = scan.nextLine(); //Decidi esta forma ya que try, catch me generaba error
                if(debuggerScan.matches("[1-6]")){
                    opcion = Integer.valueOf(debuggerScan);
                    menu(opcion, arrCiudad, scan);
                } else {
                    System.err.println("ERROR: Eso no es un número entre el 1 y el 5");
                }
        }while(opcion != 6);
        //Cerramos el Scanner una vez finalizamos de usarlo
        scan.close();
    }
    /* MENU */
    public static void menu(int opcion, Ciudad[] arrCiudad, Scanner scan){
        int num = 0, num2 = 0; //Variables utilizada en el metodo de menu con diversos usos
        switch(opcion){
            case 1:
                System.out.println("¿Desea ver el arreglo con toda la información o solo los nombres?");
                System.out.println("Si desea que sea COMPLETO elija 1");
                System.out.println("Si desea que sea SOLO NOMBRES elija 2");
                num = seleccionUnoDos(scan);
                if(num == 1){
                    mostrarArregloCiudades(arrCiudad);
                }else{
                    mostrarArregloCiudadesSoloNombres(arrCiudad);
                }
                break;
            case 2:
                Ciudad[] arrCiudadAux = copiarArrCiudad(arrCiudad);
                //Forma: 1)Descendente 2)Ascendente
                System.out.println("Si desea que sea de forma DESCENDENTE elija 1");
                System.out.println("Si desea que sea de forma ASCENDENTE elija 2");
                num = seleccionUnoDos(scan);
                //Tipo: 1)Seleccion 2)Quicksort)
                System.out.println("Si desea hacerlo con el metodo SELECCION elija 1");
                System.out.println("Si desea hacerlo con el metodo QUICKSORT elija 2");
                num2 = seleccionUnoDos(scan);
                ordenamientoArregloAux(arrCiudadAux,num,num2);
                //Ahora preguntamos como desea verlo, si con toda la info o solo los nombres
                System.out.println("¿Desea ver el arreglo con toda la información o solo los nombres?");
                System.out.println("Si desea que sea COMPLETO elija 1");
                System.out.println("Si desea que sea SOLO NOMBRES elija 2");
                int aux = seleccionUnoDos(scan);
                System.out.println("Asi queda el arreglo ordenado de manera "+(num==1 ? "DESCENDENTE":"ASCENDENTE")+" con el método "+(num2==1 ? "SELECCION":"QUICKSORT"));
                if(aux == 1){
                    mostrarArregloCiudades(arrCiudadAux);
                }else{
                    mostrarArregloCiudadesSoloNombres(arrCiudadAux);
                }
                break;
            case 3:
                num = elegirPosArregloValida(scan);
                num--; //Reducimos en uno para que este dentro del arreglo (que sea entre 1 y 100 es para el usuario)
                String nombreAbreviado = abreviaturaNombreRecursivo(arrCiudad[num].getNombre(), 0);
                System.out.println("El nombre abreviado de la ciudad: "+arrCiudad[num].getNombre()+"\nEs el siguiente: "+nombreAbreviado);
                break;
            case 4:
                System.out.println("Elija la posición de la 1ra Ciudad para compararla con la 2da:");    
                num = elegirPosArregloValida(scan);
                System.out.println("Elija la posición de la 2da Ciudad para compararla con la 1ra:");
                num2 = elegirPosArregloValida(scan);
                boolean tienenDosLetrasIguales = nombresTienenDosLetrasIguales(arrCiudad[num].getNombre(),arrCiudad[num2].getNombre());
                System.out.println("Se comparó el nombre "+arrCiudad[num].getNombre()+" con "+arrCiudad[num2].getNombre());
                System.out.println("¿Tenian dos letras iguales? "+(tienenDosLetrasIguales?"SI":"NO"));
                break;
            case 5:
                calculoEmpiricoVelocidadMetodosOrdenamiento(arrCiudad);
                break;
            case 6:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("Opción inválida: Volviendo al menú");
                break;
        }
        scan.nextLine(); //Limpiamos el Scanner después de usarlo
    }
    /* Metodo para mostrar un arreglo de Ciudades completo */
    public static void mostrarArregloCiudades(Ciudad[] arrCiudad){
        for (int i = 0; i < arrCiudad.length; i++) {
            System.out.println("CIUDAD EN POSICIÓN "+(i+1)+":");
            System.out.println(arrCiudad[i].toString());
        }
    }
    /* Metodo para mostrar un arreglo de Ciudades, pero solo los nombres */
    public static void mostrarArregloCiudadesSoloNombres(Ciudad[] arrCiudad){
        for (int i = 0; i < arrCiudad.length; i++) {
            System.out.println("CIUDAD EN POSICIÓN "+(i+1)+":");
            System.out.println(arrCiudad[i].toStringNombre());
        }
    }
    /* Modulo para elegir una posicion del arreglo valida (utilizado en el metodo menu() en los case 3 y 4) */
    public static int elegirPosArregloValida(Scanner scan){
        int num = 0;
        do{
            try{
                System.out.print("Elija una posicion del arreglo (de 1 a 100): ");
                num = scan.nextInt();
            }catch (Exception e){
                System.err.println(e.getMessage()+"ERROR: Eso no es un numero");
            }
            if (num < 1 || num > 100) System.out.println("Ese numero no esta entre el 1 y el 100");
        }while (num < 1 && num > 100);
        return num;
    }
    /* Metodo que sirve para leer un archivo y guarda la informacion en un arreglo (PUNTO 2) */
    public static void leerGuardarCiudadDesdeTxtAUnArray(Ciudad[] arrCiudad, String archivoInfoCiudades){
        String linea = "";
        try{
            FileReader lectorArchivo = new FileReader(archivoInfoCiudades);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            int pos = 0;
            while((linea = bufferLectura.readLine()) != null && pos < arrCiudad.length){
                arrCiudad[pos] = generarObjetoCiudad(linea);
                pos++;
            }
            //Cerramos el buffer una vez terminamos de usarlo
            bufferLectura.close(); 
        //A continuacion manejo de distintos errores
        }catch (FileNotFoundException fnfe){
            System.err.println(fnfe.getMessage()+"\nNo se pudo encontrar el archivo");
        }catch (IOException ioe){
            System.err.println(ioe.getMessage()+"\nError leyendo o escribiendo el archivo");
        }catch (Exception e){
            System.err.println(e.getMessage()+"\nSe producio un error inesperado");
        }       
    }
    /* Metodo que genera una ciudad dado un String leido del txt (PUNTO 2) */
    public static Ciudad generarObjetoCiudad(String lineaLeida){
        String[] ciudadEnStr = lineaLeida.split(";");
        String nom = ciudadEnStr[0];
        int pob = Integer.parseInt(ciudadEnStr[1]);
        float lati = Float.parseFloat(ciudadEnStr[2]), longi = Float.parseFloat(ciudadEnStr[3]);
        Ciudad nuevaCiudad = new Ciudad(nom, pob, lati, longi);
        return nuevaCiudad;
    }
    /* Metodo para clonar un arreglo de Ciudades (PUNTO 3) */
    public static Ciudad[] copiarArrCiudad (Ciudad[] arrCiudad){
        Ciudad[] arrCopiaCiudad = new Ciudad[100];
        for (int i = 0; i < arrCopiaCiudad.length; i++) {
            arrCopiaCiudad[i] = arrCiudad[i];
        }
        return arrCopiaCiudad;
    }
    /* Metodo recursivo para generar un String de abreviatura de nombre (PUNTO 4) */
    public static String abreviaturaNombreRecursivo(String nombreCiudad, int pos){
        String nombreAbreviado = "", vocales = "aeiouAEIOU";
        if(pos < nombreCiudad.length()){ //Entramos si no nos pasamos de la longitud
            if(vocales.indexOf(nombreCiudad.charAt(pos)) > -1 || nombreCiudad.charAt(pos) == ' '){ //Si la letra en pos, es vocal
                nombreAbreviado = abreviaturaNombreRecursivo(nombreCiudad, (pos+1));
            }else{ //Si la letra NO es vocal NI espacio
                nombreAbreviado = nombreCiudad.charAt(pos) + abreviaturaNombreRecursivo(nombreCiudad, (pos+1));
            }
        }
        return nombreAbreviado;
    }
    /* Metodo que dado dos nombres de Ciudades verifica si tienen 2 letras iguales (PUNTO 5) */
    public static boolean nombresTienenDosLetrasIguales(String nomC1, String nomC2){
        boolean tienenDosLetrasIguales = false;
        int i = 0, cantLetrasIguales = 0;
        //Condiciones de corte: Tener 2 o más letras iguales, o llegar a la longitud de alguno de los 2 nombres
        while(!tienenDosLetrasIguales && i < nomC1.length()){
            if(cantLetrasIguales >= 2){ //Si la cantidad de letras iguales es mayor o igual a 2, cortamos
                tienenDosLetrasIguales = true;
            }else if(nomC2.indexOf(nomC1.charAt(i)) > -1){
                //Si el char en i esta en el String, sumamos en uno a cantLetrasIguales y aumentamos el iterador
                cantLetrasIguales++;
                i++;
            }else{ //Si nada se cumple, aumentamos el iterador
                i++;
            }
        }
        return tienenDosLetrasIguales;
    }
    /* Modulo para elegir entre Opcion 1 o 2 (utilizado en el metodo menu() en los case 1, 2 y 4) */
    public static int seleccionUnoDos(Scanner scan){
        int eleccion = 0;
        do{
            try{
                System.out.println("Elija 1 o 2:");
                eleccion = scan.nextInt();
            }catch (Exception e){
                System.err.println(e.getMessage()+" ERROR: Eso no es un numero");
            }
            if(eleccion != 1 && eleccion != 2) System.out.println("ERROR: El numero no es ni 1 ni 2");
        }while(eleccion != 1 && eleccion != 2);
        return eleccion;
    }
    /* Modulo que limpia el case 2 del metodo menu(). Toma los datos conseguidos y ordena arrCiudadAux (PUNTO 3) */
    public static void ordenamientoArregloAux(Ciudad[] arrCiudadAux, int num, int num2){
        if(num == 1){ //ASCENDENTE
            System.out.println("Ordenando de manera DESCENDENTE");
            if(num2 == 1){//SELECCION
                System.out.println("Con el metodo de SELECCION");
                metodosDeOrdenamientoCiudad.seleccionCiudadDescendente(arrCiudadAux);
            }else{//QUICKSORT
                System.out.println("Con el metodo QUICKSORT");
                metodosDeOrdenamientoCiudad.quickSortDescendente(arrCiudadAux, 0, (arrCiudadAux.length-1));
            }
        }else{ //DESCENDENTE
            System.out.println("Ordenando de manera ASCENDENTE");
            if(num2 == 1){//SELECCION
                System.out.println("Con el metodo de SELECCION");
                metodosDeOrdenamientoCiudad.seleccionCiudadAscendente(arrCiudadAux);
            }else{//QUICKSORT
                System.out.println("Con el metodo QUICKSORT");
                metodosDeOrdenamientoCiudad.quickSortAscendente(arrCiudadAux, 0, (arrCiudadAux.length-1));
            }
        }
    }
    /* Modulo que dado un arreglo de Ciudades, muestra cuanto tarda en ordenar cada método, además limpia el case 5 */
    public static void calculoEmpiricoVelocidadMetodosOrdenamiento(Ciudad[] arrCiudad){
        long tiempoInicio = 0, tiempoFin = 0;
        //Creo un nuevo arreglo porque sino modificaria el original
        Ciudad[] arrCiudadMerge = copiarArrCiudad(arrCiudad);
        tiempoInicio = System.nanoTime();
        metodosDeOrdenamientoCiudad.mergeSort(arrCiudadMerge, (arrCiudadMerge.length-1));
        tiempoFin = System.nanoTime();
        System.out.println("El algoritmo MergeSort tardó "+(tiempoFin - tiempoInicio)+" nanosegundos en finalizar el ordenamiento");
        tiempoInicio = 0;
        tiempoFin = 0;

        //Creo un nuevo arreglo porque sino trabajaria sobre un arreglo ordenado o el original
        Ciudad[] arrCiudadQuick = copiarArrCiudad(arrCiudad);
        tiempoInicio = System.nanoTime();
        metodosDeOrdenamientoCiudad.quickSortAscendente(arrCiudad, 0, (arrCiudadQuick.length-1));
        tiempoFin = System.nanoTime();
        System.out.println("El algoritmo QuickSort tardó "+(tiempoFin - tiempoInicio)+" nanosegundos en finalizar el ordenamiento");
        tiempoInicio = 0;
        tiempoFin = 0;

        //Creo un nuevo arreglo porque sino trabajaria sobre un arreglo ordenado o el original
        Ciudad[] arrCiudadHeap = copiarArrCiudad(arrCiudad);
        tiempoInicio = System.nanoTime();
        metodosDeOrdenamientoCiudad.heapSort(arrCiudadHeap);
        tiempoFin = System.nanoTime();
        System.out.println("El algoritmo HeapSort tardó "+(tiempoFin - tiempoInicio)+" nanosegundos en finalizar el ordenamiento");
    }
}