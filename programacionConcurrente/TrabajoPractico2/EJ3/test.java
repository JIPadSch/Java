package programacionConcurrente.TrabajoPractico2.EJ3;

public class test {
    
    public static void main (String [] args) {

        for (int i = 0; i < 10; i++) {
            new ThreadEjemplo("Maria Jose").start();
            new ThreadEjemplo("Jose Maria").start();
            System.out.println("Termina thread main");            
        }

    }

    /*
     * 3) a) Basicamente, lo que quiere, porque varia segun a quien le da recursos la CPU
     * EJEMPLO DE UNA EJECUCION PROBADA:
     * 0 Maria Jose
     * 1 Maria Jose
     * 2 Maria Jose
     * 3 Maria Jose
     * 0 Jose Maria
     * 1 Jose Maria
     * 2 Jose Maria
     * 3 Jose Maria
     * 4 Jose Maria
     * 5 Jose Maria
     * 6 Jose Maria
     * 7 Jose Maria
     * 8 Jose Maria
     * 9 Jose Maria
     * Termina thread Jose Maria
     * Termina thread main
     * 4 Maria Jose
     * 5 Maria Jose
     * 6 Maria Jose
     * 7 Maria Jose
     * 8 Maria Jose
     * 9 Maria Jose
     * Termina thread Maria Jose
     * 0 Maria Jose
     * 1 Maria Jose
     * 2 Maria Jose
     * 3 Maria Jose
     * 4 Maria Jose
     * 5 Maria Jose
     * 6 Maria Jose
     * 7 Maria Jose
     * 8 Maria Jose
     * 9 Maria Jose
     * Termina thread Maria Jose
     * Termina thread main
     * 0 Jose Maria
     * 1 Jose Maria
     * 2 Jose Maria
     * 3 Jose Maria
     * 4 Jose Maria
     * 5 Jose Maria
     * 6 Jose Maria
     * 7 Jose Maria
     * 8 Jose Maria
     * 9 Jose Maria
     * Termina thread Jose Maria
     * 0 Maria Jose
     * 1 Maria Jose
     * 2 Maria Jose
     * 3 Maria Jose
     * 4 Maria Jose
     * 5 Maria Jose
     * 6 Maria Jose
     * 7 Maria Jose
     * 0 Jose Maria
     * 1 Jose Maria
     * 2 Jose Maria
     * 3 Jose Maria
     * 4 Jose Maria
     * 5 Jose Maria
     * 6 Jose Maria
     * 7 Jose Maria
     * 8 Jose Maria
     * 9 Jose Maria
     * Termina thread Jose Maria
     * Termina thread main
     * 8 Maria Jose
     * 9 Maria Jose
     * Termina thread Maria Jose
    */
     
}