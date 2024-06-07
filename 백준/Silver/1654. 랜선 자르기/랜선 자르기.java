import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
//            max = Math.max(max, arr[i]);

        }
        long max = Arrays.stream(arr).max().orElseThrow();
        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = Arrays.stream(arr).map(x -> x / mid).sum();

            if (sum >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
