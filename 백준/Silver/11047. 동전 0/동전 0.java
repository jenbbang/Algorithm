import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
동전을 사용하여 가치의 합을 k로 만들려고한다
필요한 동전 개수의 최솟값을 구하기

N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다.
(1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int money [] = new int [n];

        for (int i = 0; i < n; i++) {
           money[i] = Integer.parseInt(br.readLine());
        }
        while (true) {
            if (money[n - 1] <= k) {
                cnt += k / money[n - 1];
                k = k % money[n - 1];
                if (k == 0) {
                    break;
                }
            }
            n--;
        }
        System.out.println(cnt);

    }
}


