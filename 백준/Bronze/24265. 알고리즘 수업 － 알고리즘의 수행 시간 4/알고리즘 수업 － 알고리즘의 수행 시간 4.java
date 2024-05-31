import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
코드 작성 방법
1. 코드 1의 수행횟수는 n 번 => for문이 n번 반복 계산을 하여서
2. 차수는 1 => n번의 실행 즉, n의 1승

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        long n=Integer.parseInt(bf.readLine());

        System.out.println((n-1)*n/2);
        System.out.println(2); // 최고차항 차수

    }
}
