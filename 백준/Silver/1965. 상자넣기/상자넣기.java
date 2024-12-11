import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(input[i]);
        }

        int[] lis = new int[n];
        int len = 0;

        for (int box : boxes) {
            int pos = Arrays.binarySearch(lis, 0, len, box);
            if (pos < 0) pos = -(pos + 1);
            lis[pos] = box;
            if (pos == len) len++;
        }

        System.out.println(len);
    }
}
