package conjuntistas.conjuntistasDinamicas;
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }

        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento) {
        //precondicion n no es nulo
        boolean exito = true;

        if (elemento.compareTo(n.getElem()) == 0) {
            // reportar error: elemento repetido
            exito = false;
        } else if (elemento.compareTo(n.getElem()) < 0) {
            //si tiene HI baja a la izquierda, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elemento);
            } else {
                n.setIzquierdo(new NodoABB(elemento, null, null));
            }
        } else {
            //si tiene HD baja a la derecha, sino agrega el elemento
            if (n.getDerecho() != null) {
                exito = insertarAux(n.getDerecho(), elemento);
            } else {
                n.setDerecho(new NodoABB(elemento, null, null));
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }
    
    public void vaciar(){
        this.raiz = null;
    }

    public boolean eliminar(Comparable elem) {
        boolean exito;
        if (esVacio()) {
            exito = false; // El árbol está vacío, no se puede eliminar el elemento
        } else {
            exito = eliminarAux(elem, null, this.raiz);
        }

        return exito;
    }

    private boolean eliminarAux(Comparable elem, NodoABB padre, NodoABB actual) {
        boolean exito;

        if (actual == null) {
            exito = false; 
            // El elemento no se encuentra en el árbol, no se puede eliminar
        } else if (elem.compareTo(actual.getElem()) < 0) {
            exito = eliminarAux(elem, actual, actual.getIzquierdo());
        } else if (elem.compareTo(actual.getElem()) > 0) {
            exito = eliminarAux(elem, actual, actual.getDerecho());
        } else {
            // Se encontró el elemento a eliminar
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                // Caso 1: El nodo a eliminar es una hoja
                if (padre == null) {
                    raiz = null; // El nodo a eliminar es la raíz del árbol
                } else if (actual == padre.getIzquierdo()) {
                    padre.setIzquierdo(null);
                } else {
                    padre.setDerecho(null);
                }
            } else if (actual.getIzquierdo() != null && actual.getDerecho() != null) {
                // Caso 2: El nodo a eliminar tiene dos hijos
                Comparable sucesor = buscarMin(actual.getDerecho());
                actual.setElem(sucesor);
                eliminarAux(sucesor, actual, actual.getDerecho());
            } else {
                // Caso 3: El nodo a eliminar tiene un hijo
                NodoABB hijo = (actual.getIzquierdo() != null) ? actual.getIzquierdo() : actual.getDerecho();
                if (padre == null) {
                    raiz = hijo; // El nodo a eliminar es la raíz del árbol
                } else if (actual == padre.getIzquierdo()) {
                    padre.setIzquierdo(hijo);
                } else {
                    padre.setDerecho(hijo);
                }
            }
            exito = true; // Se eliminó el elemento exitosamente
        }

        return exito;
    }

    private Comparable buscarMin(NodoABB actual) {
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return (Comparable) actual.getElem();
    }

    public boolean pertenece(Comparable elem) {
        return perteneceAux(this.raiz, elem);
    }

    private boolean perteneceAux(NodoABB actual, Comparable elem) {
        boolean pertenece = false;

        if (actual != null) {
            int comparacion = elem.compareTo(actual.getElem());
            if (comparacion == 0) {
                pertenece = true;
            } else if (comparacion < 0) {
                pertenece = perteneceAux(actual.getIzquierdo(), elem);
            } else {
                pertenece = perteneceAux(actual.getDerecho(), elem);
            }
        }

        return pertenece;
    }

    public Lista lista() {
        Lista lista = new Lista();
        listaRec(this.raiz, lista);
        return lista;
    }

    private void listaRec(NodoABB actual, Lista lista) {
        if (actual != null) {
            listaRec(actual.getIzquierdo(), lista);
            lista.insertar(actual.getElem(), lista.longitud() + 1);
            listaRec(actual.getDerecho(), lista);
        }
    }

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        Lista lista = new Lista();
        listarRangoRec(this.raiz, elemMinimo, elemMaximo, lista);
        return lista;
    }

    private void listarRangoRec(NodoABB actual, Comparable elemMinimo, Comparable elemMaximo, Lista lista) {
        if (actual != null) {
            Comparable elementoActual = (Comparable) actual.getElem();

            if (elemMinimo.compareTo(elementoActual) < 0) {
                listarRangoRec(actual.getIzquierdo(), elemMinimo, elemMaximo, lista);
            }

            if (elemMinimo.compareTo(elementoActual) <= 0 && elemMaximo.compareTo(elementoActual) >= 0) {
                lista.insertar(elementoActual, lista.longitud() + 1);
            }

            if (elemMaximo.compareTo(elementoActual) > 0) {
                listarRangoRec(actual.getDerecho(), elemMinimo, elemMaximo, lista);
            }
        }
    }

    public Object minimoElem() {
        NodoABB actual = this.raiz;

        if (this.raiz == null) {
            actual = null; // Si el árbol está vacío, devuelve null
        } else {
            while (actual.getIzquierdo() != null) {
                actual = actual.getIzquierdo(); // Recorre la rama izquierda
            }
        }

        return actual.getElem(); // Devuelve el elemento más pequeño
    }

    public Object maximoElem() {
        NodoABB actual = this.raiz;

        if (this.raiz == null) {
            actual = null; // Si el árbol está vacío, devuelve null
        } else {
            while (actual.getDerecho() != null) {
            actual = actual.getDerecho(); // Recorre la rama derecha
        }
        }

        return actual.getElem(); // Devuelve el elemento más grande
    }
    
    public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
        if (!this.esVacio()) {
            clon.raiz = cloneRec(this.raiz);
        }
        return clon;
    }

    private NodoABB cloneRec(NodoABB nodo) {
        NodoABB nuevo = new NodoABB(nodo.getElem(), null, null);
        if (nodo.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneRec(nodo.getIzquierdo()));
        }
        if (nodo.getDerecho() != null) {
            nuevo.setDerecho(cloneRec(nodo.getDerecho()));
        }
        return nuevo;
    }

    public String toString() {
        String cadena = "";
        cadena = toStringRec(this.raiz);
        return cadena;
    }

    private String toStringRec(NodoABB nodo) {
        String resp = "";
        if (nodo != null) {
            resp = nodo.getElem().toString();
            if (nodo.getIzquierdo() != null) {
                resp += " HI: " + nodo.getIzquierdo().getElem().toString();
            } else {
                resp += " HI: -";
            }

            if (nodo.getDerecho() != null) {
                resp += " HD: " + nodo.getDerecho().getElem().toString() + "\n";

            } else {
                resp += " HD: -\n";
            }
            resp += toStringRec(nodo.getIzquierdo());
            resp += toStringRec(nodo.getDerecho());
        }
        return resp;
    }

}
