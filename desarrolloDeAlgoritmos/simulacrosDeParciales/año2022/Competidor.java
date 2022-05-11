package desarrolloDeAlgoritmos.simulacrosDeParciales.año2022;
/**
 *
 * @author JuanPadSch
 */
public class Competidor {
    /* ATRIBUTOS */
    private int dni; //Clave principal
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudadOrigen;
    private double peso;
    private double altura;

    /* CONSTRUCTORES */
    public Competidor(int unDni){
        dni=unDni;
        nombre="";
        apellido="";
        edad=0;
        ciudadOrigen="";
        peso=0;
        altura=0;
    }
    public Competidor(int unDni,String nom,String ape,int unaEdad,String ciudadO,double pes, double alt){
        dni=unDni;
        nombre=nom;
        apellido=ape;
        edad=unaEdad;
        ciudadOrigen=ciudadO;
        peso=pes;
        altura=alt;
    }

    /* OBSERVADORES */
    public int getDni(){
        return dni;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
    public String getCiudadOrigen(){
        return ciudadOrigen;
    }
    public double getPeso(){
        return peso;
    }
    public double getAltura(){
        return altura;
    }
    public String toString(){
        return "DNI: "+dni+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nEdad: "+edad+"\nCiudad de origen: "+ciudadOrigen+"\nPeso: "+peso+"\nAltura: "+altura;
    }

    /* MODIFICADORES */
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setApellido(String ape){
        nombre=ape;
    }
    public void setEdad(int unaEdad){
        edad=unaEdad;
    }
    public void setCiudadOrigen(String ciudadO){
        ciudadOrigen=ciudadO;
    }
    public void setPeso(double pes){
        peso=pes;
    }
    public void setAltura(double alt){
        altura=alt;
    }

    /* PROPIOS DEL TIPO */
    public boolean equals(Competidor otroCompetidor){
        return dni==otroCompetidor.getDni();
    }
}
