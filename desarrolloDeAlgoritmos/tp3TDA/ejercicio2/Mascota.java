package desarrolloDeAlgoritmos.tp3TDA.ejercicio2;
/**
 *
 * @author JuanPadSch
 */
public class Mascota {
    /* Ejercicio 2 */
    /* ATRIBUTOS */
    private int codigo;
    private String nombre;
    private double peso;
    private int edad;
    /* CONSTRUCTORES */
    /* Constructor de mascota */
    public Mascota(int cod,String nn,double pe,int ed){
        codigo=cod;
        nombre=nn;
        peso=pe;
        edad=ed;
    }
    /* Constructor de mascota con solo código */
    public Mascota(int cod){
        codigo=cod;
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
    /* Setter de codigo, es privado porque es la llave */
    private void setCodigo(int cod){
        codigo=cod;
    }
    /* Setter de nombre */
    public void setNombre(String nn){
        nombre=nn;
    }
    /* Setter de peso */
    public void setPeso(double pe){
        peso=pe;
    }
    /* Setter de edad */
    public void setEdad(int ed){
        edad=ed;
    }
    /* PROPIAS DEL TIPO */
    /* Metodo equals */
    public boolean equals(Mascota otra){
        return (codigo==otra.getCodigo());
    }
    /* Aumento de edad */
    public void cumpleaños(){
        edad++;
    }
}