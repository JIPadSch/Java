package Clase6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Modelo.*;

public class CargaArchivo {

	public static void main(String[] args) {
		
		try {
			
			Compra compra = new Compra();
			int i=0;
			
			for (String linea : Files.readAllLines(Paths.get("src\\Archivos\\items.txt"))){
				//System.out.println(linea);
				
				System.out.println(linea.split(";")[0]);
				String nombre = linea.split(";")[0];
				
				System.out.println(linea.split(";")[1]);
				int cantidad = Integer.parseInt(linea.split(";")[1]);
				
				System.out.println(linea.split(";")[2]);
				double precio = Double.parseDouble(linea.split(";")[2]);
				
				Producto prod = new Producto(nombre,precio);
				Item item = new Item(prod,cantidad);
				
				compra.getItems()[i] = item;
				i++;
				
				//System.out.println("Total sin objeto: "+cantidad*precio);
				System.out.println("Total con objeto: "+item.calcularTotal());
				
			}
			
			System.out.println("Total de la compra: "+Compra.calcularTotalCompra());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
