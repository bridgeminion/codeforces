import java.util.Objects;

public class P43 {

    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")){
            return "0";
        }
        int[] ans = new int[405];
        for (int i=0; i < num1.length(); i++){
            for (int j=0; j < num2.length(); j++){
                int dig1 = num1.charAt(i) - '0';
                int dig2 = num2.charAt(i) - '0';
                ans[i+j] += dig1*dig2;
            }
        }
        for (int i=0; i < 404; i++){
            ans[i+1] += ans[i]/10;
            ans[i] %= 10;
        }
        boolean zero = true;
        StringBuilder s = new StringBuilder();
        for (int i=403; i >= 0; i--){
            if (ans[i] == 0 && zero) continue;
            zero = false;
            s.append(ans[i]);
        }
        return s.toString();
    }
}
