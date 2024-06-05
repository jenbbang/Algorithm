import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String L = sc.nextLine();
            String[] arr = L.split(" ");
            for (int j = 0; j < arr.length; j++) {
                stack.push(arr[j]);

            }
            System.out.print("Case #" + (i + 1) + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
                System.out.print(" ");
                if (stack.isEmpty())
                    System.out.println();
            }
        }
    }
}
