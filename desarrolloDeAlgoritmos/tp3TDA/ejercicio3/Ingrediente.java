package desarrolloDeAlgoritmos.tp3TDA.ejercicio3;
/**
 *
 * @author JuanPadSch
 */
public class Ingrediente {
    /* Ejercicio 3 */
    /* ATRIBUTOS */
    private String nombre; //Atributo clave
    private int cantidad;
    private String unidadDeMedida;
    /* CONSTRUCTORES */
    /* Constructor de Ingrediente */
    public Ingrediente(String nom,int cant,String unDeMed){
        nombre=nom;
        cantidad=cant;
        unidadDeMedida=unDeMed;
    }
    /* OBSERVADORES */
    /* Getter de nombre */
    public String getNombre(){
        return nombre;
    }
    /* Getter de cantidad */
    public int getCantidad(){
        return cantidad;
    }
    /* Getter de unidadDeMedida */
    public String getUnidadDeMedida(){
        return unidadDeMedida;
    }
    /* MODIFICADORES */
    /* Setter de cantidad */
    public void setCantidad(int cant){
        cantidad=cant;
    }
    /* Setter de unidadDeMedida */
    public void setUnidadDeMedida(String unDeMed){
        unidadDeMedida=unDeMed;
    }
    /* PROPIOS DEL TIPO */
    /* Metodo toString */
    public String toString(){
        return "Nombre del ingrediente: "+nombre+"\nCantidad del ingrediente: "+cantidad+"\nUnidad de medida: "+unidadDeMedida+"\n";
    }
}
