package jerarquicas;

public class FuncionesHash {
    
    // Función hash para elementos de tipo Entero
    public static int hashEntero(int elemento, int tamTabla) {
        //se utiliza el operador de módulo (%) para obtener el residuo de la 
        //división del elemento por el tamaño de la tabla. Asegurando que el 
        //resultado esté dentro del rango de índices válido para la tabla.
        return elemento % tamTabla;
    }
    
    // Función hash para elementos de tipo String
    public static int hashString(String elemento, int tamTabla) {
        //calcula un valor hash combinando los valores numéricos de los 
        //caracteres en la cadena
        int hash = 0;
        for (int i = 0; i < elemento.length(); i++) {
            hash = (hash * 31 + elemento.charAt(i)) % tamTabla;
        }
        return hash;
    }
}

