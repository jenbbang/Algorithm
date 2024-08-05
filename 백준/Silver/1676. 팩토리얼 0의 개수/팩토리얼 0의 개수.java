import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N > 0) {
            N /= 5;
            count += N;
        }
        System.out.println(count);
    }
}
