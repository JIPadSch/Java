package ej2parcial;

public class Main {
    public static void main(String[] args) {
        Espacio esp = new Espacio();
        int k = 10, i = 0;
        
        while (i++ < k) {
            Hidrogeno h = new Hidrogeno(esp);
            h.start();
        }
        i = 0;
        while (i++ < k*3) {
            Oxigeno o = new Oxigeno(esp);
            o.start();
        }
    }
}
