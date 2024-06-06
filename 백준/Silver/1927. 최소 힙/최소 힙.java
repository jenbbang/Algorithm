import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->  {
//                return o1-o2;
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2; // 더 작은 값
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                int answer = pq.isEmpty() ? 0 : pq.poll();
                System.out.println(answer);
            } else {
                pq.offer(x);
            }
        }
    }
}