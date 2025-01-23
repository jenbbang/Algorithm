import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] num;
    static int[] op = new int[4]; // 0(+), 1(-), 2(*), 3(/)
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        bruteForce(1, num[0]);
        System.out.println(max + "\n" + min);
        br.close();
    }

    private static void bruteForce(int idx, int cur) {
        if (idx == n) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                int nextValue = calculate(cur, i, num[idx]);
                bruteForce(idx + 1, nextValue);
                op[i]++;
            }
        }
    }

    private static int calculate(int y, int opIndex, int x) {
        switch (opIndex) {
            case 0: return y + x; // +
            case 1: return y - x; // -
            case 2: return y * x; // *
            case 3: return (y < 0) ? -(-y / x) : y / x; // /
            default: return 0;
        }
    }
}
