import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        int min = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            list.add((int)(Math.random()*(max - min + 1) + min));
        }
        Collections.sort(list);
        for (int i : list){
            System.out.println(i);
        }
    }
}
