import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    // 고유한 숫자를 저장할 Set
    static Set<String> numbers = new HashSet<>();
    // 카드 배열
    static String[] cards;
    // 사용된 카드를 추적하기 위한 배열
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 카드의 수 n과 선택할 카드의 수 k를 입력받음
        int n = sc.nextInt(); // n = 6
        int k = sc.nextInt(); // k = 3

        // 카드 값을 저장할 배열 초기화
        cards = new String[n];
        for (int i = 0; i < n; i++) { // 입력받은 카드 값: ["72", "2", "12", "7", "2", "1"]
            cards[i] = sc.next();
        }

        // 사용된 카드를 추적할 배열 초기화
        used = new boolean[n];

        // DFS를 통해 조합을 찾기 위해 재귀 함수 호출
        dfs("", k);

        // 고유한 숫자의 개수를 출력
        System.out.println(numbers.size());
    }

    private static void dfs(String now, int k) {
        // k가 0이면 현재 조합을 Set에 추가
        if (k == 0) {
            numbers.add(now);
            return;
        }

        // 모든 카드를 탐색하며 조합 생성
        for (int i = 0; i < cards.length; i++) {
            if (!used[i]) {
                // 카드를 사용함으로 표시하고 현재 조합에 추가
                used[i] = true;
                dfs(now + cards[i], k - 1);
                // 백트래킹: 사용 표시를 해제
                used[i] = false;
            }
        }
    }
}
