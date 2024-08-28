import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] set = new boolean[21];  // 1~20까지 인덱스 사용

        int m = Integer.parseInt(br.readLine());  // 연산의 수

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int xAdd = Integer.parseInt(st.nextToken());
                    set[xAdd] = true;
                    break;
                case "remove":
                    int xRemove = Integer.parseInt(st.nextToken());
                    set[xRemove] = false;
                    break;
                case "check":
                    int xCheck = Integer.parseInt(st.nextToken());
                    sb.append(set[xCheck] ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int xToggle = Integer.parseInt(st.nextToken());
                    set[xToggle] = !set[xToggle];
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = false;
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}
