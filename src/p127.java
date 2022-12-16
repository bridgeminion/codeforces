import java.util.*;

public class p127 {

    public static boolean difOne (String a, String b){
        if (a.length() != b.length()) return false;
        boolean done = false;
        for (int i=0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)){
                if (done){
                    return false;
                }
                done = true;
            }
        }
        return done;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(beginWord);
        vis.add(beginWord);
        int ans = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i < size; i++){
                String cur = q.remove();
                if (cur.equals(endWord)){
                    return ans;
                }
                for (String j : wordList){
                    if (!vis.contains(j) && difOne(cur, j) ){
                        vis.add(j);
                        q.add(j);
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
