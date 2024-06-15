import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 전화번호 두 개 입력 받기
        String phone_A = sc.nextLine();
        String phone_B = sc.nextLine();

        // 교차 배열 초기화
        StringBuilder max = new StringBuilder();
        for (int i = 0; i < phone_A.length(); i++) {
            max.append(phone_A.charAt(i));
            max.append(phone_B.charAt(i));
        }

        // 숫자 합산 과정
        while (max.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < max.length() - 1; i++) {
                int sum = (Character.getNumericValue(max.charAt(i)) + Character.getNumericValue(max.charAt(i + 1))) % 10;
                next.append(sum);
            }
            max = next;
        }

        // 최종 결과 출력
        System.out.println(max.toString());

        sc.close();
    }
}
