
public class NodoArbol {

    /* ATRIBUTOS */

    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    /* CONSTRUCTOR */

    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    /* OBSERVADORES */

    public Object getElem(){
        return this.elem;
    }

    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }

    public NodoArbol getDerecho(){
        return this.derecho;
    }

    /* MODIFICADORES */

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho){
        this.derecho = derecho;
    }
}
