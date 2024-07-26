import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] size = new int[6];
        for (int i = 0; i < size.length; i++) {
            size[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        int p = sc.nextInt();

        int count = 0;

        for (int i = 0; i < size.length; i++) {
            count += size[i] / t;
            if (size[i] % t != 0) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(n / p + " " + n % p);
    }
}