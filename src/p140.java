import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p140 {

    static void create (String s, boolean[] split, List<String> ans){
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i=0; i < s.length(); i++){
            if (split[i]){
                if (last != 0){
                    sb.append(' ');
                }
                sb.append(s, last, i+1);
                last = i+1;
            }
        }
        ans.add(sb.toString());
    }

    static void gen (String s, Set<String> set, int index, boolean[] split, List<String> ans){
        if (index == s.length()){
            create (s, split, ans);
            return;
        }
        for (int i=index; i < Math.min(index+10, s.length()); i++){
            if (set.contains(s.substring(index, i+1))){
                split[i] = true;
                gen (s, set, i+1, split, ans);
                split[i] = false;
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        gen (s, set, 0, new boolean[s.length()], ans);
        return ans;
    }
}
