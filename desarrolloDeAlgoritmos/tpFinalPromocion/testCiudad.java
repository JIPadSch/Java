package desarrolloDeAlgoritmos.tpFinalPromocion;
import desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author JuanPadSch
 */
public class testCiudad {
    public static void main(String[] args) {
        Ciudad[] arrCiudad = new Ciudad[100];
        String archivoInfoCiudades = "R:/Programación/gitHub/Java/desarrolloDeAlgoritmos/tpFinalPromocion/TDA_Ciudad/src/ciudades.txt";
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        //Llenamos el arreglo de Ciudades con la información del .txt
        leerGuardarCiudadDesdeTxtAUnArray(arrCiudad, archivoInfoCiudades);
        //Inicio del loop del menu
        do{
            System.out.println("MENU");
            System.out.println("Elija una opción:");
            System.out.println("1) Ver el arreglo de Ciudades en su estado actual");
            System.out.println("2) Ordenar el arreglo de ciudades (eligirá como desea hacerlo)");
            System.out.println("3) Dada una posición del arreglo, se le mostrará el nombre de la ciudad abreviado");
            System.out.println("4) Verifica si 2 Ciudades tienen 2 letras iguales");
            System.out.println("5) Salir");
            opcion = scan.nextInt();
            menu(opcion, arrCiudad, scan);
        }while(opcion != 5);
        //Cerramos el Scanner una vez finalizamos de usarlo
        scan.close();
    }
    /* MENU */
    public static void menu(int opcion, Ciudad[] arrCiudad, Scanner scan){
        int num = 0, num2 = 0; //Variables utilizada en el metodo de menu con diversos usos
        switch(opcion){
            case 1:
                mostrarArregloCiudades(arrCiudad);
                break;
            case 2:
                String forma, tipo; //Forma = (ascendente, descendiente); Tipo = (Seleccion, )
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
                System.out.println("¿Tenian dos letras iguales?"+(tienenDosLetrasIguales?"SI":"NO"));
                break;
            case 5:
                System.out.println("Adiós!");
                break;
            default:
                System.out.println("Opción inválida: Volviendo al menú");
                break;
        }
    }
    /* Metodo para mostrar un arreglo de Ciudades */
    public static void mostrarArregloCiudades(Ciudad[] arrCiudad){
        for (int i = 0; i < arrCiudad.length; i++) {
            System.out.println("CIUDAD EN POSICIÓN "+(i+1)+":");
            System.out.println(arrCiudad[i].toString());
        }
    }
    /* Metodo para elegir una posicion del arreglo valida */
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
    /* Metodo que sirve para leer un archivo y guarda la informacion en un arreglo */
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
    /* Metodo que genera una ciudad dado un String leido del txt */
    public static Ciudad generarObjetoCiudad(String lineaLeida){
        String[] ciudadEnStr = lineaLeida.split(";");
        String nom = ciudadEnStr[0];
        int pob = Integer.parseInt(ciudadEnStr[1]);
        float lati = Float.parseFloat(ciudadEnStr[2]), longi = Float.parseFloat(ciudadEnStr[3]);
        Ciudad nuevaCiudad = new Ciudad(nom, pob, lati, longi);
        return nuevaCiudad;
    }
    /* Metodo para clonar un arreglo de Ciudades */
    public static Ciudad[] copiarArrCiudad (Ciudad[] arrCiudad){
        Ciudad[] arrCopiaCiudad = new Ciudad[100];
        for (int i = 0; i < arrCopiaCiudad.length; i++) {
            arrCopiaCiudad[i] = arrCiudad[i];
        }
        return arrCopiaCiudad;
    }
    /* Metodo recursivo para generar un String de abreviatura de nombre */
    public static String abreviaturaNombreRecursivo(String nombreCiudad, int pos){
        String nombreAbreviado = "", vocales = "aeiouAEIOU";
        if(pos < nombreCiudad.length()){ //Entramos si no nos pasamos de la longitud
            if(vocales.indexOf(nombreCiudad.charAt(pos)) > -1){ //Si la letra en pos, es vocal
                nombreAbreviado = abreviaturaNombreRecursivo(nombreCiudad, (pos+1));
            }else if (nombreCiudad.charAt(pos) != ' '){ //Si la letra es vocal
                nombreAbreviado = nombreCiudad.charAt(pos) + abreviaturaNombreRecursivo(nombreCiudad, (pos+1));
            }
        }
        return nombreAbreviado;
    }
    /* Metodo que dado dos nombres de Ciudades verifica si tienen 2 letras iguales */
    public static boolean nombresTienenDosLetrasIguales(String nomC1, String nomC2){
        boolean tienenDosLetrasIguales = false;
        int i = 0, cantLetrasIguales = 0;
        //Condiciones de corte: Tener 2 o más letras iguales, o llegar a la longitud de alguno de los 2 nombres
        while(!tienenDosLetrasIguales && (i < nomC1.length() && i < nomC2.length())){
            if(cantLetrasIguales >= 2){ //Si la cantidad de letras iguales es mayor o igual a 2, cortamos
                tienenDosLetrasIguales = true;
            }else if(nomC1.charAt(i) == nomC2.charAt(i)){ //Comparamos el valor ASCII de los char en i
                //Si son iguales, sumamos en uno a cantLetrasIguales y aumentamos el iterador
                cantLetrasIguales++;
                i++;
            }else{ //Si nada se cumple, aumentamos el iterador
                i++;
            }
        }
        return tienenDosLetrasIguales;
    }
}


    /* SECCION DE CODIGO OBSOLETO (IGNORAR, NO FORMA PARTE DEL TP FINAL/COLOQUIO */
    /* 
    *  En un principio iba a hacer que se pudiera elegir cualquier metodo, 
    *  hasta que me di cuenta que solo debia hacer uno. Además en un momento
    *  tuve la idea de generar la info del txt de manera aleatoria, pero cuando
    *  mis compañeros pasaron una lista (en txt) ya unica de toda la info de ciudades
    *  decidi dejar esa idea de lado. Asi que aca se puede ver todo ese código
    *  (completo e incompleto) en la parte de abajo
    */

    /* Metodo utilizado para elegir con que metodo desea el usuario ordenar un arreglo */
    /* public static char eleccionDeMetodo(){
        Scanner sc = new Scanner (System.in);
        char eleccion = ' ';
        boolean corte = false;
        String opciones = "abcABC";
        while(!corte){ //Solo corta cuando el usuario ponga alguna de las opciones validas
            System.out.println("¿Mediante que método desea ordenar este arreglo?");
            System.out.println("a) Burbuja");
            System.out.println("b) Inserción");
            System.out.println("c) Selección");
            try{
                eleccion = sc.next().charAt(0);
            }catch(Exception e){
                System.out.println("ERROR: Input inválido. Eso no es un caracter");
            }
            if(opciones.indexOf(eleccion) > -1){ //Si la eleccion es correcta, cortamos
                corte = true;
            }else{ //Sino, tiramos error
                System.out.println("ERROR: Elija una opcion válida");
            }
        }
        sc.close();
        return eleccion;
    } */

    /* switch(metodoElegido){ //Segun lo elegido, llamamos al metodo
            case 'a':
                metodosDeOrdenamientoCiudad.burbuja(nuevoArrCiudadOrd);
                break;
            case 'b':
                metodosDeOrdenamientoCiudad.insercion(nuevoArrCiudadOrd);
                break;
            case 'c':
                metodosDeOrdenamientoCiudad.seleccion(nuevoArrCiudadOrd);
                break;
        } */

    /* Modulo que verifica que la clave de Ciudad no este repetida */
    /* public static boolean verificarClaveDeCiudad(float latitud, float longitud, Ciudad[] arrCiudad){
        Ciudad ciudadAux = new Ciudad(latitud, longitud);
        boolean yaExiste = false;
        int i = 0;
        while ((!yaExiste) && (arrCiudad[i] != null) && (i < arrCiudad.length)){
            if (arrCiudad[i].equals(ciudadAux)){
                yaExiste = true;
            }else{
                i++;
            }
        }
        return yaExiste;
    } */

    /* Metodo para generar un archivo de Ciudades aleatorio */
    /* public static void generarTxtCiudades(String archivoInfoCiudades){
        //boolean claveRepetida = false;
        String nombreCiudad = "";
        int poblacionCiudad = 0;
        float latitudCiudad = 0, longitudCiudad = 0;
        
        try{

            FileWriter escritorArchivo = new FileWriter(archivoInfoCiudades);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            for (int i = 0; i < 100; i++) {

                nombreCiudad = generarNombreCiudadAleatorio();
                poblacionCiudad = ThreadLocalRandom.current().nextInt(500, 3000000);
                latitudCiudad = ThreadLocalRandom.current().nextFloat()*10;
                longitudCiudad = ThreadLocalRandom.current().nextFloat()*10 + (ThreadLocalRandom.current().nextInt(0, 80));

                bufferEscritura.write(nombreCiudad+";"+poblacionCiudad+";"+latitudCiudad+";"+longitudCiudad+"\n");
            }
            bufferEscritura.close(); //Cerramos el buffer
        }catch (Exception e){
            System.err.println(e.getMessage()+"ERROR INESPERADO");
        }
        
    } */

        /* Metodo para generar nombre de Ciudad aleatorio */
    /* public static String generarNombreCiudadAleatorio(){
        int nroAleatorio = ThreadLocalRandom.current().nextInt(0,6);
        String nombreAleatorio = "";
        switch(nroAleatorio){
            case(0):
                nombreAleatorio = "General Roca";
                break;
            case(1):
                nombreAleatorio = "Neuquén";
                break;
            case (2):
                nombreAleatorio = "Villa Regina";
                break;
            case (3):
                nombreAleatorio = "Fernadez Oro";
                break;
            case (4):
                nombreAleatorio = "Allen";
                break;
            case (5):
                nombreAleatorio = "Chichinales";
                break;
            case (6):
                nombreAleatorio = "Cervantes";
                break;
            default:
                System.out.println("Se produjo un error inesperado");
                break;
        }
        return nombreAleatorio;
    } */