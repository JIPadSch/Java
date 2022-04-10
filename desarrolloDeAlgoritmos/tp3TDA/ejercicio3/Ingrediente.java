package desarrolloDeAlgoritmos.tp3TDA.ejercicio3;
/**
 *
 * @author JuanPadSch
 */
public class Ingrediente {
    /* Ejercicio 3 */
    /* ATRIBUTOS */
    private String nombre;
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
    /* Setter de nombre */
    public void setNombre(String nom){
        nombre=nom;
    }
    /* Setter de cantidad */
    public void setCantidad(int cant){
        cantidad=cant;
    }
    /* Setter de unidadDeMedida */
    public void setUnidadDeMedida(String unDeMed){
        unidadDeMedida=unDeMed;
    }
}
