import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);

            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            int zero = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == 0)
                    zero++;
            }

            Arrays.sort(arr);

            if (zero > 0) {
                for (int i = 0; i < 2; i++) {
                    arr[i] = arr[zero];
                    arr[zero++] = 0;
                }
            }

            int a = 0, b = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0)
                    a = a * 10 + arr[i];
                else
                    b = b * 10 + arr[i];
            }

            sb.append(a + b).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}