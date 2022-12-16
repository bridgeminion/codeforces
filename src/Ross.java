import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ross {

    public static int order (int a, int b){
        int rem = a%b;
        int counter = 1;
        while (rem!=1){
            counter++;
            rem = (rem*a)%b;
        }
        return counter;
    }

    public static boolean isSquare (int a, int b){
        for (int i=0; i < b; i++){
            if (i*i%b == a){
                return true;
            }
        }
        return false;
    }

    public static int totient (int n){
        int counter = 0;
        for (int i=1; i < n; i++){
            if (gcd (i, n) == 1){
                counter++;
            }
        }
        return counter;
    }

    public static int sigma (int n, int k){
        int ans = 0;
        for (int i=1; i <= n; i++){
            if (n%i == 0){
                ans += Math.pow(i, k);
            }
        }
        return ans;
    }

    public static void printPascal (int n){
        long[][] arr = new long[n][n];
        arr[0][0] = 1;
        System.out.println(0 + ": " + 1);
        for (int i=1; i < n; i++){
            System.out.print(i + ": ");
            arr[i][0] = 1;
            for (int j=1; j < n; j++){
                arr[i][j] = (arr[i-1][j] + arr[i-1][j-1])%2;
            }
            for (int j=0; j < i+1; j++){
                System.out.print(arr[i][j]%2 + " ");
            }
            System.out.println();
        }
    }

    public static void pascal1s (int n){
        long[][] arr = new long[n][n];
        arr[0][0] = 1;
        System.out.println(0 + ": " + 1);
        for (int i=1; i < n; i++){
            int counter = 1;
            arr[i][0] = 1;
            for (int j=1; j < n; j++){
                arr[i][j] = (arr[i-1][j] + arr[i-1][j-1])%2;
                if (arr[i][j] == 1){
                    counter++;
                }
            }
            System.out.println(i + ": " + counter);
        }
    }

    public static int R (int m){
        int counter = 0;
        for (int i=1; i < m; i++){
            if ((2*i*i*i*i + i*i - 1)%m == 0){
                counter++;
            }
        }
        return counter;
    }

    public static int character (int a, int p){
        if (isSquare(a, p)){
            return 1;
        }
        return -1;
    }

    public static int gcd (int a, int b){
        for (int i=Math.min(a, b); i > 0; i--){
            if (a%i == 0 && b%i == 0){
                return i;
            }
        }
        return 1;
    }

    public static int mu (int n){
        if (n == 1){
            return 1;
        }
        int counter = 0;
        for (int i=1; i < n; i++){
            if (n%i == 0){
                counter += mu(i);
            }
        }
        return -counter;
    }

    public static boolean isCyclic (int n){
        for (int i=1; i < n; i++){
            if (gcd (i, n) == 1){
                if (order(i, n) == totient(n)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=1; i <= n; i++)
        System.out.println(i + " " + isCyclic(i));
    }
}
