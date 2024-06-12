import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수업 시간
        int t = sc.nextInt();

        // 각 수업 시간에 대해 반복
        for (int i = 0; i < t; i++) {
            int d = sc.nextInt();
            int max = 0;

            // 가능한 최대 지각 시간을 찾기 위한 반복문
            for (int j = 0; j * j <= d - j; j++) {
                // 조건을 만족하는 j 값을 max에 저장
                max = j;
            }
            System.out.println(max);
        }
    }
}