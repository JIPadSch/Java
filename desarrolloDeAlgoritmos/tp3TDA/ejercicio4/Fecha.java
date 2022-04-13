package desarrolloDeAlgoritmos.tp3TDA.ejercicio4;
/**
 *
 * @author JuanPadSch
 */
public class Fecha {
    /* Ejercicio 4 */
    /* ATRIBUTOS */
    private int dia;
    private int mes;
    private int año;
    /* CONSTRUCTORES */
    /* Constructor de fecha */
    public Fecha(int d,int m,int a){
        dia=d;
        mes=m;
        año=a;
    }
    /* OBSERVADORES */
    /* Getter de dia */
    public int getDia(){
        return dia;
    }
    /* Getter de mes */
    public int getMes(){
        return mes;
    }
    /* Getter de año */
    public int getAño(){
        return año;
    }
    /* MODIFICADORES */
    /* Setter de dia */
    public void setDia(int diaNuevo){
        dia=diaNuevo;
    }
    /* Setter de mes */
    public void setMes(int nuevoMes){
        mes=nuevoMes;
    }
    /* Setter de año */
    public void setAño(int nuevoAño){
        año=nuevoAño;
    }
    /* OTROS METODOS */
    /* Método toString */
    public String toString(){
        return ""+dia+"/"+mes+"/"+año;
    }
    /* Metodo equals */
    public boolean equals(Fecha otra){
        return dia==otra.getDia() && mes==otra.getMes() && año==otra.getAño();
    }
    /* PROPIOS DEL TIPO */
    /* Método diasTranscurridos, dada una fecha, calcula la cantidad de dias transcurridos en el año */
    public int diasTranscurridos(Fecha otraFecha){
        int diasPasados=0;

        return diasPasados;
    }
    /* Método esFechaAnterior, verifica si una fecha es anterior a otra */
    public boolean esFechaAnterior(Fecha otraFecha){
        boolean esAnterior=false;
        if (año>otraFecha.getAño()){
            esAnterior=true;
        }else if(mes>otraFecha.getMes()){
            esAnterior=true;
        } else if(dia>otraFecha.getDia()){
            esAnterior=true;
        }
        return esAnterior;
    }
    /* Método calculaFecha, dada un fecha y una cantidad de días, indica cual será la fecha */
    /* Método esBisiesto, calculo si un año es bisiesto o no */
}