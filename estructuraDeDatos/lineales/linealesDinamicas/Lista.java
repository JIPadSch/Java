public class Lista {

    private Nodo cabecera;

    /* CONSTRUCTOR */

    public Lista(){
        cabecera = null;
    }

    /* BASICAS */

    public boolean insertar(Object elemento, int pos){
        boolean exito = false;

        if(pos > 0 && pos < this.longitud()+1){ //Si esta en el rango, lo va a guardar
            if(pos == 1){ //Si quiere insertar en la primer posicion, se ata a la cabecera
                this.cabecera = new Nodo(elemento, this.cabecera);
            } else{ //Avanza hasta el elemento en pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while(i < (pos - 1)){
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            exito = true;
        }

        return exito;
        
    }

    public boolean eliminar(int pos){
        boolean exito = false;
        
        if(pos > 0 && pos < this.longitud()+1){ //Si esta en el rango, lo va a eliminar
            if(pos == 1){ //Si quiere eliminar en la primer posicion, se cambia la cabecera
                this.cabecera = this.cabecera.getEnlace();
            } else{ //Avanza hasta el elemento en pos-1
                Nodo auxPosDada = this.cabecera;
                Nodo auxPosDadaMenosUno = auxPosDada; //Inicializado y creado para dejar feliz al IDE
                int i = 1;
                while(i < pos){
                    auxPosDadaMenosUno = auxPosDada;
                    auxPosDada = auxPosDada.getEnlace(); //obtener el enlace del siguiente.
                    i++;
                }
                auxPosDadaMenosUno.setEnlace(auxPosDada.getEnlace()); //O lo haces re sas: aux.setEnlace(aux.getEnlace().getEnlace()), recorriendo hasta pos-1 
            }
            exito = true;
        }

        return exito;
    }
    
    public Object recuperar(int pos){
        Object elemRecuperado = null; //Si la posicion no es valida, devolvera un elemento null

        if(pos > 0 && pos < this.longitud()+1){ //Verifica que sea una posicion valida
            Nodo nodoAux = this.cabecera;
            int i = 1;
            while(i < pos){
                nodoAux = nodoAux.getEnlace();
                i++;
            }
            elemRecuperado = nodoAux.getElemento();
        }

        return elemRecuperado;
    }

    public int localizar(Object elemBuscado){
        int pos = -1, i = 1;
        boolean elemEncontrado = false;
        Nodo nodoAux = this.cabecera;

        while(i < this.longitud()+1 && !elemEncontrado){ //Posible rompedura con longitud
            if(elemBuscado == nodoAux.getElemento()){
                pos = i;
                elemEncontrado = true;
            }
            nodoAux = nodoAux.getEnlace();
            i++;
        }

        return pos;
    }

    public void vaciar(){
        this.cabecera = null;
    }

    public boolean esVacia(){
        boolean vacia = true;
        if(this.cabecera != null){
            vacia = false;
        }
        return vacia;
    }

    public int longitud(){
        int contador = 0;
        Nodo nodoAux = this.cabecera;

        while(nodoAux != null){
            contador++;
            nodoAux = nodoAux.getEnlace();
        }

        return contador;
    }

    @Override
    public Lista clone() {

        Lista listaClon = new Lista();

        if (this.cabecera != null) {
            int i = 1;
            // Creamos el primer nodo de la Lista clonada
            Nodo nodoClonado = new Nodo(this.cabecera.getElemento(), null);
            listaClon.cabecera = nodoClonado;
            // Iteramos sobre los nodos restantes de la Lista original
            Nodo nodoActual = this.cabecera.getEnlace();
            while (i < this.longitud()+1) {
                // Creamos un nuevo nodo en la Lista clonada
                Nodo nuevoNodo = new Nodo(nodoActual.getElemento(), null);
                // Enlazamos el nuevo nodo con el último nodo de la Lista clonada
                nodoClonado.setEnlace(nuevoNodo);
                // Actualizamos el último nodo de la Lista clonada
                nodoClonado = nuevoNodo;
                nodoActual = nodoActual.getEnlace();
            }
        }

        return listaClon;
    }

    @Override
    public String toString(){
        String texto = "[";

        if(this.cabecera != null){ //Si la Lista NO esta vacia
            Nodo aux = this.cabecera;
            int i = 1;

            while(i < this.longitud()+1){
                texto += aux.getElemento().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    texto += ",";
                }
            }
            texto += "]";

        }else{ //Si la Lista esta VACIA
            texto = "La Lista esta VACIA";
        }

        return texto;
    }
    
}