package Clase3;

public class EjercicioStringClase3 {
	public static void main(String args[]) {
		String texto = "Hola mundo!";
		System.out.println(texto.charAt(0));
		
		for(int i=0;i<texto.length();i++) {
			System.out.println(texto.charAt(i));
		}
		
		String textoMayuscula = texto.toUpperCase();
		
		System.out.println(texto.toUpperCase());
		System.out.println(texto.replace("Hola","Chau"));
		System.out.println(texto);
		
		System.out.println(textoMayuscula);
		
		System.out.println(texto.replace("Hola","Chau").toUpperCase());
		
		String mensaje = "Hola \"Gente\"\nComo estan?";
		System.out.println(mensaje);
		
	}
}
