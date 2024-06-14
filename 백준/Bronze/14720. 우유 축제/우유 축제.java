import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 우유 가게 수
        int sum = 0;
        int nextMilk = 0; // 다음에 마셔야 할 우유 (0: 딸기, 1: 초코, 2: 바나나)

        for (int i = 0; i < n; i++) {
            int milk = sc.nextInt();
            if (milk == nextMilk) {
                sum++;
                nextMilk = (nextMilk + 1) % 3; // 우유 마시는 순서 업데이트
            }
        }
        System.out.println(sum);
    }
}
