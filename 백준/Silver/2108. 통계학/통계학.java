import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        double sum = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        //정렬
        Arrays.sort(arr);

        int count = 1;  // 초깃값을 1로 설정해야 처음 비교 시 0으로 시작하지 않음
        int max = 0;
        int mod = arr[0];
        boolean check = false;

        // 최빈값 구하는 반복문
        for(int i = 0; i < N - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                count++;
            } else {
                count = 1; // 새 숫자가 나타나면 카운트를 1로 초기화
            }

            if(max < count) {
                max = count;
                mod = arr[i];
                check = true;
            } else if(max == count && check) {
                mod = arr[i];
                check = false;
            }
        }

        // 한 줄로 출력하기
        System.out.println((int)Math.round(sum / N)); // 산술평균
        System.out.println(arr[(N - 1) / 2]); // 중앙값
        System.out.println(mod); // 최빈값
        System.out.println(arr[N - 1] - arr[0]); // 범위
    }
}
