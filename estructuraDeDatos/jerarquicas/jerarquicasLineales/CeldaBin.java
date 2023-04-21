
class CeldaBin {

    private Object elem;
    private int izquierdo;
    private int derecho;
    private boolean enUso;

    /* CONSTRUCTOR */

    public CeldaBin(Object elem, int izquierdo, int derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    /* OBSERVADORES */

    public Object getElem(){
        return this.elem;
    }

    public int getIzquierdo(){
        return this.izquierdo;
    }

    public int getDerecho(){
        return this.derecho;
    }

    public boolean getEnUso(){
        return this.enUso;
    }

    /* MODIFICADORES */

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setIzquierdo(int izquierdo){
        this.izquierdo = izquierdo;
    }

    public void setDerecho(int derecho){
        this.derecho = derecho;
    }
    
}