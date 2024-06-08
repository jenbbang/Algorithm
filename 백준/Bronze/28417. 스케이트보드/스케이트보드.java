import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력받은 선수 수
        int N = sc.nextInt();

        // 최고 점수를 저장할 변수
        int maxScore = 0;

        // 각 선수의 점수를 계산
        for (int i = 0; i < N; i++) {
            int[] scores = new int[7];

            // 점수 입력
            for (int j = 0; j < 7; j++) {
                scores[j] = sc.nextInt();
            }

            // 두 차례의 런 점수 중 최고 점수와 다섯 차례의 트릭 점수 중 상위 2개의 점수를 합산하여 최종 점수를 계산
            int[] runScores = Arrays.copyOfRange(scores, 0, 2); // 런 점수
            int[] trickScores = Arrays.copyOfRange(scores, 2, 7); // 트릭 점수

            Arrays.sort(runScores); // 런 점수 정렬
            Arrays.sort(trickScores); // 트릭 점수 정렬

            int currentSum = runScores[1] + trickScores[3] + trickScores[4]; // 상위 점수 3개 합산

            // 최고 점수와 비교하여 최고 점수를 갱신
            if (currentSum > maxScore) {
                maxScore = currentSum;
            }
        }

        // 결과 출력
        System.out.println(maxScore);
    }
}
