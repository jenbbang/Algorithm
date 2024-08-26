import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()); //이미 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수
        
        long [] arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        long max = Arrays.stream(arr).max().orElseThrow();
        long start = 1;
        long end = max ;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = Arrays.stream(arr).map(x -> x / mid).sum();
            if (sum >= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
