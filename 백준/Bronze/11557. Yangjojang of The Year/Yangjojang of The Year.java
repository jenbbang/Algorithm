import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            Map<String, Integer> map = new HashMap<>();
           for (int j = 0; j < N; j++) {
               String S = sc.next();
               int L = sc.nextInt();
               sc.nextLine();

               map.put(S, L);
           }
            String school = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println(school);
        }
    }
}
