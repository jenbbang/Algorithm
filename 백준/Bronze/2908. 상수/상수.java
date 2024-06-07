import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int reversedA = reverseNumber(A);
        int reversedB = reverseNumber(B);

        if (reversedA > reversedB) {
            System.out.println(reversedA);
        } else {
            System.out.println(reversedB);
        }
    }

    private static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }
}