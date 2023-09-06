package programacionConcurrente.TrabajoPractico2.EJ7;

public class Cliente {

    private String nombre;
    private int[] carroCompra;

    //CONSTRUCTOR
    public Cliente(String nombre, int[] carroCompra){
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    //METODOS DE ACCESO

    //OBSERVADORAS
    public String getNombre(){
        return nombre;
    }

    public int[] getCarroCompra(){
        return carroCompra;
    }

    //MODIFICADORAS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCarroCompra(int[] carroCompra){
        this.carroCompra = carroCompra;
    }

}