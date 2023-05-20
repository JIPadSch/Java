package jerarquicas.jerarquicasDinamicas;

class NodoGen {

    /* ATRIBUTOS */
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    /* CONSTRUCTOR */
    public NodoGen(Object elem, NodoGen hijoIzquierdo, NodoGen hermanoDerecho){
        this.elem = elem;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hermanoDerecho = hermanoDerecho;
    }

    /* OBSERVADORES */
    public Object getElem(){
        return this.elem;
    }

    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }

    /* MODIFICADORES */
    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo){
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho){
        this.hermanoDerecho = hermanoDerecho;
    }

    /* PROPIOS DEL TIPO */
    public boolean equals(NodoGen otroNodo){
        return (this.elem.equals(otroNodo.elem));
    }
    
}