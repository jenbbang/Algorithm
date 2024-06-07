import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        // Append "??!" to the input string
        String result = username + "??!";

        // Print the result
        System.out.println(result);
    }
}