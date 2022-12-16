import java.util.ArrayList;
import java.util.List;

public class p1419 {

    public static boolean isValid (int[] count){
        for (int i=1; i < 5; i++){
            if (count[i] != count[0]){
                return false;
            }
        }
        return true;
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        int[] count = new int[5];
        int[] arr = new int[n];
        for (int i=0; i < n; i++){
            char c = croakOfFrogs.charAt(i);
            if (c == 'c'){
                count[0]++;
                arr[i] = 0;
            }
            else if (c == 'r'){
                count[1]++;
                arr[i] = 1;
            }
            else if (c == 'o'){
                count[2]++;
                arr[i] = 2;
            }
            else if (c == 'a'){
                count[3]++;
                arr[i] = 3;
            }
            else if (c == 'k'){
                count[4]++;
                arr[i] = 4;
            }
            else {
                return -1;
            }
        }
        if (!isValid(count)) return -1;
        int[] curCount = new int[5];
        int ans = 0;
        for (int i=0; i < n; i++){
            curCount[arr[i]]++;
            if (arr[i] == 0){
                ans = Math.max(ans, curCount[arr[i]]);
            }
            else {
                if (curCount[arr[i]] > curCount[arr[i]-1]){
                    return -1;
                }
            }
            if (arr[i] == 4){
                for (int j=0; j < 5; j++){
                    curCount[j]--;
                }
            }
        }
        return ans;
    }
}
