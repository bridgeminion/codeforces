import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int pow = 1;
        for (int i=0; i < n; i++){
            int s = ans.size();
            for (int j=s-1; j >= 0; j--){
                ans.add((ans.get(j)+pow));
            }
            pow *= 2;
        }
        return ans;
    }
}
