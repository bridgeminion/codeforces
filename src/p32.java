import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class p32 {

    public static int longestValidParentheses(String s) {
        int n = s.length();
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        int ans = 0;
        int net = 0;
        tmap.put(0, 0);
        for (int i=0; i < n; i++){
            boolean left = s.charAt(i) == '(';
            if (left){
                net++;
            }
            else {
                net--;
            }
            if (tmap.containsKey(net)){
                int temp = tmap.get(net);
                ans = Math.max(ans, i+1-temp);
                tmap.put(net, Math.min(temp, i+1));
            }
            else {
                tmap.put(net, i+1);
            }
            for (int key : tmap.descendingKeySet()){
                if (key <= net){
                    break;
                }
                tmap.put(key, n);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(longestValidParentheses(s));
    }
}
