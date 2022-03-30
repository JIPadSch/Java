public class ejercicioClase {
    public static boolean arrBidIntEquals (int[][] arr1, int[][] arr2){
        int i=0,j;
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
