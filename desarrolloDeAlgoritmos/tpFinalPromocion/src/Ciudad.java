package desarrolloDeAlgoritmos.tpFinalPromocion.src;
/**
 *
 * @author JuanPadSch
 */
public class Ciudad {
    /* PUNTO 1 */
    /* ATRIBUTOS */
    private String nombre; //Se expresara siempre en MAYUSCULAS
    private int poblacion;
    //La combinacion de ambas hacen la clave principal
    private float latitud;
    private float longitud;

    /* CONSTRUCTORES */
    /* Constructor vacio (solo clave principal) */
    public Ciudad (float lati, float longi){
        nombre = "";
        poblacion = 0;
        latitud = lati;
        longitud = longi;
    }
    /* Constructor completo */
    public Ciudad (String nom, int pob, float lati, float longi){
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
    public float getLatitud(){
        return latitud;
    }
    public float getLongitud(){
        return longitud;
    }
    public String toString(){
        return "Nombre: "+nombre+"\nCantidad de población: "+poblacion+"\nLatitud: "+latitud+"\nLongitud: "+longitud;
    }
    public String toStringNombre(){
        return "Nombre: "+nombre;
    }

    /* METODOS MODIFICADORES */
    public void setNombre(String nuevoNom){
        nombre = nuevoNom;
    }
    public void setPoblacion(int nuevaCantPob){
        poblacion = nuevaCantPob;
    }

    /* PROPIOS DEL TIPO */
    /* Metodo equals */
    public boolean equals(Ciudad otraCiudad){
        return ((this.latitud == otraCiudad.latitud) && (this.longitud == otraCiudad.longitud));
    }
    /* Metodo compareTo (se basa en el abecedario) */
    public int compareTo(String nombreOtraCiudad){
        int prioridad, i = 0;
        prioridad = 0; //Si los nombres son iguales, no tiene ninguno prioridad
        boolean  corte = false;
        while(!corte && (i < this.nombre.length() && i < nombreOtraCiudad.length())){
            //Comparamos el valor ASCII de los caracteres (del atributo "nombre") para saber a que objeto Ciudad darle prioridad al ordenar
            if(this.nombre.charAt(i) > nombreOtraCiudad.charAt(i)){ //Si el valor de la palabra entrante es menor, entonces, la Ciudad.nombre que llama el metodo tiene prioridad
                prioridad = 1; 
                corte = true;
            }else if(this.nombre.charAt(i) < nombreOtraCiudad.charAt(i)){ //Si el valor de la palabra entrante es mayor, entonces, dicha palabra tiene prioridad
                prioridad = -1;
                corte = true;
            } 
            //Si ninguna de las condiciones se cumple, recorreremos la palabra hasta encontrar una diferencia o hasta la longitud
            i++; 
        }
        return prioridad;
    }
    /* Metodo clonar que clona un arreglo de ciudades */
    public Ciudad clone(){
        Ciudad nuevaCiudad = new Ciudad(this.nombre, this.poblacion, this.latitud, this.longitud);
        return nuevaCiudad;
    }
}