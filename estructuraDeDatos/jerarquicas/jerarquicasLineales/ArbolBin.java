
public class ArbolBin {

    /* ATRIBUTOS */
    private static final int TAM = 20;
    private CeldaBin[] arbol;
    private int raiz;

    /* CONSTRUCTOR */
    public ArbolBin(){
        this.arbol = new CeldaBin[TAM];
        for (int i = 0; i < TAM; i++) {
            this.arbol[i] = new CeldaBin();
        }
        this.raiz = -1;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, int pos){
        
    }

    public boolean esVacio(){
        return (this.raiz == -1);
    }

    public Object padre(Object elem){

    }
    
}
