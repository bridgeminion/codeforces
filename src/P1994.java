import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1994 {

    public int pow (int x, long mod){
        long ans = 1;
        for (int i=0; i < x; i++){
            ans *= 2;
            ans %= mod;
        }
        return (int)ans;
    }

    public int numberOfGoodSubsets(int[] nums) {
        int[] count = new int[31];
        long mod = 1000000007;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] doublePrimes = {6, 10, 14, 22, 26, 15, 21};
        int[][] doublePrimesPairs = {{10, 21}, {14, 15}, {22, 15}, {22, 21}, {26, 15}, {26, 21}};
        // triple prime = 30
        for (int i : nums){
            count[i]++;
        }
        long first = 1;
        for (int i : primes){
            first *= (count[i]+1);
            first %= mod;
        }
        first = (first+mod-1)%mod;
        long second = 0;
        for (int i : doublePrimes){
            if (count[i] > 0){
                long cur = count[i];
                for (int j : primes){
                    if (i%j != 0){
                        cur *= (count[j]+1);
                        cur %= mod;
                    }
                }
                second += cur;
            }
        }
        long third = 0;
        if (count[30] > 0){
            third = count[30];
            for (int i : primes){
                if (i != 2 && i != 3 && i != 5){
                    third *= (count[i]+1);
                    third %= mod;
                }
            }
        }
        long fourth = 0;
        for (int[] pair : doublePrimesPairs){
            if (count[pair[0]] > 0 && count[pair[1]] > 0){
                long cur = (long) count[pair[0]]*count[pair[1]];
                long prod = pair[0]*pair[1];
                for (int i : primes){
                    if (prod%i != 0){
                        cur *= (count[i]+1);
                        cur %= mod;
                    }
                }
                fourth += cur;
            }
        }
        long ans = (first+second+third+fourth)%mod;
        ans *= pow (count[1], mod);
        ans %= mod;
        return (int)ans;
    }

    public static int[] readArr (int n, BufferedReader br) throws IOException {
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P1994 test = new P1994();
        int n = Integer.parseInt(br.readLine());
        int[] arr = readArr(n, br);
        System.out.println(test.numberOfGoodSubsets(arr));
    }

}
