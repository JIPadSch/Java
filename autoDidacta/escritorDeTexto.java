//package autoDidacta;
import java.io.*;
/**
 *
 * @author JuanPadSch
 */
public class escritorDeTexto {
    public static void main(String[] args) {
        //Aprendiendo a escribir archivos
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("R:\\Programación\\Java\\gitHub\\Java\\pruebas\\autoDidactapruebas.txt")); 
            //Si no elegimos directorio donde crear el archivo se hace en la misma carpeta de donde este el archivo .java
            escritor.write("Escribiendo por primera vez");
            escritor.write("\nOtra linea");
            escritor.write("\nMas lineas");
            escritor.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        //Aprendiendo a leer archivos
        try{
            BufferedReader lector = new BufferedReader(new FileReader("R:\\Programación\\Java\\gitHub\\Java\\pruebas\\autoDidactapruebas.txt"));
            String linea;
            while((linea = lector.readLine()) != null){ //Si no hay lineas para leer el Str será null y cortará la repetitiva
                System.out.println(lector.readLine());
            }
            lector.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
