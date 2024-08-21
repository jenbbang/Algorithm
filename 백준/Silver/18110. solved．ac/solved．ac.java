import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int removeCount = (int) Math.round(n * 0.15); // 15%를 제거할 개수 계산 (올림 처리)

        double sum = 0;
        for (int i = removeCount; i < arr.length - removeCount; i++) {
            sum += arr[i];
        }
        double result = sum / (arr.length - 2 * removeCount); // 평균 계산

        System.out.println(Math.round(result)); // 결과 출력 (반올림하여 정수로 출력)
    }
}
