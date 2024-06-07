import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int row = 1; row <= N; row++) { // row = 1, 2, 3, 4, 5
            for (int column = 1; column <= N - row; column++) { // column은 row의 수만큼 더해서 반복한다
                System.out.print(" "); // N - row이 찍히고
            }
            for (int column = 0; column < row; column++) { // column은 row의 수만큼 더해서 반복한다
                System.out.print("*"); // 그 반복만큼 *을 찍는다.
            }
            System.out.println("");// 줄바꿈
        }
    }
}