import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeGame_Hard {

    public static boolean isPalin (int n, String s){
        for (int i=0; i <= n/2; i++){
            if (s.charAt(i) != s.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int numZero = 0;
            for (int j=0; j < n; j++){
                if (s.charAt(j) == '0'){
                    numZero++;
                }
            }
            if (isPalin(n, s)) {
                if (n%2 == 1 && s.charAt(n/2) == '0' && numZero > 1){
                    System.out.println("ALICE");
                }
                else {
                    System.out.println("BOB");
                }
            }
            else {
                if (n%2 == 0){
                    int bothZero = 0;
                    for (int j=0; j <= n/2; j++){
                        if (s.charAt(j) == '0' && s.charAt(n-1-j) == '0'){
                            bothZero++;
                        }
                    }
                    int a = Math.min(1, bothZero*2);
                    int b = numZero-a;
                    if (a == b){
                        System.out.println("DRAW");
                    }
                    else if (a < b){
                        System.out.println("ALICE");
                    }
                    else {
                        System.out.println("BOB");
                    }
                }
                else {
                    if (s.charAt(n/2) == '0'){
                        int bothZero = 0;
                        for (int j=0; j <= n/2; j++){
                            if (s.charAt(j) == '0' && s.charAt(n-1-j) == '0'){
                                bothZero++;
                            }
                        }
                        int a = Math.min(1, bothZero*2);
                        int b = numZero-a;
                        if (a == b){
                            System.out.println("DRAW");
                        }
                        else if (a < b){
                            System.out.println("ALICE");
                        }
                        else {
                            System.out.println("BOB");
                        }
                    }
                    else {
                        int bothZero = 0;
                        for (int j=0; j < n/2; j++){
                            if (s.charAt(j) == '0' && s.charAt(n-1-j) == '0'){
                                bothZero++;
                            }
                        }
                        int a = Math.min(1, bothZero*2);
                        int b = numZero-a;
                        if (a == b){
                            System.out.println("DRAW");
                        }
                        else if (a < b){
                            System.out.println("ALICE");
                        }
                        else {
                            System.out.println("BOB");
                        }
                    }
                }
            }
        }
    }
}
