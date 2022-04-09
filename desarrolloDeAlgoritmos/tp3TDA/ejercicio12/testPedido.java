package desarrolloDeAlgoritmos.tp3TDA.ejercicio12;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author JuanPadSch
 */
public class testPedido {
    /* 
    *  Este algoritmo carga un Pedido y luego muestra por pantalla
    *  -El codigo del pedido; -La direccion donde debe ser entregado
    *  -El nobmre del cliente; -El costo total calculado
    */
    public static void main(String[] args) {
        Pedido pedido;

    }
    /* Modulo que carga de manera automática un pedido aleatorio */
    public static Pedido cargaPedidoAuto(){
        Pedido pedido;
        int cod,telC;
        int[] cost;
        String desc,dirC,nombC;
        //Para mejor legibilidad separo la inicializacion de la asignacion
        cod=codigoAleatorio();
        desc=descripcionAleatoria();
        cost=cargaCostosSegunDescripcion(desc);
        dirC=direccionAleatoria();
        nombC=nombreAleatorio();
        telC=telefonoAleatorio();
        pedido = new Pedido(cod, desc, cost, dirC, nombC, telC);
        return pedido;
    }
    /* Modulo que genera y retorna un codigo de pedido de manera aleatoria */
    public static int codigoAleatorio(){
        int codAle;
        return codAle=ThreadLocalRandom.current().nextInt(1000,9999);
    }
    /* Modulo que genera y retorna una descripcion aletoria */
    public static String descripcionAleatoria(){
        String descAle;
        return descAle;
    }
    /* Modulo que carga un arreglo costos segun la descripcion y lo retorna */
    public static int[] cargaCostosSegunDescripcion(String descAl){

    }
    /* Modulo que genera y retorna una direccion aleatoria */
    public static String direccionAleatoria(){
        String dirAle;
        int numCalleAle=ThreadLocalRandom.current().nextInt(1,4000);
        dirAle=
        return dirAle;
    }
    /* Modulo que genera y retorna un nombre de calle aleatorio */
    public static String calleAleatoria(){
        String calle="";
        int ale=Math.abs(intAleatorio.XXXS());
        switch (ale){
            case 0:
                calle="General Roca";
                break;
            case 1:
                calle="Emilce";
                break;
            case 2:
                calle="Ignacio";
                break;
            case 3:
                calle="Veronica";
                break;
            case 4:
                calle="Lucas";
                break;
            case 5:
                calle="Josua";
                break;
            case 6:
                calle="Gabriel";
                break;
            case 7:
                calle="Chiara";
                break;
            case 8:
                calle="Rocio";
                break;
            default:
                System.out.println("Error en calleAleatoria");
                break;
        }
        return calle;
    }
    /* Modulo que genera (y retorna) un nombre de cliente de manera aleatoria */
    public static String nombreAleatorio(){
        String nom="";
        int ale=Math.abs(intAleatorio.XXXS()); //Elije aleatoriamente un nombre
        switch (ale){
            case 0:
                nom="Juan";
                break;
            case 1:
                nom="Emilce";
                break;
            case 2:
                nom="Ignacio";
                break;
            case 3:
                nom="Veronica";
                break;
            case 4:
                nom="Lucas";
                break;
            case 5:
                nom="Josua";
                break;
            case 6:
                nom="Gabriel";
                break;
            case 7:
                nom="Chiara";
                break;
            case 8:
                nom="Rocio";
                break;
            default:
                System.out.println("Error en nombreAleatorio");
                break;
        }
        return nom;
    }
    /* Metodo que genera un numero telefonico aleatorio y lo retorna */
    public static int telefonoAleatorio(){
        int areaNumAle=ThreadLocalRandom.current().nextInt(0,1);
        if (areaNumAle==0){ //Numero aleatorio de General Roca
            areaNumAle=298000000+(ThreadLocalRandom.current().nextInt(400000,499999));
        } else{ //Numero aleatorio de Neuquén
            areaNumAle=299000000+(ThreadLocalRandom.current().nextInt(100000,999999));
        }
        return areaNumAle;
    }
}
