import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBIT {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {3, 4, 1, 7};
        BinaryIndexedTree bit = new BinaryIndexedTree(arr);
        System.out.println(bit.getSum(0));
        System.out.println(bit.getSum(1));
        System.out.println(bit.getSum(3));
        bit.updateBIT(1, -10);
        bit.updateBIT(3, 9);
        System.out.println(bit.getSum(0));
        System.out.println(bit.getSum(1));
        System.out.println(bit.getSum(3));
    }
}
