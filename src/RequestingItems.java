import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class RequestingItems {

    static class Item {
        int order;
        int time;

        public Item(int order, int time) {
            this.order = order;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Item> stack = new Stack<>();
        List<Item> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            if (stack.isEmpty()){
                stack.add(new Item (i+1, arr[i]+2*t));
            }
            else {
                int elapsed = 0;
                while (arr[i] >= stack.peek().time + elapsed){
                    stack.pop();

                }
            }
        }
    }
}
