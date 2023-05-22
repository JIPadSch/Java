package conjuntistas.conjuntistasDinamicas;

public class ArbolBB {

    /* ATRIBUTO */
    private NodoABB raiz;

    /* CONSTRUCTOR */
    public ArbolBB(){
        this.raiz = null;
    }

    /* METODOS DE CLASE */
    public boolean pertenece(Comparable elemento){
        boolean existe = false;

        return existe;
    }

    public boolean insertar(Comparable elemento){
        boolean exito = true;

        if(this.raiz == null){
            this.raiz = new NodoABB(elemento);
        }else{
            exito = insertarAux(this.raiz, elemento);
        }

        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento){
        //precondicion: n no es nulo
        boolean exito = true;

        if((elemento.compareTo(n.getElem())) == 0){
            //Reportar error: Elemento repetido
            exito = false;

        }else if(elemento.compareTo(n.getElem()) < 0){
            //elemento es menor que n.getElem()
            //si tiene HI baja a la izquierda, sino agrega el elemento
            if(n.getIzquierdo() != null){
                exito = insertarAux(n.getIzquierdo(), elemento);
            }else{

            }
        }

        return exito;
    }

    public boolean eliminar(Comparable elemento){
        boolean exito = false;

        return exito;
    }

    public Lista listar(){
        Lista lista = new Lista();

        return lista;
    }

    public Lista listarRango(Comparable elem1, Comparable elem2){
        Lista lista = new Lista();

        return lista;
    }

    public Comparable minimoElem(){
        Comparable minimo = null;

        return minimo;
    }

    public Comparable maximoElem(){
        Comparable maximo = null;

        return maximo;
    }

    public boolean vacio(){
        return (this.raiz == null);
    }
    
}