import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<Integer> tickets = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            tickets.add(A);
        }

        int smalltickets = 1;
        while (tickets.contains(smalltickets)) {
            smalltickets++;
        }

        System.out.println(smalltickets);
    }
}
