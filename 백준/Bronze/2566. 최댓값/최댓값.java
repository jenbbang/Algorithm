import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 9x9 크기의 2차원 배열 선언
        int[][] matrix = new int[9][9];

        // 최댓값을 저장할 변수 선언
        int max = Integer.MIN_VALUE;
        // 행과 열 번호를 저장할 변수 선언
        int x = 0;
        int y = 0;

        // 2차원 배열에 입력값을 넣어주는 for문
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = sc.nextInt();

                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);

        sc.close();
    }
}
