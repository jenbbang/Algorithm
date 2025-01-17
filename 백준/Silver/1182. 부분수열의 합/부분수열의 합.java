import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int N, S, cnt = 0;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[] firstLine = reader.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]); // 정수 개수
        S = Integer.parseInt(firstLine[1]); // 목표 합이 되는 수
        
        num = new int[N]; // 정수 담는 배열 

        String[] secondLine = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(secondLine[i]);
        }
        
        dfs(0, 0);
        
        if (S == 0) // 부분수열의 크기가 0일 때를 고려
            cnt -= 1;
        
        System.out.println(cnt);
    } // main()
    
    static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) cnt++;
            return;
        }
        
        dfs(depth + 1, sum + num[depth]); // 지금 위치 원소를 선택했거나
        dfs(depth + 1, sum); // 안 했거나
    }
}
