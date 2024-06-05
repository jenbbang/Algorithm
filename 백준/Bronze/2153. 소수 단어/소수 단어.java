import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        int sum = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sum += c - 'a' + 1;
            } else if (Character.isUpperCase(c)) {
                sum += c - 'A' + 27;
            }
        }
        System.out.println(isPrime(sum) ? "It is a prime word." : "It is not a prime word.");
    }

    private static boolean isPrime(int number) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}