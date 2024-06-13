import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long sum = 1;

        for(int i = 0; i < 5; i++) {
            sum *= n - i;
        }

        for(int i = 0; i < 5; i++) {
            sum /= (i + 1);
        }
        System.out.println(sum);
    }
}