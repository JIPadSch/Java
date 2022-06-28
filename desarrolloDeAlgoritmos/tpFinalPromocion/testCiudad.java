package desarrolloDeAlgoritmos.tpFinalPromocion;
import desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
/**
 *
 * @author JuanPadSch
 */
public class testCiudad {
    public static void main(String[] args) {
        Ciudad[] arrCiudad = new Ciudad[100];
        String archivoInfoCiudades = "TDA_Ciudad/src/infoCiudades.txt";
        generarTxtCiudades(archivoInfoCiudades);
        leerGuardarCiudadDesdeTxtAUnArray(arrCiudad, archivoInfoCiudades);
    }
    /* Metodo para generar un archivo de Ciudades aleatorio */
    public static void generarTxtCiudades(String archivoInfoCiudades){
        boolean claveRepetida = false;
        String nombreCiudad = "";
        int poblacionCiudad = 0;
        double latitudCiudad = 0, longitudCiudad = 0;

        FileWriter escritorArchivo = new FileWriter(archivoInfoCiudades);
        BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

        for (int i = 0; i < 100; i++) {
            nombreCiudad = generarNombreCiudadAleatorio();
            poblacionCiudad = ThreadLocalRandom.current().nextInt(500, 3000000);
            do {
                latitudCiudad = ThreadLocalRandom.current().nextDouble(0,90);
                longitudCiudad = ThreadLocalRandom.current().nextDouble(0,180);
                claveRepetida = verificarClaveDeCiudad(latitudCiudad, longitudCiudad);
            }while(claveRepetida);

            bufferEscritura.write(nombreCiudad+"-"+poblacionCiudad+"*"+latitudCiudad+"º"+longitudCiudad+"\n");
            
        }
    }
    /* Metodo para generar nombre de Ciudad aleatorio */
    public static String generarNombreCiudadAleatorio(){
        int nroAleatorio = ThreadLocalRandom.current().nextInt(0,30);
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
    }
    /* Modulo que verifica que la clave de Ciudad no este repetida */
    public static boolean verificarClaveDeCiudad(double latitud, double longitud, Ciudad[] arrCiudad){
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
    }
    /* Metodo que sirve para leer un archivo y guarda la informacion en un arreglo */
    public static void leerGuardarCiudadDesdeTxtAUnArray(Ciudad[] arrCiudad, String archivoInfoCiudades){
        String aux = "";
        try{
            FileReader lectorArchivo = new FileReader(archivoInfoCiudades);
            FileWriter escritorArchivo = new FileWriter(archivoInfoCiudades);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            while((aux = bufferLectura.readLine()) != null){
                for (int i = 0; i < aux.length(); i++) {
                    if(aux.charAt(i) == '-'){

                    }else if(aux.charAt(i) == '*'){
    
                    }else if(aux.charAt(i) == 'º'){
                        
                    }else if(aux.charAt(i) == '\n'){

                    }
                }
            }
            //Cerramos los buffers una vez terminamos de usarlos
            bufferLectura.close(); 
            bufferEscritura.close();
        //A continuacion manejo de distintos errores
        }catch (FileNotFoundException fnfe){
            System.err.println(fnfe.getMessage()+"\nNo se pudo encontrar el archivo");
        }catch (IOException ioe){
            System.err.println(ioe.getMessage()+"\nError leyendo o escribiendo el archivo");
        }catch (Exception e){
            System.err.println(e.getMessage()+"\nSe producio un error inesperado");
        }       
    }
    /* Metodo para clonar un arreglo de Ciudades */
    public static Ciudad[] clonarArrCiudad (Ciudad[] arrCiudad){
        Ciudad[] arrClonCiudad = new Ciudad[100];
        for (int i = 0; i < arrClonCiudad.length; i++) {
            arrClonCiudad[i] = arrCiudad[i].clone();
        }
        return arrClonCiudad;
    }
    /* Metodo recursivo para generar un String de abreviatura de nombre */
    public static String abreviaturaNombreRecursivo(String nombreCiudad, int pos){
        String nombreAbreviado = "", vocales = "aeiouAEIOU";
        if(pos < nombreAbreviado.length()){ //Entramos si no nos pasamos de la longitud
            if(vocales.indexOf(nombreCiudad.charAt(pos)) > -1){ //Si la letra en pos, es vocal
                nombreAbreviado = nombreCiudad.charAt(pos) + abreviaturaNombreRecursivo(nombreCiudad, (pos+1));
            }else{
                nombreAbreviado = abreviaturaNombreRecursivo(nombreCiudad, (pos+1));
            }
        }
        return nombreAbreviado;
    }
}


    /* SECCION DE CODIGO OBSOLETO */

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