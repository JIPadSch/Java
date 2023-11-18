package programacionConcurrente.TrabajoPractico3.EJ3;

public class Jaula {
    private Comedero comer;
    private Descansar dormir;
    private Rodar rodar;

    public Jaula(Comedero c, Descansar d, Rodar r){
        comer = c;
        dormir = d;
        rodar = r;
    }

    public void comer()throws Exception{
        comer.comer();
    }
    
    public void rodar() throws Exception{
        dormir.dormir();
    }

    public void descansar() throws Exception{
        rodar.rodar();
    }
}
