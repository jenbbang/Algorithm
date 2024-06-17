import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        int count = 0;

        for (int i = 1; count < b; i++) {
            for (int j = 0; j < i; j++) {
                count++;
                if (count >= a && count <= b) {
                    sum += i;
                }
                if (count == b) {
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
