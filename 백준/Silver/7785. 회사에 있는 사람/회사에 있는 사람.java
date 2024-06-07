import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashSet<String> set = new HashSet<>();


        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String state = sc.next();

            if (state.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name); // 0(N) --> 0(1)
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());

        for (String name : list) {
            System.out.println(name + " ");
        }
    }
}
