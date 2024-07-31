import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());  // 입력의 길이를 읽음
        String input = br.readLine();  // 해시 값을 계산할 문자열을 읽음

        int r = 31;
        int M = 1234567891;
        long sum = 0;
        long power = 1;

        for (int i = 0; i < L; i++) {
            sum = (sum + (input.charAt(i) - 'a' + 1) * power) % M;
            power = (power * r) % M;
        }

        System.out.println(sum);

        }
    }
