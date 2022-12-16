import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class p1805 {

    public static int numDifferentIntegers(String word) {
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        boolean zero = false;
        for (int i=0; i < n; i++){
            int temp = word.charAt(i) - '0';
            if (temp >= 0 && temp < 10){
                if (temp == 0 && sb.length() == 0){
                    zero = true;
                    continue;
                }
                sb.append(word.charAt(i));
                zero = false;
            }
            else {
                if (zero){
                    set.add("0");
                }
                if (sb.length() > 0){
                    set.add(sb.toString());
                    sb = new StringBuilder();
                }
                zero = false;
            }
        }
        if (zero){
            set.add("0");
        }
        if (sb.length() > 0){
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) throws IOException {
        String word = "0a0";
        System.out.println(numDifferentIntegers(word));
    }
}
