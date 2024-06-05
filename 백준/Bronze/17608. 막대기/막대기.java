import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int H = sc.nextInt();
            stack.push(H);

        }
        int count = 0; // 보이는 막대기의 수
        int maxHeight = 0; // 현재까지 가장 높은 막대기의 높이

        while (!stack.isEmpty()) {
            int height = stack.pop();
            if (height > maxHeight) {
                maxHeight = height;
                count++;
            }
        }

        System.out.println(count); // 결과 출력
    }
}