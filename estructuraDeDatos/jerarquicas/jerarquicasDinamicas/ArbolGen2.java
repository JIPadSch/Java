/************* Autores ***********
Nahuel Salgado, Legajo FAI-2992
Sofia Guerra , Legajo FAI-3014
Angelo Sasso , Legajo FAI-3497
*/


package jerarquicas;

import lineales.dinamicas.*;

/**
 *
 * @author angelo.sasso
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object nuevo, Object padre) {
        boolean exito = true;
        NodoGen nodo = this.raiz;
        if (nodo == null) {
            this.raiz = new NodoGen(nuevo, null, null);
        } else {
            exito = insertarAux(nodo, nuevo, padre);

        }
        return exito;
    }

    private boolean insertarAux(NodoGen nodo, Object nuevo, Object padre) {
        boolean insertado = false;
        NodoGen hijo;
        if (nodo != null) {
            if (nodo.getElem().equals(padre)) {
                //si el elemnto es el buscado
                insertado = true;
                if (nodo.getHijoIzquierdo() == null) {
                    //si es el primer hijo del elemento
                    nodo.setHijoIzquierdo(new NodoGen(nuevo, null, null));
                } else {
                    //si no es el primer hijo busco el ultimo hijo y lo inserto
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
                    //busca con los hijos
                    //a la vuelta si no econtro con los hijos izquierdos
                    hijo = hijo.getHermanoDerecho();

                }

            }

        }
        return insertado;
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
                //si el nodo es el ecnotrado retorna true;
                encontrado = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    //busca con el hijo izquierdo
                    encontrado = ancestrosAux(hijo, ancestros, elem);
                    //vuelta
                    if (!encontrado) {
                        //si no encontro lo busca con el hermano
                        hijo = hijo.getHermanoDerecho();
                    } else {
                        //si ya se encontro el elemento listo el hijo
                        ancestros.insertar(nodo.getElem(), 1);
                    }
                }

            }

        }
        return encontrado;

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

    public boolean esVacio() {
        boolean esVacia = this.raiz == null;
        return esVacia;
    }

    public int altura() {
        int altura = alturaAux(this.raiz);

        return altura;

    }

    private int alturaAux(NodoGen nodo) {
        int res = -1, aux = -1;

        if (nodo != null) {
            //si hay al menos un nodo
            NodoGen hijo = nodo.getHijoIzquierdo();
            //h es hijo izquierdo de nodo
            while (hijo != null) {
                //si existe h
                aux = alturaAux(hijo);
                //llamado recursivo con h (hijo de nodo)
                if (aux > res) {
                    //pregunto si lo que vino del hijo es mas grande que la altura que tengo guardada
                    res = aux;
                    //si es mayor la guardo como la respuesta
                }
                hijo = hijo.getHermanoDerecho();
                //recorro los otros hijos de nodo
            }
            res++;
            //incremento en 1 la respuesta antes de retornar
        }
        return res;
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

    public Lista listarInorden() {
        Lista inorden = new Lista();
        inordenAux(this.raiz, inorden);
        return inorden;
    }

    private void inordenAux(NodoGen nodo, Lista inorden) {
        if (nodo != null) {
            //si el nodo no es null
            if (nodo.getHijoIzquierdo() != null) {
                inordenAux(nodo.getHijoIzquierdo(), inorden);
                //llamo recursivamente con el hijo izquierdo 
            }

            inorden.insertar(nodo.getElem(), inorden.longitud() + 1);
            //cunado encuentro el hijo extremo izquierdo hoja lo listo y a la vuelta su padre
            if (nodo.getHijoIzquierdo() != null) {
                //si el hijo no es null accedo 
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    //recorro iterando todos los hijos 
                    inordenAux(hijo, inorden);
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

    public boolean equals(ArbolGen arbol) {
        boolean exito = equalsAux(this.raiz, arbol.raiz);
        return exito;
    }

    private boolean equalsAux(NodoGen nodo, NodoGen nodoAux) {
        boolean exito = true;

        if (nodo != null && nodoAux != null) {
            //si los nodos no son null
            if (!nodo.getElem().equals(nodoAux.getElem())) {
                exito = false;
                //si el elemto de los dos nodos son distintos 
            } else {
                //si son iguales recorro 
                NodoGen hijo = nodo.getHijoIzquierdo();
                NodoGen hijoAux = nodoAux.getHijoIzquierdo();
                while ((hijo != null || hijoAux != null) && exito) {
                    //si sigue siendo true el exito y al menos uno de los nodos no es null
                    exito = equalsAux(hijo, hijoAux);
                    if (exito) {
                        hijo = hijo.getHermanoDerecho();
                        hijoAux = hijoAux.getHermanoDerecho();
                    }
                }
            }
        } else {
            //si alguno de los nodos o los dos son null 
            exito = nodo == nodoAux;
        }

        return exito;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen nodo) {
        String s = "";
        if (nodo != null) {
            s += nodo.getElem().toString() + " hijos -->  ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            s = s.substring(0, s.length() - 2);

            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
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

    public void vaciar() {
        this.raiz = null;
    }

    public int gradoSubarbol(Object buscado) {
       int grado=-1;
       NodoGen nodo=obtenerNodo(this.raiz,buscado);
        if (nodo!=null) {
            grado=gradoAux(nodo);
        }
        return grado;
    }
    private NodoGen obtenerNodo(NodoGen nodo,Object elem){
    NodoGen res=null;
        if (nodo!=null) {
            
            if (nodo.getElem().equals(elem)) {
            //si el nodo no es null y es el que buscamos 
                res=nodo;
            }else{
            NodoGen hijo = nodo.getHijoIzquierdo();
            while(hijo!=null && res==null){
            //si todavia no encontro el nodo buscado sigue iterando 
            res=obtenerNodo(hijo,elem);
            hijo=hijo.getHermanoDerecho();
            }
            
            }
                
        }
        return res;
    
    }



    public int grado() {
        int grado = -1;

        if (!this.esVacio()) {
            grado = gradoAux(this.raiz);
        }

        return grado;
    }

    private int gradoAux(NodoGen nodo) {
        int max = 0;
        if (nodo != null) {
            //si el nodo no es null
            if (nodo.getHijoIzquierdo() != null) {
                //si tiene hijo izquierdo
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null) {
                    //mido el grado contando los hijos 
                    max++;
                    hijo = hijo.getHermanoDerecho();
                }

                hijo = nodo.getHijoIzquierdo();

                while (hijo != null) {
                    //mido el grado de los hijos recursivamente y me quedo con el mas grande comparandolo con el de esye nivel 
                    int gradoHijo = gradoAux(hijo);
                    if (gradoHijo > max) {
                        max = gradoHijo;
                    }
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }

        return max;
    }

}
