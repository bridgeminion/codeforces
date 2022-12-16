import java.io.IOException;
import java.util.*;

public class p5884 {

    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> found = new HashSet<>();
    int ans = 0;
    boolean correct = true;

    public void dfs (int n, int[] arr, boolean[] vis){

    }

    public int scoreOfStudents(String s, int[] answers) {
        for (int i : answers){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        int n = s.length();
        List<Integer> list = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int index=0;
        while (index < n){
            if (s.charAt(index) == '+'){
                op.add(-2);
                index++;
                continue;
            }
            else if (s.charAt(index) == '*'){
                op.add(-1);
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

        return ans;
    }

    public static void main(String[] args) throws IOException {
        p5884 a = new p5884();
        int[] answers = {512,210,210,594,210,875,762,210,210,270,342,330,210,168,767,22,462,634,194,210,552,210,210,384,210,348,210,267,553,139,210,389,614,210,825,234,900,435,210,699,454,504,300,210,210,210,215,984,210,522,943,654,793,714,870,693,210,686,210,720,153,210,957,510,210,810,210,846,714,528,942,210,342,974,210,71,906,402,726,924,388,696,210,366,210,888,825,210,210,210,654,996,846,559,210,492,210,698,210,856,576,324,822,894,666,210,935,210,840,45,641,210,210,588,708,966,462,300,210,759,480,210};
        System.out.println(a.scoreOfStudents("6+3*6+2*9+9*4+9*9+5*9+6", answers));
    }
}
