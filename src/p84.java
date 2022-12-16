import java.util.Stack;

public class p84 {

    static class Point {
        int index;
        int h;

        public Point(int index, int h) {
            this.index = index;
            this.h = h;
        }
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i=0; i < n; i++){
            left[i] = -1;
            right[i] = n;
        }
        Stack<Point> stack = new Stack<>();
        for (int i=0; i < n; i++){
            while (!stack.isEmpty()){
                if (heights[i] < stack.peek().h){
                    right[stack.pop().index] = i;
                }
                else {
                    break;
                }
            }
            stack.add(new Point (i, heights[i]));
        }
        stack.clear();
        for (int i=n-1; i >= 0; i--){
            while (!stack.isEmpty()){
                if (heights[i] < stack.peek().h){
                    left[stack.pop().index] = i;
                }
                else {
                    break;
                }
            }
            stack.add(new Point (i, heights[i]));
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            ans = Math.max(ans, heights[i]*(right[i]-left[i]-1));
        }
        return ans;
    }

}
