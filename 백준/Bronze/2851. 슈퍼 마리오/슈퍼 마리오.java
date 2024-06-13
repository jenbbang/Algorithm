import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mushroom = new int[10];

        int sum = 0;

        for (int i = 0; i < mushroom.length; i++) {
            mushroom[i] = sc.nextInt();
            if (sum + mushroom[i] <= 100) {
                sum += mushroom[i];
            } else {
                if (Math.abs(100 - (sum + mushroom[i])) <= Math.abs(100 - sum)) {
                    sum += mushroom[i];
                }
                break;
            }
        }
        System.out.println(sum);
    }
}