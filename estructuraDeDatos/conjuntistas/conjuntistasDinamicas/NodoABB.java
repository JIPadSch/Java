package conjuntistas.conjuntistasDinamicas;

class NodoABB {
    
    /* ATRIBUTOS */
    private Comparable elemento;
    private NodoABB izquierdo;
    private NodoABB derecho;

    /* CONSTRUCTORES */
    public NodoABB(Comparable elemento){
        this.elemento = elemento;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoABB(Comparable elemento, NodoABB izquierdo, NodoABB derecho){
        this.elemento = elemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    /* OBSERVADORES */
    public Object getElem(){
        return this.elemento;
    }

    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }

    public NodoABB getDerecho(){
        return this.derecho;
    }

    /* MODIFICADORES */
    public void setElem(Comparable elemento){
        this.elemento = elemento;
    }

    public void setIzquierdo(NodoABB izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoABB derecho){
        this.derecho = derecho;
    }
    
}
