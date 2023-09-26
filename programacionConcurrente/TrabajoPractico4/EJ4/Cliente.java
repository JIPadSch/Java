package programacionConcurrente.TrabajoPractico4.EJ4;

public class Cliente extends Thread{

    private GestorImpresoras gestor;

    public Cliente (String nombre, GestorImpresoras gestor){
        super(nombre);
        this.gestor = gestor;
    }

    public void run(){

        gestor.solicitudImprimir(this);

    }
    
}