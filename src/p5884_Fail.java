import java.io.IOException;
import java.util.*;

public class p5884_Fail {

    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> found = new HashSet<>();
    int ans = 0;
    boolean correct = true;

    public void dfs (List<Integer> list){
        if (list.size() == 1){
            if (found.contains(list.get(0))){
                return;
            }
            found.add(list.get(0));
            if (correct){
                if (map.containsKey(list.get(0))){
                    ans += 5*map.get(list.get(0));
                }
                correct = false;
            }
            else {
                if (map.containsKey(list.get(0))){
                    ans += 2*map.get(list.get(0));
                }
            }
            return;
        }
        for (int i=1; i < list.size(); i+=2){
            if (list.get(i) == -1){ // multiplication
                int next = list.get(i-1)*list.get(i+1);
                List<Integer> l2 = new ArrayList<>();
                for (int j=0; j < i-1; j++){
                    l2.add(list.get(j));
                }
                l2.add(next);
                for (int j=i+2; j < list.size(); j++){
                    l2.add(list.get(j));
                }
                dfs (l2);
            }
        }
        for (int i=1; i < list.size(); i+=2){
            if (list.get(i) == -2){ // addition
                int next = list.get(i-1)+list.get(i+1);
                List<Integer> l2 = new ArrayList<>();
                for (int j=0; j < i-1; j++){
                    l2.add(list.get(j));
                }
                l2.add(next);
                for (int j=i+2; j < list.size(); j++){
                    l2.add(list.get(j));
                }
                dfs (l2);
            }
        }
    }

    public int scoreOfStudents(String s, int[] answers) {
        for (int i : answers){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        int index=0;
        while (index < n){
            if (s.charAt(index) == '+'){
                list.add(-2);
                index++;
                continue;
            }
            else if (s.charAt(index) == '*'){
                list.add(-1);
                index++;
                continue;
            }
            int cur = 0;
            while (index < n && s.charAt(index) != '+' && s.charAt(index) != '*'){
                cur *= 10;
                cur += s.charAt(index)-'0';
                index++;
            }
            list.add(cur);
        }
        for (int i=0; i < list.size(); i++){
//            System.out.println(list.get(i));
        }
        dfs (list);
        return ans;
    }

    public static void main(String[] args) throws IOException {
        p5884_Fail a = new p5884_Fail();
        int[] answers = {512,210,210,594,210,875,762,210,210,270,342,330,210,168,767,22,462,634,194,210,552,210,210,384,210,348,210,267,553,139,210,389,614,210,825,234,900,435,210,699,454,504,300,210,210,210,215,984,210,522,943,654,793,714,870,693,210,686,210,720,153,210,957,510,210,810,210,846,714,528,942,210,342,974,210,71,906,402,726,924,388,696,210,366,210,888,825,210,210,210,654,996,846,559,210,492,210,698,210,856,576,324,822,894,666,210,935,210,840,45,641,210,210,588,708,966,462,300,210,759,480,210};
        System.out.println(a.scoreOfStudents("6+3*6+2*9+9*4+9*9+5*9+6", answers));
    }

}
