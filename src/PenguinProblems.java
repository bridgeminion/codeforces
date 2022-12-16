import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PenguinProblems {

    public static class BinaryIndexedTree {

        int[] bit;

        public BinaryIndexedTree (int n) {
            bit = new int[n+1];
        }

        public void updateBIT (int val, int index){
            index++;
            while (index < bit.length){
                bit[index] += val;
                index = getNext(index);
            }
        }

        public int getSum (int index){
            index++;
            int sum = 0;
            while (index > 0){
                sum += bit[index];
                index = getParent(index);
            }
            return sum;
        }

        public void createTree (int[] input){
            for (int i=1; i <= input.length; i++){
                updateBIT(input[i-1], i);
            }
        }

        private int getParent (int index){
            return index - (index & -index);
        }

        private int getNext (int index){
            return index + (index & -index);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++) s[i] = Integer.parseInt(st.nextToken());
        BinaryIndexedTree bit = new BinaryIndexedTree(n+1);
        bit.createTree(s);
        int[] l = new int[t];
        int[] r = new int[t];
        for (int i=0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            r[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i < d; i++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int[] members = new int[q];
            for (int j=0; j < q; j++){
                members[j] = Integer.parseInt(st.nextToken());
                bit.updateBIT(1, members[j]);
            }
//            for (int j=0; j <= n; j++){
//                System.out.println(bit.getSum(j));
//            }
//            System.out.println("next");
            System.out.print("Day " + (i+1) + ": ");
            for (int j=0; j < t; j++){
                int right = bit.getSum(r[j]);
//                System.out.println("right " + right);
                int left = bit.getSum(l[j]-1);
//                System.out.println("left " + left);
                int ans = right-left;
                if (j != 0){
                    System.out.print(" " + ans);
                }
                else {
                    System.out.print(ans);
                }
            }
            System.out.println();
        }
    }
}
