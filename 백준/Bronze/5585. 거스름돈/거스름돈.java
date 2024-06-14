import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pay = sc.nextInt(); //타로가 지불 할 금액
        int Changes = 1000 - pay; // 1000엔 - 지불한 금액

        int[] bank = {500, 100, 50, 10, 5, 1}; // 동전 배열
        int count = 0; // 필요한 동전의 개수를 저장할 변수

        for (int circuit : bank) { // 각 동전의 단위를 순회
            count += Changes / circuit; // 잔돈을 현재 동전 단위로 나눈 후 count에 더함
            Changes %= circuit; // 잔돈을 현재 동전 단위로 나눈 나머지를 Changes에 저장 
        }

        System.out.println(count);


    }
}