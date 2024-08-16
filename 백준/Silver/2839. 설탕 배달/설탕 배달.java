import java.io.BufferedReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n >= 0) {
            if (n % 5 == 0) {
                count += n / 5;
                break;
            } else {
                n -= 3;
                count++;
            }
        }
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
