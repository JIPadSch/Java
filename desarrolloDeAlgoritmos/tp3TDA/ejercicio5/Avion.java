package desarrolloDeAlgoritmos.tp3TDA.ejercicio5;
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
    /* Constructor */
    public Avion(int iD, String model, int cantAsi, double kmRec, double velProm){
        identificador=iD;
        modelo=model;
        cantidadAsientos=cantAsi;
        kmRecorridos=kmRec;
        velocidadPromedio=velProm;
    }
    /* Setter identificador, en privado ya que la ID no debería poder modificarse */
    private void setIdentificador(int iD){
        identificador=iD;
    }
    /* Getter identificador */
    public int getIdentificador(){
        return identificador;
    }
    /* Setter modelo, en privado ya que el modelo no cambia */
    private void setModelo(String model){
        modelo=model;
    }
    /* Getter Modelo */
    public String getModelo(){
        return modelo;
    }
    /* Setter cantidadAsientos, este si en publico ya que podrian modificar los asientos */
    public void setCantAsientos(int cantAsi){
        cantidadAsientos=cantAsi;
    }
    /* Getter cantidadAsientos */
    public int getCantAsientos(){
        return cantidadAsientos;
    }
    /* Setter kmRecorridos */
    public void setKmRecorridos(double kmRec){
        kmRecorridos=kmRec;
    }
    /* Getter kmRecorridos */
    public double getKmRecorridos(){
        return kmRecorridos;
    }
    /* Setter velocidadPromedio */
    public void setVelPromedio(double velProm){
        velocidadPromedio=velProm;
    }
    /* Getter velocidadPromedio */
    public double getVelPromedio(){
        return velocidadPromedio;
    }
}
