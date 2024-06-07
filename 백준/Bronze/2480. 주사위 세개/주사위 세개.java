import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int prize;

        if (a == b && b == c) {
            // 모든 눈이 같은 경우
            prize = 10000 + a * 1000;
        } else if (a == b || b == c || a == c) {
            // 두 개의 눈이 같은 경우
            if (a == b || a == c) {
                prize = 1000 + a * 100;
            } else {
                prize = 1000 + b * 100;
            }
        } else {
            // 모두 다른 경우
            int max = Math.max(a, Math.max(b, c));
            prize = max * 100;
        }

        System.out.println(prize);
    }
}