package desarrolloDeAlgoritmos.tp3TDA.ejercicio2;
/**
 *
 * @author JuanPadSch
 */
public class Mascota {
    /* Ejercicio 2 */
    private int codigo;
    private String nombre;
    private double peso;
    private int edad;
    /* CONSTRUCTORES */
    /* Constructor de mascota con solo código */
    public Mascota(int cod){
        codigo=cod;
    }
    /* Constructor de mascota */
    public Mascota(int cod,String nn,double pe,int ed){
        codigo=cod;
        nombre=nn;
        peso=pe;
        edad=ed;
    }
    /* OBSERVADORES */
    /* Getter de codigo */
    public int getCodigo(){
        return codigo;
    }
    /* Getter de nombre */
    public String getNombre(){
        return nombre;
    }
    /* Getter de peso */
    public double getPeso(){
        return peso;
    }
    /* Getter de edad */
    public int getEdad(){
        return edad;
    }
    /* Método toString */
    public String toString(){
        String mascotaToString;
        mascotaToString=codigo+" "+nombre+" "+peso+" "+edad;
        return mascotaToString;
    }
    /* MODIFICADORES */
    /* Setter de codigo */
    
}
