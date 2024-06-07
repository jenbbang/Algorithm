import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();

        StringTokenizer tokenizer = new StringTokenizer(str);
        int wordCount = tokenizer.countTokens();

        System.out.println(wordCount);
    }
}
