import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class libJuanIPadSch {
    
    public static void fillArrInt (int[] arrInt){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrInt.length;i++){
            System.out.println("Fill pos "+i);
            arrInt[i] = scan.nextInt();
            scan.nextLine();
        }
    }

    public static void fillArrChar (char[] arrChar){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrChar.length;i++){
            System.out.println("Fill pos "+i);
            //arrChar[i] = scan
            scan.nextLine();
        }
    }

    public static void fillArrString (String[] arrString){
        Scanner scan = new Scanner (System.in);
        int i;
        for (i=0;i<arrString.length;i++){
            System.out.println("Fill pos "+i);
            arrString[i] = scan.nextLine();
            scan.nextLine();
        }
    }

    public static boolean arrBidIntEquals (int[][] arr1, int[][] arr2){
        boolean isEquals = (arr1.length==arr2.length && arr2[0].length==arr2[0].length);
        while (isEquals && i<arr1.length){
            j=0;
            while (isEquals && j<arr1[0].length){
                if (arr1[i][j] == arr2[i][j]){
                    j++;
                } else{
                    isEquals = false;
                }
            }
            i++;
        }
        return isEquals;
    }

}