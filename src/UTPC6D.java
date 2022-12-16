import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UTPC6D {

    public static boolean contains (String a, String b){
        if (a.length() < b.length()) return false;
        for (int i=0; i < a.length()-b.length(); i++){
            if (a.substring(i, i+b.length()).equals(b)) return true;
        }
        return false;
    }

    public static int overlap (String a, String b){
        if (contains(a, b)) return b.length();
        for (int i=Math.min(a.length(), b.length()); i >= 0; i--){
            if (a.substring(a.length()-i).equals(b.substring(0, i))){
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1){
            System.out.println(br.readLine().length());
        }
        else {
            String a = br.readLine();
            String b = br.readLine();
            int ans = a.length() + b.length() - Math.max(overlap(a, b), overlap(b, a));
            System.out.println(ans);
        }
    }

}
