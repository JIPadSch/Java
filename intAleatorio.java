import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author JuanPadSch
 */
/* Me daba flojera hacer una invacion de ThreadLocalRandom,
*  entonces me genere plantillas (o tallas ;D) de enteros aleatorios
*/
public class intAleatorio {
    /* Metodo que genera un intAleatorio de talla XS */
    public static int XXS(){
        int aleatorioXXS;
        aleatorioXXS=ThreadLocalRandom.current().nextInt(-16,16);
        return aleatorioXXS;
    }
    /* Metodo que genera un intAleatorio de talla XS */
    public static int XS(){
        int aleatorioXS;
        aleatorioXS=ThreadLocalRandom.current().nextInt(-32,32);
        return aleatorioXS;
    }
    /* Metodo que genera un intAleatorio de talla S */
    public static int S(){
        int aleatorioS;
        aleatorioS=ThreadLocalRandom.current().nextInt(-64,64);
        return aleatorioS;
    }
    /* Metodo que genera un intAleatorio de talla M */
    public static int M(){
        int aleatorioM;
        aleatorioM=ThreadLocalRandom.current().nextInt(-128,128);
        return aleatorioM;
    }
    /* Metodo que genera un intAleatorio de talla L */
    public static int L(){
        int aleatorioL;
        aleatorioL=ThreadLocalRandom.current().nextInt(-256,256);
        return aleatorioL;
    }
}