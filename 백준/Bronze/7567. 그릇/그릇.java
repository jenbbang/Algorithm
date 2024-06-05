import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int sum = 10;  // 첫 번째 그릇의 높이는 항상 10cm로 시작
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                sum += 5;  // 같은 방향으로 포개짐
            } else {
                sum += 10;  // 반대 방향으로 포개짐
            }
        }
        System.out.println(sum);
    }
}
