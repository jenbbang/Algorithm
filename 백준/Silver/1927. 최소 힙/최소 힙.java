import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(sc.nextLine());
            if (x == 0) {
                if (minHeap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(minHeap.poll());
                }
            } else {
                minHeap.add(x);
            }
        }
        sc.close();
    }
}