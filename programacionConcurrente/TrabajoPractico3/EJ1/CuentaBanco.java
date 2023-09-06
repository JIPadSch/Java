package programacionConcurrente.TrabajoPractico3.EJ1;

public class CuentaBanco {
    private int balance = 50;
    public CuentaBanco(){
    }
    public int getBalance(){
    return balance;
    }
    public void retiroBancario(int retiro){
    balance = balance - retiro;
    }
}