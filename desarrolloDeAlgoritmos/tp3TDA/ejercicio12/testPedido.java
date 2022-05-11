package desarrolloDeAlgoritmos.tp3TDA.ejercicio12;
import java.util.concurrent.ThreadLocalRandom;
import libreriaJuanIPadSch.intAleatorio;
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
        Pedido pedido = cargaPedidoAuto();
        imprimirPedido(pedido);
    }
    /* Modulo que carga de manera automática un pedido aleatorio */
    public static Pedido cargaPedidoAuto(){
        Pedido pedido;
        int cod,telC;
        int[] cost;
        String desc,dirC,nombC;
        //Para mejor legibilidad separo la inicializacion de la asignacion
        cod=codigoAleatorio();
        cost=cargaCostosAleatorio();
        desc=descripcionSegunCostos(cost);        
        dirC=direccionAleatoria();
        nombC=nombreAleatorio();
        telC=telefonoAleatorio();
        pedido = new Pedido(cod, desc, cost, dirC, nombC, telC);
        return pedido;
    }
    /* Modulo que imprime un pedido */
    public static void imprimirPedido(Pedido pedido){
        int i;
        System.out.println("Información del Pedido");
        System.out.println("-----------------------");
        System.out.println("Codigo: "+pedido.getCodigo());
        System.out.println("Descripción: "+pedido.getDescripcion());
        for(i=0;i<pedido.getCostos().length;i++){
            System.out.println("Costo del producto "+(i+1)+" : "+pedido.getCostoEnI(i));
        }
        System.out.println("Dirección del cliente: "+pedido.getDireccionCliente());
        System.out.println("Nombre del cliente: "+pedido.getNombreCliente());
        System.out.println("Teléfono del cliente: "+pedido.getTelefonoCliente());
        System.out.println("Costo total: "+pedido.CalcularCosto());
    }
    /* Modulo que genera y retorna un codigo de pedido de manera aleatoria */
    public static int codigoAleatorio(){
        int codAle;
        return codAle=ThreadLocalRandom.current().nextInt(1000,9999);
    }
    /* Modulo que genera y retorna una descripcion aletoria */
    public static String descripcionSegunCostos(int[] cost){
        String descSegunCost="";
        int i;
        for (i=0;i<cost.length;i++){
            switch (cost[i]) {
                case 800:
                    descSegunCost+="1 Pollo";
                    break;
                case 200:
                    descSegunCost+="1 Papas fritas chicas";
                    break;
                case 300:
                    descSegunCost+="1 Papas fritas medianas";
                    break;
                case 400:
                    descSegunCost+="1 Papas fritas grandes";
                    break;
                case 250:
                    descSegunCost+="1 Chorizo";
                    break;
                case 280:
                    descSegunCost+="1 Morcilla";
                    break;
                case 1500:
                    descSegunCost+="1 Asado";
                    break;
                case 3000:
                    descSegunCost+="1 Promo MEGA";
                    break;
                default:
                    System.out.println("Error en descripcionAleatoria");
                    break;
            }
            descSegunCost+=" ";
        }
        return descSegunCost;
    }
    /* Modulo que carga un arreglo costos segun la descripcion y lo retorna */
    public static int[] cargaCostosAleatorio(){
        int i,costAle;
        int[] costos = new int [ThreadLocalRandom.current().nextInt(1,10)];
        for(i=0;i<costos.length;i++){
            costAle=Math.abs(intAleatorio.XXXS());
            switch(costAle){
                case 1:
                    costos[i]=800;
                    break;
                case 2:
                    costos[i]=200;
                    break;
                case 3:
                    costos[i]=300;
                    break;
                case 4:
                    costos[i]=400;
                    break;
                case 5:
                    costos[i]=250;
                    break;
                case 6:
                    costos[i]=280;
                    break;
                case 7:
                    costos[i]=1500;
                    break;
                case 8:
                    costos[i]=3000;
                    break;
                default:
                    break;
            }
        }
        return costos;
    }
    /* Modulo que genera y retorna una direccion aleatoria */
    public static String direccionAleatoria(){
        String dirAle;
        int numCalleAle=ThreadLocalRandom.current().nextInt(1,4000);
        dirAle=calleAleatoria()+numCalleAle;
        return dirAle;
    }
    /* Modulo que genera y retorna un nombre de calle aleatorio */
    public static String calleAleatoria(){
        String calle="";
        int ale=Math.abs(intAleatorio.XXXS());
        //Coloco un espacio después de cada nombre para agregar el nro. del lugar
        switch (ale){
            case 0:
                calle="Julio Argentino Roca ";
                break;
            case 1:
                calle="San Martín ";
                break;
            case 2:
                calle="Gral. C. Villegas ";
                break;
            case 3:
                calle="Uriburu";
                break;
            case 4:
                calle="Manuel Belgrano ";
                break;
            case 5:
                calle="Juan M. Rosas ";
                break;
            case 6:
                calle="Rivadavia ";
                break;
            case 7:
                calle="Bartolomé Mitre ";
                break;
            case 8:
                calle="Saavedra ";
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