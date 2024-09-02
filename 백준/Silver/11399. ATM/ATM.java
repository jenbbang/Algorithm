import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] times = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(times[i]);
        }
        Arrays.sort(arr);

        int totalWaitingTime = 0;
        int cumulativeTime = 0;
        for (int time : arr) {
            cumulativeTime += time;
            totalWaitingTime += cumulativeTime;
        }

        System.out.println(totalWaitingTime);
    }
}
