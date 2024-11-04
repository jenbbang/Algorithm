import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);
        long C = Long.parseLong(input[2]);
        
        long result = modularExponentiation(A, B, C);
        System.out.println(result);
    }

    static long modularExponentiation(long A, long B, long C) {
        if (B == 0) {
            return 1; // A^0 = 1
        }
        long half = modularExponentiation(A, B / 2, C);
        long result = (half * half) % C; // (A^(B/2))^2 % C

        if (B % 2 != 0) {
            result = (result * A) % C; // A^(B) = A * (A^(B-1))
        }
        
        return result;
    }
}
