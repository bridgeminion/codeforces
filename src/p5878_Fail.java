import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p5878_Fail {

    public static boolean valid (String test, int[] count, int k){
        int[] amt = new int[26];
        for (int i=0; i < test.length(); i++){
            amt[test.charAt(i)-'a']++;
        }
        for (int i=0; i < 26; i++){
            if (amt[i]*k > count[i]){
                return false;
            }
        }
        return true;
    }

    public static String test (String s, int k, int max){
        int n = s.length();
        int[] count = new int[26];
        for (int i=0; i < n; i++){
            count[s.charAt(i)-'a']++;
        }
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            char c = s.charAt(i);
            for (String j : map.keySet()){
                if (j.length() == max){
                    int num = map.get(j);
                    if (j.charAt(num%j.length()) == c){
                        map.put(j, num+1);
                    }
                }
                String test = j+c;
                if (test.length() <= max && valid(test, count, k) && !map.containsKey(test)){
                    list.add(test);
                }
            }
            for (String j : list){
                map.put(j, j.length());
            }
            list.clear();
            if (!map.containsKey(String.valueOf(c))){
                map.put(String.valueOf(c), 1);
            }
        }
        String ans = "";
        for (String i : map.keySet()){
            if (map.get(i)/i.length() >= k){
                if (i.length() > ans.length()){
                    ans = i;
                }
                else if (i.length() == ans.length() && i.compareTo(ans) > 0){
                    ans = i;
                }
            }
        }
        return ans;
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int max = n/k;
        for (int i=max; i > 0; i--){
            String temp = test (s, k, i);
            if (!temp.equals("")){
                return temp;
            }
        }
        return "";
    }
}
