import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1714D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int test=0; test < q; test++){
            String s = br.readLine();
            int t = s.length();
            int n = Integer.parseInt(br.readLine());
            List<String> strings = new ArrayList<>();
            for (int i=0; i < n; i++){
                strings.add(br.readLine());
            }
            int[] min = new int[t+1]; // min[i] = least steps to get first i letters
            int[] lastIndex = new int[t+1];
            int[] lastPos = new int[t+1];
            for (int i=1; i <= t; i++){
                min[i] = -1;
                lastIndex[i] = -1;
                lastPos[i] = -1;
            }
            for (int i=0; i < t; i++){
                if (min[i] < 0) continue;
                for (int strIndex=0; strIndex < n; strIndex++){
                    String j = strings.get(strIndex);
                    for (int k=0; k < Math.min(i+1, j.length()); k++){ // k = number of characters behind
                        if (t-i >= j.length()-k){
                            int nextPos = i - k + j.length();
                            if (s.substring(i-k, nextPos).equals(j)){
                                if ((min[nextPos] > min[i]+1) || min[nextPos] == -1){
                                    min[nextPos] = min[i]+1;
                                    lastIndex[nextPos] = strIndex;
                                    lastPos[nextPos] = i;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(min[t]);
            if (min[t] > 0){
                int cur = t;
                while (cur > 0){
                    int index = lastIndex[cur];
                    int pos = cur-strings.get(index).length();
                    System.out.println((index+1) + " " + (pos+1));
                    cur = lastPos[cur];
                }
            }
        }
    }
}
