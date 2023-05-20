package jerarquicas.jerarquicasDinamicas;

public class NodoArbol {

    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Object elemento, NodoArbol izq, NodoArbol der) {
        this.elem = elemento;
        this.izquierdo = izq;
        this.derecho = der;

    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }

}
