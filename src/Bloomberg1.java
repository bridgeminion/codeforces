import java.util.ArrayList;
import java.util.List;

public class Bloomberg1 {

    public static boolean valid (String a, String b){
        String[] s1 = a.split(",");
        String[] s2 = b.split(",");
        int amt = Integer.parseInt(s1[2]);
        if (amt > 1000) return false;
        int t1 = Integer.parseInt(s1[1]);
        int t2 = Integer.parseInt(s2[1]);
        return !s1[0].equals(s2[0]) || s1[3].equals(s2[3]) || Math.abs(t1 - t2) > 60;
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        List<String> ans = new ArrayList<>();
        for (int i=0; i < n; i++){
            for (int j=0; j < n; j++){
                if (i != j){
                    if (!valid (transactions[i], transactions[j])){
                        ans.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
