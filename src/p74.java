import java.util.*;

public class p74 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> first = new ArrayList<>();
            for (int i=0; i < m; i++){
                first.add(matrix[i][0]);
            }
            int index = Collections.binarySearch(first, target);
            if (index >= 0) return true;
            index = -(index+1);
            int i2 = Arrays.binarySearch(matrix[index], target);
            return i2 >= 0;
        }
    }
}
