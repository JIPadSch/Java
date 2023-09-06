package programacionConcurrente.TrabajoPractico2.EJ7;

public class Cajero {

    private String nombre;

    //CONSTRUCTOR
    public Cajero(String nombre){
        this.nombre = nombre;
    }

    //METODOS DE ACCESO
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    //PROPIAS DEL TIPO

    public void procesarCompra(Cliente cliente, long timeStamp) {
        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
                            1000
                    + "seg");
        }
        System.out.println(
                "El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
                        (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    public void esperarXsegundos(int tiempo){
        try {
            Thread.sleep(tiempo);    
        } catch (Exception e) {
            // TODO: handle exception
        }        
    }


}
