import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        HashMap<String, Integer> fruit = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String[] split = br.readLine().split(" ");
            int existValue = fruit.getOrDefault(split[0], 0);
            fruit.put(split[0], existValue + Integer.parseInt(split[1]));
        }

        if (fruit.containsValue(5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}
