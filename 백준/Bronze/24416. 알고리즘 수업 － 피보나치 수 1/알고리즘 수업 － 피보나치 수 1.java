import java.io.*;

/*
 * 피보나치 수열의 계산 방법을 비교하는 프로그램
 * fib()는 재귀를 이용한 피보나치 계산
 * fibonacci()는 반복문을 이용한 피보나치 계산
 * 두 방식의 호출 횟수를 각각 count1, count2에 저장하여 비교
 */
public class Main {
    // 재귀 방식의 호출 횟수를 저장하는 변수
    static int count1;
    // 반복문 방식의 호출 횟수를 저장하는 변수
    static int count2;
    // 반복문 방식에서 사용할 피보나치 수열 값을 저장하는 배열
    static int[] f;

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 값을 정수로 변환하여 n에 저장
        int n = Integer.parseInt(br.readLine());

        // 피보나치 수열 값을 저장할 배열 초기화
        f = new int[n];
        br.close();

        // 카운트 변수 초기화
        count1 = 0;
        count2 = 0;

        // 재귀 방식으로 피보나치 수열 계산
        fib(n);
        // 반복문 방식으로 피보나치 수열 계산
        fibonacci(n);

        // 두 방식의 호출 횟수를 출력
        System.out.println(count1 + " " + count2);
    }

    // 재귀를 이용한 피보나치 수열 계산
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            // n이 1 또는 2일 때 호출 횟수 증가
            count1++;
            return 1;
        } else {
            // n이 1 또는 2가 아닐 때 재귀 호출
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 반복문을 이용한 피보나치 수열 계산
    static int fibonacci(int n) {
        // 초기값 설정
        f[0] = 1;
        f[1] = 1;

        // 반복문을 이용해 피보나치 수열 계산
        for (int i = 2; i < n; i++) {
            // for문의 반복 횟수가 속도를 결정
            count2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        // 배열은 0부터 시작하므로 f[n - 1]을 반환
        return f[n - 1];
    }
}