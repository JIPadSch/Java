package Clase3;

public class EjercicioPracticoClase3 {
	public static void main(String args[]) {
				
		int numeros[] = new int [5];
		numeros[0] = 15;
		numeros[1] = 20;
		numeros[2] = 10;
		numeros[3] = 5;
		numeros[4] = 50;
		int suma = 0, cont = 0;
		
		System.out.println(numeros[2]);
		//Visualizamos los datos del array
		for(int i=0;i<numeros.length;i++) {
			System.out.println(numeros[i]);
		}
		for(int i=0;i<numeros.length;i++) {
			if(i%2==0) { //estoy preguntando si la posicion que estoy accediendo es par
				suma = suma+numeros[i]; //acumulador
				cont++; //contador
			}
		}
	}
}
