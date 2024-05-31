import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        long n=Integer.parseInt(bf.readLine());
        System.out.println(n*(n-1)* (n-2)/3/2);

        System.out.println(3); // 최고차항 차수

    }
}
