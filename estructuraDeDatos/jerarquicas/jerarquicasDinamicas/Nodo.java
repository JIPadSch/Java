package jerarquicas.jerarquicasDinamicas;

class Nodo {

    private Object elem;
    private Nodo enlace;

    /* CONSTRUCTOR */
    public Nodo(Object elem,Nodo enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    /* MODIFICADORES */
    public void setElemento(Object elem){
        this.elem = elem;
    }

    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }

    /* OBSERVADORES */
    public Object getElem(){
        return elem;
    }
    public Nodo getEnlace(){
        return enlace;
    }

}
