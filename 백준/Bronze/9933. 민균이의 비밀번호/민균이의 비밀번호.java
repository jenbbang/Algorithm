import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            String reverse = new StringBuffer(word).reverse().toString();
            if (set.contains(reverse) || word.equals(reverse)) {
                System.out.println(word.length() + " " + word.charAt(word.length() / 2));
                return;
            } else {
                set.add(word);
            }
        }
    }
}