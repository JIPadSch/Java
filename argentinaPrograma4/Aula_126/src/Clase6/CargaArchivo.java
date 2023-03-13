package Clase6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CargaArchivo {

	public static void main(String[] args) {
		
		try {
			for (String linea : Files.readAllLines(Paths.get("src\\Archivos\\items.txt"))){
				//System.out.println(linea);
				System.out.println(linea.split(";")[0]);
				System.out.println(linea.split(";")[1]);
				System.out.println(linea.split(";")[2]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
