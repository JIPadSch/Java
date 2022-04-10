package desarrolloDeAlgoritmos.tp3TDA.ejercicio1;
/**
 *
 * @author JuanPadSch
 */
public class Terreno {
    /* Ejercicio 1 */
    int codigo;
    double base;
    double altura;
    int manzana;
    /* CONSTRUCTORES */
    /* Constructor de terreno con base y altura 0 */
    public Terreno(int cod){
        codigo=cod;
        base=0;
        altura=0;
    }
    /* Constructor de terreno */
    public Terreno(int cod,double ba,double al,int man){
        codigo=cod;
        base=ba;
        altura=al;
        manzana=man;
    }
    /* OBSERVADORES */
    /* Getter de codigo */
    public int getCodigo(){
        return codigo;
    }
    /* Getter de base */
    public double getBase(){
        return base;
    }
    /* Getter de altura */
    public double getAltura(){
        return altura;
    }
    /* Getter de manzana */
    public int getManzana(){
        return manzana;
    }
    /* Método toString */
    public String toString(){
        String terrenoToString;
        terrenoToString=codigo+" "+base+" "+altura+" "+manzana;
        return terrenoToString;
    }
    /* Método equals */
    public boolean equals(Terreno ter){
        return ((codigo==ter.getCodigo() && base==ter.getBase() && altura==ter.getAltura() && manzana==ter.getManzana()));
    }
    /* MODIFICADORES */
    /* Setter de codigo */
    public void setCodigo(int cod){
        codigo=cod;
    }
    /* Setter de base */
    public void setBase(double ba){
        base=ba;
    }
    /* Setter de altura */
    public void setAltura(double al){
        altura=al;
    }
    /* PROPIAS DEL TIPO */
    /* Método que saca el perimetro */
    public double perimetro(){
        return 2*(base+altura);
    }
    /* Método que saca la superficie */
    public double superficie(){
        return base*altura;
    }
    /* Método que calcula el valor */
    public double valor(double precio){ //Ingresa el precio por metro cuadrado
        return superficie()*precio;
    }
}