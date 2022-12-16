import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrayCode_fail {

    static List<Integer> gen (int n){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i=0; i < n; i++){
            int s = list.size();
            for (int j=s-1; j >= 0; j--){
                list.add(list.get(j)+1);
            }
        }
        return list;
    }

    public static List<Integer> grayCode(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i <= n; i++){
            map.put(i, new ArrayList<>());
        }
        for (int i=0; i < (1 << n); i++){
            int bit = Integer.bitCount(i);
            map.get(bit).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        List<Integer> bl = gen (n);
        int[] index = new int[n+1];
        for (int i : bl){
            ans.add(map.get(i).get(index[i]));
            index[i]++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> temp = grayCode(2);
        for (int i : temp){
            System.out.println(i);
        }
    }
}
