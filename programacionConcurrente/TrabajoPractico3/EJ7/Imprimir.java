package programacionConcurrente.TrabajoPractico3.EJ7;

public class Imprimir {

    private char turno = 'A';

    public void imprimeNombre(int cant) {
        switch (turno) {
            case 'A':
                this.imprime(cant);
                turno = 'B';
                break;
            case 'B':
                this.imprime(cant);
                turno = 'C';
                break;
            case 'C':
                this.imprime(cant);
                turno = 'A';
                break;
            default:
                break;
        }
    }

    private  void imprime(int cant) {
        for (int i = 0; i < cant; i++) {
            System.out.print(Thread.currentThread().getName());
        }        
    }

}
