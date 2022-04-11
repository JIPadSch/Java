package desarrolloDeAlgoritmos.tp3TDA.ejercicios5y8;
/**
 *
 * @author JuanPadSch
 */
public class Avion {
    /* Ejercicio 5 */
    private int identificador;
    private String modelo;
    private int cantidadAsientos;
    private double kmRecorridos;
    private double velocidadPromedio;
    /* CONSTRUCTORES */
    /* Constructor de Avion */
    public Avion(int iD, String model, int cantAsi, double kmRec, double velProm){
        identificador=iD;
        modelo=model;
        cantidadAsientos=cantAsi;
        kmRecorridos=kmRec;
        velocidadPromedio=velProm;
    }
    /* OBSERVADORES */
    /* Getter identificador */
    public int getIdentificador(){
        return identificador;
    }
    /* Getter Modelo */
    public String getModelo(){
        return modelo;
    }
    /* Getter cantidadAsientos */
    public int getCantAsientos(){
        return cantidadAsientos;
    }
    /* Getter kmRecorridos */
    public double getKmRecorridos(){
        return kmRecorridos;
    }
    /* Getter velocidadPromedio */
    public double getVelPromedio(){
        return velocidadPromedio;
    }
    /* MODIFICADORES */
     /* Setter identificador, en privado ya que la ID no debería poder modificarse */
     private void setIdentificador(int iD){
        identificador=iD;
    }
    /* Setter modelo, en privado ya que el modelo no cambia */
    private void setModelo(String model){
        modelo=model;
    }
    /* Setter cantidadAsientos, este si en publico ya que podrian modificar los asientos */
    public void setCantAsientos(int cantAsi){
        cantidadAsientos=cantAsi;
    }
    /* Setter kmRecorridos */
    public void setKmRecorridos(double kmRec){
        kmRecorridos=kmRec;
    }
    /* Setter velocidadPromedio */
    public void setVelPromedio(double velProm){
        velocidadPromedio=velProm;
    }
    /* PROPIO DEL TIPO */
    /* Método equals */
    public boolean equals(Avion otro){
        return identificador==otro.getIdentificador();
    }
}
