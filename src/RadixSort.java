import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RadixSort {

    public static int numDigits (int n){
        int ans = 0;
        while (n > 0){
            n /= 10;
            ans++;
        }
        return ans;
    }

    public static int getDigit (int n, int digit){
        int pow = (int)Math.pow(10, digit);
        return (n/pow)%10;
    }

    public static int[] sortPos (List<Integer> nums){
        List<List<List<Integer>>> bins = new ArrayList<>();
        for (int i=0; i < 2; i++){
            bins.add(new ArrayList<>());
            for (int j=0; j < 10; j++){
                bins.get(i).add(new ArrayList<>());
            }
        }
        // put elements in initally
        for (int i : nums){
            bins.get(0).get((i+10)%10).add(i);
        }
        int maxDigits = 0;
        int curBins = 0;
        for (int i : nums) maxDigits = Math.max(maxDigits, numDigits(i));
        for (int i=1; i < maxDigits; i++){
            curBins = (i-1)%2;
            int nextBins = i%2;
            for (int j=0; j < 10; j++){
                for (int k : bins.get(curBins).get(j)){
                    int curDigit = getDigit (k, i);
                    bins.get(nextBins).get(curDigit).add(k);
                }
            }
            for (int j=0; j < 10; j++){
                bins.get(curBins).get(j).clear();
            }
            curBins = (curBins+1)%2;
        }
        int[] ans = new int[nums.size()];
        int index = 0;
        for (int j=0; j < 10; j++){
            for (int k : bins.get((curBins)%2).get(j)){
                ans[index] = k;
                index++;
            }
        }
        return ans;
    }

    public static int[] radixSort (int[] nums){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i : nums){
            if (i >= 0){
                pos.add(i);
            }
            else {
                neg.add(-i);
            }
        }
        int[] posArr = sortPos(pos);
        int[] negArr = sortPos(neg);
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i=neg.size()-1; i >= 0; i--){
            ans[index] = -negArr[i];
            index++;
        }
        for (int i=0; i < pos.size(); i++){
            ans[index] = posArr[i];
            index++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = radixSort(arr);
        for (int i=0; i < n; i++){
            System.out.println(sorted[i]);
        }
    }
}
