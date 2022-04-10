package desarrolloDeAlgoritmos.tp3TDA.ejercicio12;
/**
 *
 * @author JuanPadSch
 */
public class Pedido {
    /* Ejercicio 12 */
    /* ATRIBUTOS */
    private int codigo;
    private String descripcion;
    private int costos[] = new int[10];
    private String direccionCliente;
    private String nombreCliente;
    private int telefonoCliente;
    /* CONSTRUCTORES */
    /* Método constructor de la clase Pedido */
    public Pedido(int cod, String desc, int[] cost, String dirC, String nombC, int telC){
        codigo=cod;
        descripcion=desc;
        costos=cost;
        direccionCliente=dirC;
        nombreCliente=nombC;
        telefonoCliente=telC;
    }
    /* OBSERVADORES */
    /* Getter del atributo codigo */
    public int getCodigo(){
        return codigo;
    }
    /* Getter del atributo descripcion */
    public String getDescripcion(){
        return descripcion;
    }
    /* Getter del atributo costos */
    public int[] getCostos(){
        return costos;
    }
    /* Setter del atributo codigo */
    public void setCodigo(int cod){
        codigo=cod;        
    }
    /* Getter de un elemento especifico del atributo costos */
    public int getCostoEnI(int pos){
        return costos[pos];
    }
    /* Getter del atributo direccionCliente */
    public String getDireccionCliente(){
        return direccionCliente;
    }
    /* Getter del atributo nombreCliente */
    public String getNombreCliente(){
        return nombreCliente;
    }
    /* Getter del atributo telefonoCliente */
    public int getTelefonoCliente(){
        return telefonoCliente;
    }
    /* MODIFICADORES */
    /* Setter del atributo descripcion */
    public void setDescripcion(String desc){
        descripcion=desc;
    }
    /* Setter del atributo costos */
    public void setCostos(int[] cost){
        costos=cost;
    }
    /* Setter de un elemento especifico del atirubto costos */
    public void setCostoEnI(int costEnI, int pos){
        costos[pos]=costEnI;
    }
    /* Setter del atributo direccionCliente */
    public void setDireccionCliente(String dirC){
        direccionCliente=dirC;
    }
    /* Setter del atributo nombreCliente */
    public void setNombreCliente(String nomC){
        nombreCliente=nomC;
    }
    /* Setter del atributo telefonoCliente */
    public void setTelefonoCliente(int telC){
        telefonoCliente=telC;
    }
    /* PROPIOS DEL TIPO */
    /* Método propio del tipo del atributo costos: suma los costos almacenados en el arreglo */
    public int CalcularCosto(){
        int i, calculoCosto=0;
        for(i=0;i<costos.length;i++){
            calculoCosto+=costos[i];
        }
        return calculoCosto;
    }
}