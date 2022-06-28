package desarrolloDeAlgoritmos.tpFinalPromocion.TDA_Ciudad;
/**
 *
 * @author JuanPadSch
 */
public class Ciudad {
    /* ATRIBUTOS */
    private String nombre;
    private int poblacion;
    //La combinacion de ambas hacen la clave principal
    private double latitud;
    private double longitud;

    /* CONSTRUCTORES */
    /* Constructor vacio (solo clave principal) */
    public Ciudad (double lati, double longi){
        nombre = "";
        poblacion = 0;
        latitud = lati;
        longitud = longi;
    }
    /* Constructor completo */
    public Ciudad (String nom, int pob, double lati, double longi){
        nombre = nom;
        poblacion = pob;
        latitud = lati;
        longitud = longi;
    }

    /* METODOS OBSERVADORES */
    public String getNombre(){
        return nombre;
    }
    public int getPoblacion(){
        return poblacion;
    }
    public double getLatitud(){
        return latitud;
    }
    public double getLongitud(){
        return longitud;
    }
    public String toString(){
        return "Nombre: "+nombre+"/nCantidad de población: "+poblacion+"/nLatitud: "+latitud+"/nLongitud: "+longitud;
    }

    /* METODOS MODIFICADORES */
    public void setNombre(String nuevoNom){
        nombre = nuevoNom;
    }
    public void setPoblacion(int nuevaCantPob){
        poblacion = nuevaCantPob;
    }

    /* PROPIOS DEL TIPO */
    public boolean equals(Ciudad otraCiudad){
        return ((this.latitud == otraCiudad.latitud) && (this.longitud == otraCiudad.longitud));
    }
    public int compareTo(Ciudad otraCiudad){
        int prioridad, i = 0;
        prioridad = 0; //Si los nombres son iguales, no tiene prioridad
        boolean  corte = false;
        while(!corte && (i < this.nombre.length() && i < otraCiudad.nombre.length())){
            //Comparamos el valor ASCII de los caracteres (del atributo "nombre") para saber a que objeto Ciudad darle prioridad al ordenar
            if(this.nombre.charAt(i) > otraCiudad.nombre.charAt(i)){ //Si el valor de la palabra entrante es menor, entonces, la palabra que llama el metodo tiene prioridad
                prioridad = 1; 
                corte = true;
            }else if(this.nombre.charAt(i) < otraCiudad.nombre.charAt(i)){ //Si el valor de la palabra entrante es mayor, entonces, dicha palabra tiene prioridad
                prioridad = -1;
                corte = true;
            } //Si ninguna de las condiciones se cumple, recorreremos la palabra hasta encontrar una diferencia o hasta la longitud
            i++; 
        }
        return prioridad;
    }
}