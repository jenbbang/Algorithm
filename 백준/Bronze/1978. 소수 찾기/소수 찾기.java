import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 참가자의 수

        int arr;

        int count = 0; // 소수의 개수를 저장할 변수

        for (int i = 0; i < n; i++) {
            arr = sc.nextInt();
            for (int j = 2; j <= arr; j++) {
                if (j == arr) {
                    count++;
                }
                if (arr % j == 0) {
                    break;
                }
            }

        }
        System.out.println(count);
    }
}

