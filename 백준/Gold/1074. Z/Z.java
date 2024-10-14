import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        
        System.out.println(zOrder(N, r, c));
    }

    public static int zOrder(int N, int r, int c) {
        if (N == 0) return 0;

        int half = 1 << (N - 1); // 2^(N-1)
        if (r < half && c < half) {
            return zOrder(N - 1, r, c);
        } else if (r < half && c >= half) {
            return half * half + zOrder(N - 1, r, c - half);
        } else if (r >= half && c < half) {
            return 2 * half * half + zOrder(N - 1, r - half, c);
        } else {
            return 3 * half * half + zOrder(N - 1, r - half, c - half);
        }
    }
}