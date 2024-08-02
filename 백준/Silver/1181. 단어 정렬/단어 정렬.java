import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });

        for (String word : list) {
            System.out.println(word);
        }
    }
}