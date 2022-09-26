public class BinaryIndexedTree {

    static int[] BIT;
    static int n;

    public BinaryIndexedTree (int[] arr){
        n = arr.length;
        BIT = new int[n+1];
        for (int i = 0; i < n; i++)
            updateBIT(i, arr[i]);
    }

    int getSum(int index) {
        int sum = 0;
        index = index + 1;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }

    void updateBIT(int index, int val) { // val is delta
        index = index + 1;
        while (index <= n) {
            BIT[index] += val;
            index += index & (-index);
        }
    }

}
