import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();  // 개행 문자 소비

        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            room[i] = sc.nextLine().toCharArray();
        }

        int horizontal = 0;
        int vertical = 0;

        // 가로로 누울 수 있는 자리 계산
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) horizontal++;
                    count = 0;
                }
            }
            if (count >= 2) horizontal++;
        }

        // 세로로 누울 수 있는 자리 계산
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) vertical++;
                    count = 0;
                }
            }
            if (count >= 2) vertical++;
        }

        System.out.println(horizontal + " " + vertical);
    }
}
