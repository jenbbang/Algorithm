import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;

        // 1부터 N까지 곱하여 팩토리얼을 계산
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println(sum);
    }
}