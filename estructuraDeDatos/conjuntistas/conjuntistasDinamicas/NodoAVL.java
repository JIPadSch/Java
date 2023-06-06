package conjuntistas.conjuntistasDinamicas;

public class NodoAVL {
    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;    
    
    public NodoAVL(Comparable elem, NodoAVL izquierdo, NodoAVL derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Comparable getElem() {
        return elem;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }
}