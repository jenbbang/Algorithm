import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = new String[5];

        for (int i = 0; i < 5; i++) {
            line[i] = sc.nextLine();
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < line[j].length()) {
                    System.out.print(line[j].charAt(i));
                }
            }
        }
    }
}
