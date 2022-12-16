import java.io.IOException;

public class p1806 {

    public static int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i=0; i < n; i++){
            perm[i] = i;
        }
        for (int i=1; i <= n; i++){
            int[] arr = new int[n];
            for (int j=0; j < n; j++){
                if (j%2 == 0){
                    arr[j] = perm[j/2];
                }
                else {
                    arr[j] = perm[n/2+(j-1)/2];
                }
            }
            boolean works = true;
            for (int j=0; j < n; j++){
                perm[j] = arr[j];
                if (perm[j] != j){
                    works = false;
                }
            }
            if (works){
                return i;
            }
        }
        return n+1;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(reinitializePermutation(4));
    }
}
