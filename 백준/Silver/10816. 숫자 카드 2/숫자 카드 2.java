import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 입력된 숫자 배열을 해시맵에 저장하며 등장 횟수를 기록
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 찾고자 하는 숫자가 해시맵에 몇 번 등장하는지 출력
        for (int i = 0; i < m; i++) {
            int m2 = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(m2, 0) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
