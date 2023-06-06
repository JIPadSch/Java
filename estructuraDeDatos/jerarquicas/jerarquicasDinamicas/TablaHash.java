package jerarquicas;

public class TablaHash {
    private int TAMANIO;
    private Nodo[] hash;
    private int cant;

    public TablaHash() {
        this.hash = new Nodo [TAMANIO];
        this.cant = 0;
    }
    
    public boolean insetar(Object nuevoElem){
        // primero verifica si el elemento ya esta cargado
        // si no lo encuentra, lo pone adelante del resto
        
        int pos = nuevoElem.hashCode() % this.TAMANIO;
        Nodo aux = this.hash[pos];
        boolean encontrado =  false;
        
        while (!encontrado && aux != null){
            encontrado = aux.getElem().equals(nuevoElem);
            aux = aux.getEnlace();
        }
        
        if (!encontrado){
            this.hash[pos] =  new Nodo(nuevoElem, this.hash[pos]);
            this.cant++;
        }
        
        return !encontrado;
    }
    
    public boolean eliminar(Object elem) {
        int pos = obtenerPosicion(elem);
        Nodo aux = hash[pos];
        Nodo ant = null;
        
        while (aux != null) {
            if (aux.getElem().equals(elem)) {
                if (ant == null) {
                    hash[pos] = aux.getEnlace(); // El elemento a eliminar está al principio de la lista
                } else {
                    ant.setEnlace(aux.getEnlace()); // El elemento a eliminar está en medio o al final de la lista
                }
                cant--;
                return true;
            }
            ant = aux;
            aux = aux.getEnlace();
        }
        
        return false; // El elemento no se encontró en la tabla
    }
    
    public boolean pertenece(Object elem) {
        int pos = obtenerPosicion(elem);
        Nodo aux = hash[pos];
        
        while (aux != null) {
            if (aux.getElem().equals(elem)) {
                return true;
            }
            aux = aux.getEnlace();
        }
        
        return false; // El elemento no se encontró en la tabla
    }
    
    public boolean esVacio() {
        return cant == 0;
    }
    
    public void vaciar() {
        hash = new Nodo[TAMANIO];
        cant = 0;
    }
    
    public TablaHash clone() {
        TablaHash clon = new TablaHash();
        
        for (int i = 0; i < TAMANIO; i++) {
            if (this.hash[i] != null) {
                clon.hash[i] = this.hash[i];
            }
        }
        
        clon.cant = cant;
        return clon;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < TAMANIO; i++) {
            sb.append(i).append(": ");
            Nodo aux = hash[i];
            
            while (aux != null) {
                sb.append(aux.getElem()).append(" ");
                aux = aux.getEnlace();
            }
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    private int obtenerPosicion(Object elem) {
        int posicion;
        if (elem instanceof Integer) {
            posicion = FuncionesHash.hashEntero((Integer) elem, TAMANIO) % TAMANIO;
        } else if (elem instanceof String) {
            posicion = FuncionesHash.hashString((String) elem, TAMANIO) % TAMANIO;
        } else {
            // Manejar otro tipo de elementos si es necesario
            posicion = 0;
        }
        return posicion;
    }
}
