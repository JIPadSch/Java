package conjuntistas.conjuntistasDinamicas;

public class NodoABB {
    private Object elem;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    public NodoABB(Object elem, NodoABB izquierdo, NodoABB derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Object getElem() {
        return elem;
    }

    public NodoABB getIzquierdo() {
        return izquierdo;
    }

    public NodoABB getDerecho() {
        return derecho;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoABB izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoABB derecho) {
        this.derecho = derecho;
    }
}