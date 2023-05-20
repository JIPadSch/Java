package jerarquicas.jerarquicasDinamicas;

public class Cola {
    
    private Nodo frente;
    private Nodo fin;

    //Constructor
    public Cola(){
        this.frente = null;
        this.fin = null;
    }

    // ---------------------Basicas---------------------

    public boolean poner(Object elem){
        Nodo nuevoNodo = new Nodo(elem, null);

        if(this.frente == null){ //Caso especial donde pila esta vacia
            //Si el frente esta vacio entonces el final esta vacio
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;

        }else{//Caso normal
            this.fin.setEnlace(nuevoNodo);
            this.fin = nuevoNodo;
        }
        return true; //Al ser dinamica siempre se va a agregar el nuevo elemento
    }

    public boolean sacar(){
        boolean exito = true;

        if(this.frente == null){
            //ERROR: La esta vacia
            exito = false;
        }else{
            //Hay almenos un elemento
            //Quita el primer elemento y actualiza frente (y fin se queda vacia)
            this.frente = this.frente.getEnlace();
            if(this.frente == null){ //Si frente no tiene nada, la Cola esta vacía
                this.fin = null;
            }
        }
        return exito;
    }


    public Object obtenerFrente(){
        return this.frente.getElem();
    }

    public boolean esVacia(){
        return this.frente == null;
    }

    public boolean vaciar(){
        boolean sePudoVaciar = true;
        if(this.frente != null){ //Si la cola no está vacia
            //La vacio
            this.frente = null;
            this.fin = null;
        }else{ //Si esta vacia
            //Devuelvo boolean que indica que no se vacio
            sePudoVaciar = false;
        }
        return sePudoVaciar;
    }

    @Override
    public Cola clone() {

        Cola colaClon = new Cola();

        if (this.frente != null) {
            // Creamos el primer nodo de la cola clonada
            Nodo nodoClonado = new Nodo(this.frente.getElem(), null);
            colaClon.frente = nodoClonado;

            // Iteramos sobre los nodos restantes de la cola original
            Nodo nodoActual = this.frente.getEnlace();
            while (nodoActual != null) {
                // Creamos un nuevo nodo en la cola clonada
                Nodo nuevoNodo = new Nodo(nodoActual.getElem(), null);
                // Enlazamos el nuevo nodo con el último nodo de la cola clonada
                nodoClonado.setEnlace(nuevoNodo);
                // Actualizamos el último nodo de la cola clonada
                nodoClonado = nuevoNodo;
                nodoActual = nodoActual.getEnlace();
            }
            // Actualizamos el último nodo de la cola clonada
            colaClon.fin = nodoClonado;
        }
        return colaClon;
    }

    @Override
    public String toString(){
        String texto = "[";

        if(this.frente != null){ //Si la Cola NO esta vacia
            Nodo aux = this.frente;

            while(aux != null){
                texto += aux.getElem().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    texto += ",";
                }
            }
            texto += "]";

        }else{ //Si la Cola esta VACIA
            texto = "La cola esta VACIA";
        }
        return texto;
    }
}
