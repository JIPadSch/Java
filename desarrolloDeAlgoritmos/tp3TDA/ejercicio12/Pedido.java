package desarrolloDeAlgoritmos.tp3TDA.ejercicio12;
/**
 *
 * @author JuanPadSch
 */
public class Pedido {
    /* Ejercicio 12 */
    private int codigo;
    private String descripcion;
    private int costos[] = new int[10];
    private String direccionCliente;
    private String nombreCliente;
    private int telefonoCliente;
    /* Método constructor de la clase Pedido */
    public Pedido(int cod, String desc, int[] cost, String dirC, String nombC, int telC){
        codigo=cod;
        descripcion=desc;
        costos=cost;
        direccionCliente=dirC;
        nombreCliente=nombC;
        telefonoCliente=telC;
    }
    /* Setter del atributo codigo */
    public void setCodigo(int cod){
        codigo=cod;        
    }
    /* Getter del atributo codigo */
    public int getCodigo(){
        return codigo;
    }
    /* Setter del atributo descripcion */
    public void setDescripcion(String desc){
        descripcion=desc;
    }
    /* Getter del atributo descripcion */
    public String getDescripcion(){
        return descripcion;
    }
    /* Setter del atributo costos */
    public void setCostos(int[] cost){
        costos=cost;
    }
    /* Setter de un elemento especifico del atirubto costos */
    public void setCostoEnI(int costEnI, int pos){
        costos[pos]=costEnI;
    }
    /* Getter del atributo costos */
    public int[] getCostos(){
        return costos;
    }
    /* Getter de un elemento especifico del atributo costos */
    public int getCostoEnI(int pos){
        return costos[pos];
    }
    /* Método propio del tipo del atributo costos: suma los costos almacenados en el arreglo */
    public int CalcularCosto(){
        int i, calculoCosto=0;
        for(i=0;i<costos.length;i++){
            calculoCosto+=costos[i];
        }
        return calculoCosto;
    }
    /* Setter del atributo direccionCliente */
    public void setDireccionCliente(String dirC){
        direccionCliente=dirC;
    }
    /* Getter del atributo direccionCliente */
    public String getDireccionCliente(){
        return direccionCliente;
    }
    /* Setter del atributo nombreCliente */
    public void setNombreCliente(String nomC){
        nombreCliente=nomC;
    }
    /* Getter del atributo nombreCliente */
    public String getNombreCliente(){
        return nombreCliente;
    }
    /* Setter del atributo telefonoCliente */
    public void setTelefonoCliente(int telC){
        telefonoCliente=telC;
    }
    /* Getter del atributo telefonoCliente */
    public int getTelefonoCliente(){
        return telefonoCliente;
    }
}