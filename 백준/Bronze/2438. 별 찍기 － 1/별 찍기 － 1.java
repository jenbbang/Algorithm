import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int row = 1; row <= N; row++) { // row = 1부터 N까지 반복한다
            for (int column = 0; column < row; column++) { // column은 0부터 row의 수만큼 반복한다
                System.out.print("*"); // 그 반복만큼 *을 찍는다.
            }
            System.out.println("");// 줄바꿈
        }
    }
}