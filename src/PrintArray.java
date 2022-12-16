public class PrintArray {

    public static void printArr (int n, int[] arr){
        for (int i=0; i < n-1; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[n-1]);
    }
}
