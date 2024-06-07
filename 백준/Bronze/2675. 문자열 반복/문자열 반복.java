import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int T = in.nextInt(); // 테스트 케이스의 개수 입력
        for(int i = 0; i < T; i++) {  // 각 테스트 케이스에 대해 반복

            int R = in.nextInt(); // 각 문자 반복 횟수 입력
            String S = in.next();	// nextLine() 을 쓰면 공백까지 읽어버림

            for(int j = 0; j < S.length(); j++) { // 문자열의 각 문자에 대해 반복
                for(int k = 0; k < R; k++) {	// R 만큼 반복 출력
                    // ex) hello에서 j가 0 일때 S.charAt(j)은 "h"를 반환
                    System.out.print(S.charAt(j)); // 문자 출력
                }
            }

            System.out.println(); // 테스트 케이스의 결과 출력 후 줄바꿈
        }
    }
}