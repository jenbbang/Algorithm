import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(n==4||n==7?-1:n-2*n/5*2);
    }
}

