package estructuraDeDatos.jerarquicas.jerarquicasDinamicas;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen(){
        this.raiz = null;
    }

    public boolean insertar(Object nuevo, Object padre) {
        boolean exito = true;
        NodoGen nodo = this.raiz;
    
        // Verificar si el árbol está vacío
        if (nodo == null) {
            // Crear un nuevo nodo y establecerlo como raíz
            this.raiz = new NodoGen(nuevo, null, null);
        } else {
            // Llamar al método auxiliar para realizar la inserción
            exito = insertarAux(nodo, nuevo, padre);
        }
    
        return exito;
    }

    private boolean insertarAux(NodoGen nodo, Object nuevo, Object padre) {
        boolean insertado = false;
        NodoGen hijo;
        if (nodo != null) {
            if (nodo.getElem().equals(padre)) {
                // Si el elemento es el buscado
                insertado = true;
                if (nodo.getHijoIzquierdo() == null) {
                    // Si es el primer hijo del elemento
                    nodo.setHijoIzquierdo(new NodoGen(nuevo, null, null));
                } else {
                    // Si no es el primer hijo, busco el último hijo y lo inserto
                    hijo = nodo.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(nuevo, null, null));
                }
            } else {
                hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !insertado) {
                    insertado = insertarAux(hijo, nuevo, padre);
                    // Busca con los hijos
                    // A la vuelta, si no encontró con los hijos izquierdos
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return insertado;
    }

    public boolean pertenece(Object elem) {
        boolean pertenece;
        pertenece = perteneceAux(this.raiz, elem);
        return pertenece;
    }

    private boolean perteneceAux(NodoGen nodo, Object elem) {
        boolean esta = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                //si el elemeto es el buescado da true y sale
                esta = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !esta) {
                    //mientras el nodo no sea nulo y no lo haya encontrado
                    esta = perteneceAux(hijo, elem);
                    if (!esta) {
                        //si todavia no lo encontro
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return esta;
    }

    public Lista ancestros(Object elem) {
        Lista ancestros = new Lista();
        ancestrosAux(this.raiz, ancestros, elem);
        return ancestros;
    }
    
    private boolean ancestrosAux(NodoGen nodo, Lista ancestros, Object elem) {
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                // Si el nodo es el elemento buscado, se marca como encontrado
                encontrado = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    // Busca con el hijo izquierdo
                    encontrado = ancestrosAux(hijo, ancestros, elem);
                    // A la vuelta
                    if (!encontrado) {
                        // Si no se encontró, busca con el hermano derecho
                        hijo = hijo.getHermanoDerecho();
                    } else {
                        // Si ya se encontró el elemento, agrega el nodo actual a la lista de ancestros
                        ancestros.insertar(nodo.getElem(), 1);
                    }
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio(){
        // Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en caso contrario.
        return (raiz == null);
    }

    public int altura(){
        /*
         * Devuelve la altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja
         * (Nota: un árbol vacío tiene altura -1 y una hoja tiene altura 0).
        */
    }

    public int nivel(Object elem) {
        int nivel = nivelAux(this.raiz, elem);
        return nivel;
    }

    private int nivelAux(NodoGen nodo, Object elem) {
        int res = -1;
        //inicio de la respuesta en -1 por si no encuntra el elem buscado
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                //si el elemento es el buscado a res le asigna 0
                res = 0;
            }
            if (res < 0) {
                //si todavia no encontro el elem
                NodoGen hijo = nodo.getHijoIzquierdo();
                //a hijo le asigna el hijo de nodo
                while (hijo != null && res < 0) {
                    //si el hijo no es nulo y todavia no encuentra el buscado
                    res = nivelAux(hijo, elem);
                    hijo = hijo.getHermanoDerecho();
                }
                if (res >= 0) {
                    res++;
                    //si encontro el buscado suma en 1 la respuesta
                }

            }
        }
        return res;
    }

    public Object padre(Object elem) {
        Object padre = null;
        if (this.raiz != null && !this.raiz.getElem().equals(elem)) {
            padre = padreAux(this.raiz, elem);

        }

        return padre;
    }

    private Object padreAux(NodoGen nodo, Object elem) {
        Object buscado = null;
        if (nodo != null) {
            //si el nodo no es null
            NodoGen h = nodo.getHijoIzquierdo();
            //si asigno el hijo y busco si hay coinsidencia
            while (h != null && buscado == null) {
                //recorro los hijos de nodo
                if (h.getElem().equals(elem)) {
                    ///si el hijo es el elemento buscado a buscado le asigno nodo que es el padre
                    buscado = nodo.getElem();
                }
                h = h.getHermanoDerecho();
            }
        }
        if (buscado == null && nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null && buscado == null) {
                buscado = padreAux(hijo, elem);
                hijo = hijo.getHermanoDerecho();
            }
        }

        return buscado;
    }

    public Lista listarPreorden() {
        Lista preorden = new Lista();

        preordenAux(this.raiz, preorden);

        return preorden;
    }

    private void preordenAux(NodoGen nodo, Lista preorden) {
        if (nodo != null) {
            //siel nodo no es null o lista
            preorden.insertar(nodo.getElem(), preorden.longitud() + 1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            //a hijo le asigna el primer hijo izquierdo
            while (hijo != null) {
                //mientras el hijo no es null
                preordenAux(hijo, preorden);
                hijo = hijo.getHermanoDerecho();
                //a la vuelta recorre los hijos derechos 
            }

        }

    }

    public Lista listarPosorden() {
        Lista posorden = new Lista();
        if (!this.esVacio()) {
            posordenAux(this.raiz, posorden);
        }
        return posorden;
    }

    private void posordenAux(NodoGen nodo, Lista posorden) {
        //pre condicion que el arbol no este vacio
        NodoGen hijo = nodo.getHijoIzquierdo();
        while (hijo != null) {
            //mientras el hijo izquierdo sea != null
            posordenAux(hijo, posorden);
            //llamo recursivamente 
            hijo = hijo.getHermanoDerecho();
        }
        if (nodo != null) {
            //mientras el nodo no sea null a la vuelta del la iteracion lo inserta 
            posorden.insertar(nodo.getElem(), posorden.longitud() + 1);
        }

    }

    
    public Lista listarInorden(){
        Lista salida = new Lista();
        listarInordenAux(this.raiz,salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls){

        if(n != null){
            //llamado recursivo con primer hijo de n
            if(n.getHijoIzquierdo() != null){
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }

            //visita del nodo n
            ls.insertar(n.getElem(),ls.longitud()+1);

            //llamados recursivos con los otros hijos de n
            if(n.getHijoIzquierdo() != null){
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while(hijo != null){
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }

    }
    
    public Lista listarPorNiveles() {
        Lista niveles = new Lista();
        Cola q = new Cola();
        q.poner(this.raiz);
        NodoGen nodo;
        int longitud = 0;
        while (!q.esVacia()) {
            //mientras la cola no este vacia 
            nodo = (NodoGen) q.obtenerFrente();
            //obtengo el nodo que ingrese primero 
            q.sacar();
            longitud++;
            niveles.insertar(nodo.getElem(), longitud);
            //inserto el nodo que saque en la lista 
            NodoGen hijo = nodo.getHijoIzquierdo();

            while (hijo != null) {
                //inserto los hijos del nodo en la lista 
                q.poner(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return niveles;
    }
    
    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoGen cloneAux(NodoGen nodo) {
        NodoGen nuevo = null;
        if (nodo != null) {
            //mientras el nodo no sea null
            nuevo = new NodoGen(nodo.getElem(), null, null);
            //creo el nuevo nodo
            if (nodo.getHijoIzquierdo() != null) {
                //si el, nodo izquierdo no es null a el enlace de nuevo le asigno el llamado recursivo 
                nuevo.setHijoIzquierdo(cloneAux(nodo.getHijoIzquierdo()));
            }
            if (nodo.getHermanoDerecho() != null) {
                nuevo.setHermanoDerecho(cloneAux(nodo.getHermanoDerecho()));
            }
        }

        return nuevo;
    }
    
    public void vaciar(){
        // Quita todos los elementos de la estructura.
        this.raiz = null;
    }

    public String toString(){
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n){
        String s = "";

        if(n != null){
            //visita del nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();

            while(hijo != null){
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            //comienza recorrido de los hijos de n llamado recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while(hijo != null){
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }

        }
        return s;
    }

    //INCISOS TP 2 OBLIGATORIO

        // ADVERTENCIA: el árbol genérico puede tener elementos repetidos. Tomar como precondición del
        // método sonFrontera que la lista no tenga elementos repetidos.
        public boolean sonFrontera(Lista unaLista) {
            boolean sonFrontera = false;
            if (!this.esVacio() && !unaLista.esVacia()) {
                //mientras la lista y el arbol no sean ninguno vacio 
                sonFrontera = sonFronteraAux(this.raiz, unaLista);
            }
            return sonFrontera;
        }
    
        private boolean sonFronteraAux(NodoGen nodo, Lista unaLista) {
            boolean sonIguales = true;
            if (nodo != null) {
                //si el nodo no es null
                if (nodo.getHijoIzquierdo() == null) {
                    //si el elemento es hoja verifico si esta en la lista 
                    sonIguales = unaLista.localizar(nodo.getElem()) > 0;
                } else {
                    //si no es hoja y la hoja anterior estaba en la lista recorro 
                    NodoGen hijo = nodo.getHijoIzquierdo();
                    while (hijo != null && sonIguales) {
                        sonIguales = sonFronteraAux(hijo, unaLista);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
            return sonIguales;
        }
    

    //Crear public boolean sonFrontera(Lista unaLista) que recibe una lista de elementos almacenada en una estructura del tipo Listay debe verificar si la lista contiene los elementos de la frontera del árbol, sin importar el orden en que aparezcan los elementos en la lista

    public boolean equals(ArbolGen unArbol){
        /*
         * equals recibe un árbol genérico y debe comparar si éste es igual al árbol this. La
         * signatura del método debe ser public boolean equals(ArbolGen unArbol). El método debe
         * ser eficiente y no recorrer de más.
        */
        boolean iguales = false;
        if(this.raiz.equals(unArbol.raiz)){
            iguales = equalsAux(this.raiz.getHijoIzquierdo(), unArbol.raiz.getHijoIzquierdo());
        }
        return iguales;
    }

    private boolean equalsAux(NodoGen nodoArbolOrig, NodoGen nodoArbolOtro){
        boolean iguales = true;

        if(nodoArbolOrig != null && nodoArbolOtro != null){

            if(nodoArbolOrig.equals(nodoArbolOtro)){
                // Recorro los hijos izquierdos
                iguales = equalsAux(nodoArbolOrig.getHijoIzquierdo(), nodoArbolOtro.getHijoIzquierdo());
                if(iguales){ // Si siguen siendo iguales, recorro los hermanos derechos derechos
                    boolean hermanoIguales = true;
                    while(hermanoIguales || (nodoArbolOrig == null && nodoArbolOtro == null)){
                        nodoArbolOrig = nodoArbolOrig.getHermanoDerecho();
                        nodoArbolOtro = nodoArbolOtro.getHermanoDerecho();
                        hermanoIguales = nodoArbolOrig.equals(nodoArbolOtro);
                    }
                    iguales = hermanoIguales;
                }
            }else{
                iguales = false;
            }

        }else if(!nodoArbolOrig.equals(nodoArbolOtro)){ //Si alguno es nulo, entonces pregunto si donde estoy son iguales (o sea, ambos nulos)
            //Si no lo son, entonces son distintos y dejan de ser iguales
            iguales = false;
        }

        return iguales;
    }
}