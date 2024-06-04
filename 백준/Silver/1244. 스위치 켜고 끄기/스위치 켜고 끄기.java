import java.io.IOException;
import java.util.Scanner;

/*
8                스위치 개수
0 1 0 1 0 0 0 1  스위치의 현 상태
2                학생수
1 3              성별 / 받은 수
2 3              성별 / 받은 수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 스위치 개수 입력
        int switchCount = sc.nextInt();
        int[] switches = new int[switchCount];

        // 초기 스위치 상태 입력
        for (int i = 0; i < switchCount; i++) {
            switches[i] = sc.nextInt();
        }

        // 학생 수 입력
        int studentCount = sc.nextInt();

        // 학생이 받은 수 입력 및 스위치 조작
        for (int i = 0; i < studentCount; i++) {
            int gender = sc.nextInt();  // 성별 입력
            int number = sc.nextInt();  // 받은 수 입력

            if (gender == 1) {  // 남학생인 경우
                // 받은 수의 배수인 스위치의 상태를 반전시킴
                for (int j = number; j <= switchCount; j += number) {
                    switches[j - 1] = 1 - switches[j - 1];
                }
            } else if (gender == 2) {  // 여학생인 경우
                // 받은 수와 같은 번호의 스위치를 중심으로 좌우 대칭인 가장 큰 구간의 스위치 상태를 반전시킴
                int left = number - 1;
                int right = number - 1;
                while (left >= 0 && right < switchCount && switches[left] == switches[right]) {
                    left--;
                    right++;
                }
                left++;
                right--;
                for (int j = left; j <= right; j++) {
                    switches[j] = 1 - switches[j];
                }
            }
        }

        // 최종 스위치 상태 출력
        for (int i = 0; i < switchCount; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) {  // 한 줄에 최대 20개의 스위치 상태를 출력
                System.out.println();
            }
        }
    }
}
