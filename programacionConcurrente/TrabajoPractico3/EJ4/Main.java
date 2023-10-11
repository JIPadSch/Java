package programacionConcurrente.TrabajoPractico3.EJ4;

public class Main {
    public static void main(String[] args) {
        Parque parque = new Parque();
        Persona pers[] = new Persona[20];
        for (int i = 0; i < pers.length; i++) {
            pers[i] = new Persona(parque, i/5, i);
            pers[i].start();
        }
        
    }
}
