import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 구간의 합을 저장할 변수를 초기화
        int sum = 0;

        // 수열을 저장할 ArrayList를 생성
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 수열 생성
        int i = 1;
        while (i <= 1000) {  // 1부터 1000까지 반복합
            for (int j = 1; j <= i; j++) {  // i를 i번 리스트에 추가
                list.add(i);
            }
            i++;
        }

        // A부터 B까지의 합을 계산합
        for (int k = A - 1; k < B; k++) {  // 리스트의 인덱스는 0부터 시작하므로 A-1부터 시작
            sum += list.get(k);  // 해당 구간의 값을 sum에 더하기
        }


        System.out.println(sum);
    }
}