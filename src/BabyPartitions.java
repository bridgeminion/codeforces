import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BabyPartitions {

    public static boolean isGood (int[] arr){
        int sum = 0;
        for (int i : arr){
            sum += i;
        }
        if (sum%2 == 1){
            return true;
        }
        boolean[] valid = new boolean[sum+1];
        valid[0] = true;
        for (int i : arr){
            for (int j=sum; j >= 0; j--){
                if (valid[j]){
                    int temp = i+j;
                    if (temp*2 == sum){
                        return false;
                    }
                    if (temp <= sum){
                        valid[temp] = true;
                    }
                }
            }
        }
        return !valid[sum/2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (true){
            if (isGood(arr)){
                System.out.println(0);
                return;
            }
            else {
                for (int i=0; i < arr.length; i++){
                    if (arr[i]%2 == 1){
                        System.out.println(1);
                        System.out.println(i+1);
                        return;
                    }
                }
                for (int i=0; i < arr.length; i++){
                    arr[i] /= 2;
                }
            }
        }
    }
}
