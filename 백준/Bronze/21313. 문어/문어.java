import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean odd = false; // 홀수, 짝수일 경우에 수열이 달라지므로 구분해준다

        if (N % 2 == 1) {
            odd = true; // 홀수면 홀수라고 표시
            N--; // 홀수일 경우에는 마지막에 3이 들어갈 거기 때문에 -1을 해준다
        }

        while (N > 0) { // N이 --되면서 0이 될 때까지 반복
            if (N % 2 == 0) {
                System.out.print("1 ");
            } else {
                System.out.print("2 ");
            }
            N--;
        }

        if (odd) { // 홀수라면 마지막에 3을 붙여준다
            System.out.print("3 ");
        }
    }
}
