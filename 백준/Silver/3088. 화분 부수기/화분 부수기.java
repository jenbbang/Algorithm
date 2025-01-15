import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String data;
        int[][] flowerpot = new int[N][3];
        boolean[] isBreak = new boolean[1000001];
        int answer = 0, val = 0;

        for (int i = 0; i < N; i++) {
            data = bf.readLine();
            StringTokenizer st = new StringTokenizer(data);
            boolean check = true;
            for (int j = 0; j < 3; j++) {
                flowerpot[i][j] = Integer.parseInt(st.nextToken());
                val = flowerpot[i][j];

                if (isBreak[val]) {
                    check = false;
                } else {
                    isBreak[val] = true;
                }
            }
            if (check) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
