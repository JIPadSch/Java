package jerarquicas.jerarquicasDinamicas;

public class Lista {

    Nodo cabecera;
    int longitud;

    public Lista() {
        //inisializa en null y 0
        cabecera = null;
        longitud = 0;
    }

    public boolean insertar(Object elem, int pos) {
        boolean exito = true;

        if (1 <= pos && pos <= this.longitud + 1) {
            //si la posicion es valida
            if (pos == 1) {
                //si hay que insertar en la primer posicion 
                this.cabecera = new Nodo(elem, this.cabecera);
                //creo nodo y lo enlazo a la cabecera seteo el enlace por si hay algun elemto en la lista 

            } else {
                //si la posicion es mayor a uno 
                Nodo aux = this.cabecera;
                for (int i = 1; i < pos - 1; i++) {
                    //recorro la lista hasta posicion -1
                    aux = aux.getEnlace();

                }
                aux.setEnlace(new Nodo(elem, aux.getEnlace()));
                //creo el nodo lo asigno a el aux y le setteo el enlace de aux
            }
            this.longitud++;
        } else {
            exito = false;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = false;
        if (pos >= 1 && pos <= this.longitud) {
            //si la posicion es valida
            if (pos==1) {
                //si quiere eliminar el primer elemento
                this.cabecera=this.cabecera.getEnlace();                
            }else{
                //si desea eliminar un elemento distinto a 1
            Nodo aux = this.cabecera;
            for (int i = 1; i <pos-1; i++) {
                //recorro hasta posicion -1
                aux = aux.getEnlace();
            }
            aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
            exito = true;
        }

        return exito;
    }

    public Object recuperar(int pos) {
        Object elem = null;

        if (pos >= 1 && pos <= this.longitud) {
            //si la posicion es valida
            Nodo aux = this.cabecera;
            for (int i = 1; i < pos ; i++) {
                aux = aux.getEnlace();
            }
            elem = aux.getElem();
        }
        return elem;
    }

    public int localizar(Object elemBuscado) {
        int pos = -1; // Posición inicialmente establecida en -1 (no encontrado)
        int i = 1; // Índice del elemento actual
        boolean elemEncontrado = false; // Variable para indicar si el elemento fue encontrado
        Nodo nodoAux = this.cabecera; // Nodo auxiliar para recorrer la lista

        while (i < this.longitud() + 1 && !elemEncontrado) { // Recorrer la lista mientras no se llegue al final y no se haya encontrado el elemento
            if (elemBuscado == nodoAux.getElem()) { // Si el elemento buscado es igual al elemento del nodo actual
                pos = i; // Se actualiza la posición con el índice actual
                elemEncontrado = true; // Se marca el elemento como encontrado
            }
            nodoAux = nodoAux.getEnlace(); // Avanzar al siguiente nodo
            i++; // Incrementar el índice
        }

        return pos; // Devolver la posición del elemento (puede ser -1 si no se encontró)
    }

    public int longitud() {
        int contador = 0;
        Nodo nodoAux = this.cabecera;

        while(nodoAux != null){
            contador++;
            nodoAux = nodoAux.getEnlace();
        }

        return contador;
    }

    public boolean esVacia() {
        boolean esVacia = longitud == 0;
        return esVacia;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public Lista clone() {
        Lista clon = new Lista();
        if (this.longitud != 0) {
            //si la lista no esta vacia
            Nodo aux = this.cabecera.getEnlace();
            //aisgno cabecera a nodo para recorrer
            Nodo auxClon = new Nodo(this.cabecera.getElem(),null);
            //nodo cabecera del clon para enlazar los demas elemntos
            clon.cabecera = auxClon;
            //enlazo a la cabecera 
            while (aux!= null) {
                auxClon.setEnlace(new Nodo(aux.getElem(), null));
                aux = aux.getEnlace();
                auxClon = auxClon.getEnlace();
            }
            
            clon.longitud = this.longitud;
        }

        return clon;
    }

    public String toString() {
        String cadena = "La lista esta vacia ";
        Nodo aux = this.cabecera;
        if (aux!=null) {
            //mientras el aux sea distinto de null
            cadena="primera pos -->[ ";
             while (aux != null) {
            cadena = cadena + aux.getElem();
            aux = aux.getEnlace();
                 if (aux!=null) {
                     cadena=cadena+",";
                 }
        }
             cadena=cadena+" ]";
        }
       
        
        return cadena;

    }

    /* EJERCICIO TIPO 1ER PARCIAL:
     * Ejercicio 1:
     * a)   Agregar al TDA Lista la operación obtenerMultiplos(int num) que recibe un número y devuelve una lista nueva
     *       que contiene todos los elementos de las posiciones múltiplos de num, en el mismo orden encontrado,
     *       haciendo un único recorrido de las estructuras original y copia; y sin usar otras operaciones del TDA.
     *       Ejemplo: si se invoca con la lista <A,B,C,D,E,F,G,H,I,J> y num=3, el método debe devolver la lista <C,F,I>
     * b)  Agregar al TDA Lista la operación eliminarApariciones(TipoElemento x) que elimine todas las apariciones de
     *       elementos iguales a x, haciendo un único recorrido de la estructura y sin usar otras operaciones del TDA.
     * • Consideraciones ejercicio 1 a y b:
     *     ◦ Realizar la definición de tipos de todas las clases involucradas
     *     ◦ En todas las operaciones recorrer lo menos posible las estructuras
     */
    
    public Lista obtenerMultiplos(int num){
        int insertador = 0;
        Nodo nodoAux = this.cabecera;
        Lista listaMultiplosNum = new Lista();

        for(int i = 0; i < this.longitud(); i++){
            if((i % num) == 0){
                listaMultiplosNum.insertar(nodoAux.getElem(), insertador);
                insertador++;
            }
            nodoAux = nodoAux.getEnlace();
        }

        return listaMultiplosNum;
    }

    public void eliminarApariciones(Object x){
            Nodo nodoAux = this.cabecera;

            while (nodoAux != null){

                if(nodoAux.getEnlace().getElem().equals(x)){ //Si el elemento del siguiente nodo es "x"
                    nodoAux.setEnlace(nodoAux.getEnlace().getEnlace()); //Entonces, el enlace del actual pasa a ser el enlace del siguiente (el cual coincide con "x")
                }

                nodoAux = nodoAux.getEnlace(); //Continuo recorriendo
            }
        

    }

}
