package conjuntistas.conjuntistasDinamicas;

public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, null, elemento);
        }

        return exito;
    }

    private boolean insertarAux(NodoAVL n, NodoAVL padre, Comparable elemento) {
        //precondicion n no es nulo
        boolean exito = true;

        if (elemento.compareTo(n.getElem()) == 0) {
            // reportar error: elemento repetido
            exito = false;
        } else if (elemento.compareTo(n.getElem()) < 0) {
            //si tiene HI baja a la izquierda, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), padre, elemento);
            } else {
                n.setIzquierdo(new NodoAVL(elemento, null, null));
            }
        } else {
            //si tiene HD baja a la derecha, sino agrega el elemento
            if (n.getDerecho() != null) {
                exito = insertarAux(n.getDerecho(), padre, elemento);
            } else {
                n.setDerecho(new NodoAVL(elemento, null, null));
            }
        }

        if (exito) {
            if (padre == null) {
                this.raiz = balancear(n);
            } else {
                if (padre.getElem().compareTo(n.getElem()) < 0) {
                    padre.setIzquierdo(balancear(n));
                } else {
                    padre.setDerecho(balancear(n));
                }
            }
        }

        return exito;
    }

    private NodoAVL balancear(NodoAVL nodo) {
        actualizarAltura(nodo); // Actualizar la altura del nodo

        if (obtenerBalance(nodo) == 2) {
            System.out.println("Cambio Izquierda");
            if (obtenerBalance(nodo.getIzquierdo()) <= 0) {
                nodo.setIzquierdo(simpleIzquierda(nodo.getIzquierdo()));
            }
            nodo = simpleDerecha(nodo);
        } else if (obtenerBalance(nodo) == -2) {
            System.out.println("Cambio Derecha");
            if (obtenerBalance(nodo.getDerecho()) >= 0) {
                nodo.setDerecho(simpleDerecha(nodo.getDerecho()));
            }
            nodo = simpleIzquierda(nodo);
        } else if (obtenerBalance(nodo) == -2 && obtenerBalance(nodo.getDerecho()) == 1) {
            System.out.println("Cambio Derecha-Izquierda");
            nodo.setDerecho(simpleDerecha(nodo.getDerecho()));
            nodo = simpleIzquierda(nodo);
        } else if (obtenerBalance(nodo) == 2 && obtenerBalance(nodo.getIzquierdo()) == -1) {
            System.out.println("Cambio Izquierda-Derecha");
            nodo.setIzquierdo(simpleIzquierda(nodo.getIzquierdo()));
            nodo = simpleDerecha(nodo);
        }

        return nodo;
    }

    private void actualizarAltura(NodoAVL nodo) {
        int alturaIzq = altura(nodo.getIzquierdo());
        int alturaDer = altura(nodo.getDerecho());
        nodo.setAltura(Math.max(alturaIzq, alturaDer) + 1);
    }

    private int altura(NodoAVL nodo) {
        int rta = -1;
        if (nodo != null) {
            rta = nodo.getAltura();
        }
        return rta;
    }

    private int obtenerBalance(NodoAVL nodo) {
        int rta = 0;
        if (nodo != null) {
            rta = altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
        }
        return rta;
    }

    private NodoAVL simpleDerecha(NodoAVL nodo) {
        NodoAVL nuevoPadre = nodo.getIzquierdo();
        nodo.setIzquierdo(nuevoPadre.getDerecho());
        nuevoPadre.setDerecho(nodo);
        actualizarAltura(nodo);
        actualizarAltura(nuevoPadre);
        return nuevoPadre;
    }

    private NodoAVL simpleIzquierda(NodoAVL nodo) {
        NodoAVL nuevoPadre = nodo.getDerecho();
        nodo.setDerecho(nuevoPadre.getIzquierdo());
        nuevoPadre.setIzquierdo(nodo);
        actualizarAltura(nodo);
        actualizarAltura(nuevoPadre);
        return nuevoPadre;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public boolean eliminar(Comparable elem) {
        boolean exito = false;
        if (!esVacio()) {
            if (elem.compareTo(this.raiz.getElem()) == 0) {
                // Caso especial: el elemento a eliminar es la raíz
                NodoAVL aux = new NodoAVL(null, null, null);
                aux.setIzquierdo(this.raiz);
                exito = eliminarAux(elem, aux, this.raiz);
                this.raiz = aux.getIzquierdo();
            } else {
                exito = eliminarAux(elem, null, this.raiz);
            }
        }
        return exito;
    }

    private boolean eliminarAux(Comparable elem, NodoAVL padre, NodoAVL actual) {
        boolean exito = false;

        if (actual == null) {
            exito = false; // El elemento no se encuentra en el árbol, no se puede eliminar
        } else if (elem.compareTo(actual.getElem()) < 0) {
            exito = eliminarAux(elem, actual, actual.getIzquierdo());
            if (exito) {
                actual.setIzquierdo(balancear(actual.getIzquierdo()));
            }
        } else if (elem.compareTo(actual.getElem()) > 0) {
            exito = eliminarAux(elem, actual, actual.getDerecho());
            if (exito) {
                actual.setDerecho(balancear(actual.getDerecho()));
            }
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
                Comparable sucesor = buscarMax(actual.getDerecho());
                actual.setElem(sucesor);
                exito = eliminarAux(sucesor, actual, actual.getDerecho());
                if (exito) {
                    actual.setDerecho(balancear(actual.getDerecho()));
                }
            } else {
                // Caso 3: El nodo a eliminar tiene un hijo
                NodoAVL hijo = (actual.getIzquierdo() != null) ? actual.getIzquierdo() : actual.getDerecho();
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

    private Comparable buscarMax(NodoAVL actual) {
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual.getElem();
    }

    public boolean pertenece(Comparable elem) {
        return perteneceAux(this.raiz, elem);
    }

    private boolean perteneceAux(NodoAVL actual, Comparable elem) {
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

    private void listaRec(NodoAVL actual, Lista lista) {
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

    private void listarRangoRec(NodoAVL actual, Comparable elemMinimo, Comparable elemMaximo, Lista lista) {
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
        NodoAVL actual = this.raiz;

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
        NodoAVL actual = this.raiz;

        if (this.raiz == null) {
            actual = null; // Si el árbol está vacío, devuelve null
        } else {
            while (actual.getDerecho() != null) {
                actual = actual.getDerecho(); // Recorre la rama derecha
            }
        }

        return actual.getElem(); // Devuelve el elemento más grande
    }

    public ArbolAVL clone() {
        ArbolAVL clon = new ArbolAVL();
        if (!this.esVacio()) {
            clon.raiz = cloneRec(this.raiz);
        }
        return clon;
    }

    private NodoAVL cloneRec(NodoAVL nodo) {
        NodoAVL nuevo = new NodoAVL(nodo.getElem(), null, null);
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

    private String toStringRec(NodoAVL nodo) {
        String resp = "";
        if (nodo != null) {
            resp = nodo.getElem().toString() + " Alt: " + altura(nodo);
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
