

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String N = bf.readLine();

        for (int i = 0; i < N.length(); i++) {
            System.out.print(N.charAt(i));
            if (i % 10 == 9) {
                System.out.println();
            }
        }

    }

}
