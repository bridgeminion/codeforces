//
//import java.util.HashSet;
//import java.util.Set;
//
//public class p5878 {
//
//    public static boolean test (String t, String s, int k, int[] count){
//        Set<Character> set = new HashSet<>();
//        int[] c2 = new int[26];
//        for (int i=0; i < t.length(); i++){
//            set.add(t.charAt(i));
//            c2[t.charAt(i)-'a']++;
//        }
//        for (int i=0; i < 26; i++){
//            if (c2[i]*k > count[i]){
//                return false;
//            }
//        }
//        int total = 0;
//        for (char c : set){
//            total += count[c-'a'];
//        }
//        int temp = 0;
//        for (int i=0; i < s.length(); i++){
//            if (t.charAt(temp%t.length()) == s.charAt(i)){
//                temp++;
//                if (temp >= t.length()*k){
//                    return true;
//                }
//            }
//            else if (set.contains(s.charAt(i))){
//                total--;
//            }
//            if (total < temp){
//                return false;
//            }
//        }
//        return temp >= t.length()*k;
//    }
//
//    public String longestSubsequenceRepeatedK (String s, int k) {
//        int n = s.length();
//        int max = n/k;
//        int[] count = new int[26];
//        for (int i=0; i < n; i++){
//            count[s.charAt(i)-'a']++;
//        }
//
//    }
//}
