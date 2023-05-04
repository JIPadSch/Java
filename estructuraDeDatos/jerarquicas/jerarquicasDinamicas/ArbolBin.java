package estructuraDeDatos.jerarquicas.jerarquicasDinamicas;

public class ArbolBin {

    /* ATRIBUTO */

    private NodoArbol raiz;

    /* CONTRUCTOR */

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {

        boolean exito = true;

        if (this.raiz == null) { // Si el arbol esta vacio, pone elemNuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else { // Si arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            // Si padre existe y lugar no esta ocupado, lo pone, sino da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else if (lugar == 'D' && nPadre.getDerecho() == null) {
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }

        return exito;
    }

    // Metodo PRIVADO que busca un elemento y devuelve el nodo que lo contiene
    // Si no lo encuentra devuelve null
    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        NodoArbol resultado = null;

        if (n != null) {
            if (n.getElem().equals(buscado)) {
                // Si es el buscado, lo devuelve
                resultado = n;
            } else {
                // No es el buscado, busca primero en el HI (Hijo Izquierdo)
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                // Si no lo encontre en el HI, busca en HD (Hijo Derecho)
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }

            }
        }

        return resultado;
    }

    public boolean esVacio() {
        return (this.raiz == null);
    }

    public boolean existe(Object elemBuscado) {
        boolean existe = false;
        existe = buscarPreorden(this.raiz, elemBuscado);
        return existe;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private boolean buscarPreorden(NodoArbol nodo, Object elemBuscado) { // HAY QUE PROBAR QUE ANDE EN EL TEST
        boolean existe = false;
        if (nodo != null) {
            // Visita el elemento en el nodo
            existe = (nodo.getElem().equals(elemBuscado));
            // Recorre a sus hijos en Preorden
            if (!existe) {
                existe = buscarPreorden(nodo.getIzquierdo(), elemBuscado); // (2)
                if (!existe) {
                    existe = buscarPreorden(nodo.getDerecho(), elemBuscado); // (3)
                }
            }

        }

        return existe;
    }

    public Object padre(Object elemHijo) {
        Object elemPadre = null;
        elemPadre = buscarPadrePreorden(this.raiz, elemHijo);
        return elemPadre;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private Object buscarPadrePreorden(NodoArbol nodo, Object elemHijo) { // HAY QUE PROBAR QUE ANDE EN EL TEST
        Object elemPadre = null;
        boolean existe = false;
        if (nodo != null) {
            // Pregunta si el HI es el elemBuscado
            existe = (nodo.getIzquierdo().equals(elemHijo));
            if (!existe) {
                // Pregunta si el HD es el elemBuscado
                existe = (nodo.getDerecho().equals(elemHijo));
            }
            // Recorre a sus hijos en Preorden
            if (!existe) {
                existe = buscarPreorden(nodo.getIzquierdo(), elemHijo); // (2)
                if (!existe) {
                    existe = buscarPreorden(nodo.getDerecho(), elemHijo); // (3)
                }
            } else {
                elemPadre = nodo.getElem();
            }

        }

        return elemPadre;
    }

    public Object hijoIzquierdo(Object elemPadre) {
        Object elemHI = null;
        elemHI = buscarHijoPreorden(this.raiz,elemPadre);
        if(elemHI != null) elemHI = elemHI.getIzquierdo();
        return elemHI;
    }

    public Object hijoDerecho(Object elemPadre) {
        Object elemHD = null;
        elemHD = buscarHijoPreorden(elemPadre);
        if(elemHD != null) elemHD = elemHD.getDerecho();
        return elemHD;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private Object buscarHijoPreorden(NodoArbol nodo, Object elemPadre) { // HAY QUE PROBAR QUE ANDE EN EL TEST
        Object padre = null; 
        boolean existe = false;

        if (nodo != null) {
            // Pregunta si el NODO en el que estas tiene el elemBuscado, o sea, si es el padre
            existe = (nodo.getElem().equals(elemPadre));

            // Recorre a sus hijos en Preorden
            if (!existe) {
                existe = buscarPreorden(nodo.getIzquierdo(), elemPadre); // (2)
                if (!existe) {
                    existe = buscarPreorden(nodo.getDerecho(), elemPadre); // (3)
                }
            } else {
                padre = nodo.getElem();
            }

        }

        return padre;
    }

    public int altura() {
        int altura = 0;

        return altura;
    }

    public int nivel(Object elemBuscado) {
        int nivel = 0;

        return nivel;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolBin clone() {
        ArbolBin arbolClon = new ArbolBin();
        if(this.raiz != null){
            cloneRecursivo(this.raiz, arbolClon);
        }
        return arbolClon;
    }

    private ArbolBin cloneRecursivo(NodoArbol nodo, ArbolBin arbolClon){
        if(nodo != null){
            arbolClon.insertar(nodo.getElem(),,);
            cloneRecursivo(nodo.getIzquierdo, arbolClon);
            cloneRecursivo(nodo.getDerecho, arbolClon);
        }
    }

    public String toString() {
        String texto = "Arbol VACIO";
        texto = listarPreorden().toString();
        return texto;
    }

    /* LISTADOS */

    /* Hojas */

    public Lista listarHojas() {
        Lista lis = new Lista();

        return lis;
    }

    /* Ancestros */

    public Lista listarAncestros(Object elem) {
        Lista lis = new Lista();

        return lis;
    }

    /* Camino más largo */

    public Lista listarCaminoMasLargo() {
        Lista lis = new Lista();

        return lis;
    }

    /* Preorden */

    public Lista listarPreorden() {
        // Retorna una lista con los elementos del árbon en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            // Visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); // (1)
            // Recorre a sus hijos en Preorden
            listarPreordenAux(nodo.getIzquierdo(), lis); // (2)
            listarPreordenAux(nodo.getDerecho(), lis); // (3)
        }
    }

    /* Posorden */

    public Lista listarPosorden() {
        // Retorna una lista con los elementos del árbon en POSORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    // Método recursivo PRIVADO porque su parámetro es de tipo NodoArbol
    private void listarPosordenAux(NodoArbol nodo, Lista lis) {// HAY QUE VERIFICAR QUE ANDE EN EL TEST
        if (nodo != null) {
            // Visito siempre el izquierdo primero
            listarPreordenAux(nodo.getIzquierdo(), lis); // (1)
            // Cuando llego al mas izquierdo, lo listo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); // (2)
            // Despues visito el derecho
            listarPreordenAux(nodo.getDerecho(), lis); // (3)
        }
    }

    /* PRACTICA 1ER PARCIAL: */

    /* Ejercicio 3: 
     * e) Implementar la operación boolean verificarPatron(Lista patron), que recibe por parámetro una lista patron
     *    y determine si coincide exactamente con al menos un camino del árbol que comience en la raíz y termine en
     *    una hoja. El método debe ser eficiente, es decir, recorrer el árbol lo estrictamente necesario.
    */

    public boolean verificarPatron(Lista patron){
        boolean existe = false;
        existe = verificarPatronRecursivo(this.raiz,patron,0,patron.longitud());
        return existe;
    }

    private boolean verificarPatronRecursivo(NodoArbol nodo,Lista patron,int profundidad,int longitud){
        boolean existe = false;

        if(nodo!=null && profundidad < longitud){ //Verificamos que el nodo no sea nulo ni que nos pasemos 
                                                  //de la longitud de la lista
            if(nodo.getElem().equals(patron.recuperar(profundidad+1)) && (profundidad+1)==longitud){ 
                //Caso Base, llegamos al final de la lista y coincide
                existe = true;
            }else if(nodo.getElem().equals(patron.recuperar(profundidad+1))){ 
                //Caso general, coincide elemento pero no es final de la lista    
                existe = verificarPatronRecursivo(nodo.getIzquierdo(), patron, (profundidad+1), longitud);
                if(!existe){ //Si dsp de verificar el izquierdo falla, ent verifica si en el derecho esta el patron
                    existe = verificarPatronRecursivo(nodo.getDerecho(), patron, (profundidad+1), longitud);
                }
            }
            //Si no coincidio el elemento del nodo actual, tira falso           
        }

        return existe;
    }

    /* Ejercicio 3: 
    *  f) Implementar la operación frontera() que devuelve una lista con la secuencia formada por los elementos
    *     almacenados en las hojas del árbol binario, tomadas de izquierda a derecha.
    */

    public Lista frontera(){
        Lista frontera = new Lista();
        fronteraRecursivo(this.raiz,frontera);
        return frontera;
    }

    private void fronteraRecursivo(NodoArbol nodo,Lista frontera){

        if(nodo != null){ //Si el nodo actual distinto de nulo

            if(!nodo.getDerecho().equals(null) && !nodo.getIzquierdo().equals(null)){
                //Si el nodo actual no tiene hijos significa que es hoja, por lo tanto lo agrego a la Lista "frontera"
                frontera.insertar(nodo.getElem(), 0);
            }else{ //Si no es hoja
                fronteraRecursivo(nodo.getIzquierdo(), frontera); //Busco hojas en el hijo izquierdo
                fronteraRecursivo(nodo.getDerecho(), frontera); //Dsp de buscar hojas en el HI, busco en el HD
            }

        }
        
    }

    /* Ejercicio 3: 
    *  g) Implementar la operación clonarInvertido() que devuelve un nuevo árbol, que es una copia del árbol original
    *     (this) pero donde los hijos están cambiados de lugar. Atención: el método devuelve un nuevo árbol, sin
    *     modificar el árbol original.
    *       Consideraciones:
    *            El árbol debe estar implementado con nodos enlazados.
    *            Escribir la definición de tipos de la clase ArbolBin y NodoArbol
    */

    public ArbolBin clonarInvertido(){
        ArbolBin clonInvertido = new ArbolBin(); //Creo un arbol vacio
        clonInvertido.insertar(this.raiz.getElem(), null, 'D'); //Inserto la raiz ya que no cambia
        clonarInvertidoRecursivo(this.raiz,clonInvertido,clonInvertido.raiz);
        return clonInvertido;
    }

    private void clonarInvertidoRecursivo(NodoArbol nodo,ArbolBin clonInvertido,NodoArbol nodoClon){

        if(nodo != null){ //Si el nodo actual no es nulo

            if(nodo.getDerecho() != null){ //Si el nodo actual tiene hijo derecho
                nodoClon.setIzquierdo(nodo.getDerecho()); //Pongo el en el HI del arbolInvertido, el HD del arbol orig
            }

            if(nodo.getIzquierdo() != null){ //Si el nodo actual tiene hijo izquierdo
                nodoClon.setDerecho(nodo.getIzquierdo()); //Pongo el en el HD del arbolInvertido, el HI del arbol orig
            }

            //Recorro el arbol original por el lado izquierdo, y el clon por el lado derecho
            clonarInvertidoRecursivo(nodo.getIzquierdo(), clonInvertido, nodoClon.getDerecho());
            //Recorro el arbol original por el lado derecho, y el clon por el lado izquierdo
            clonarInvertidoRecursivo(nodo.getDerecho(), clonInvertido, nodoClon.getIzquierdo());

        }

    }

}