package desarrolloDeAlgoritmos.parcialesDeAñosAnteriores.año2021;

public class Bicicleta {
    /*
    Una bicicletería almacena la información sobre las bicicletas que vende. Estos
    se identifican por un número de serie, su marca, la cantidad de cambios que
    tiene, el tipo de bicleta(‘M’ bici de montaña, ‘C’ Bicicleta de Carrera, ‘U’
    urbana, y ‘O’ otros), el precio de venta, y si cuenta con seguro de fábrica o no
    (un valor booleano).
    1) Especificar el diagrama UML para la clase Bicicleta.
    2) Implementar en Java la clase Bicicleta, su definición de atributos, dos
    constructores de la clase, y los métodos equals, toString y métodos
    observadores (get) y modificadores (set)
    3) Implementar en Java la clase TestBicicleta en la que se defina un
    metodo main que haga uso de la clase Bicicleta. Se debe definir un arreglo de
    bicletas, el método que realiza la carga del arreglo y métodos para:
    a) Un método que permita recuperar la bicicleta con mayor precio de venta.
    b) Un método que muestre por pantalla los datos de las bicicleta de montaña
    cuyas marcas tengan más de dos vocales.
    */

    /* ATRIBUTOS */
    private int numeroSerie;
    private String marca;
    private int cantCambios;
    private char tipoBici;
    private double precio;
    private boolean seguroFabrica;

    /* CONSTRUCTORES */
    /* Constructor solo con numeroSerie */
    public Bicicleta(int numSerie){
        numeroSerie=numSerie;
        marca="";
        cantCambios=0;
        tipoBici=00; //En tabla ASCII, 00 es null
        precio=0;
        seguroFabrica=false;
    }
    /* Constructor con todos los atributos */
    public Bicicleta(int numSerie, String marc, int cambios, char tipo, double prec, boolean segFab){
        numeroSerie=numSerie;
        marca=marc;
        cantCambios=cambios;
        tipoBici=tipo;
        precio=prec;
        seguroFabrica=segFab;
    }
    /* OBSERVADORES */
    public int getNumeroSerie(){
        return numeroSerie;
    }
    public String getMarca(){
        return marca;
    }
    public int getCantCambios(){
        return cantCambios;
    }
    public char getTipoBici(){
        return tipoBici;
    }
    public double getPrecio(){
        return precio;
    }
    public boolean getSeguroFabrica(){
        return seguroFabrica;
    }
    public String toString(){
        return "Numero de serie: "+numeroSerie+"\nMarca: "+marca+"\nCantidad de cambios: "+cantCambios+"\nTipo de bici: "+tipoBici+"\nPrecio: "+precio+"\nTiene seguro: "+seguroFabrica+"\n";
    }
    /* MODIFICADORES */
    public void setMarca(String nuevaMarca){
        marca=nuevaMarca;
    }
    public void setCantCambios(int nuevosCambios){
        cantCambios=nuevosCambios;
    }
    public void setTipoBici(char nuevoTipo){
        tipoBici=nuevoTipo;
    }
    public void setPrecio(double nuevoPrecio){
        precio=nuevoPrecio;
    }
    public void setSeguroFabrica(boolean nuevoSeguro){
        seguroFabrica=nuevoSeguro;
    }
    /* METODOS EQUALS */
    /* Equals que compara 2 bicis */
    public boolean equals(Bicicleta otraBici){
        return numeroSerie==otraBici.getNumeroSerie();
    }
}
