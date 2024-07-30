import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 1;
        while (sum < N) {
            sum += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}
