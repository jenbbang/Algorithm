import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String arr[][] = new String[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();

        }
        Arrays.sort(arr, new Comparator<String[]>() {
            //좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
            @Override
            public int compare(String[] s1, String[] s2) {
                int xCompare = Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
                if (xCompare == 0) {
                    return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
                }
                return xCompare;
            }
        });
        for (int i = 0; i < N; i++) {
            bw.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }
        bw.flush();
        br.close();
        bw.close();
    }
}



