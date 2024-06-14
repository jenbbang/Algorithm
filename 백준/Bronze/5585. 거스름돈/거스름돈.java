import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pay = sc.nextInt(); //타로가 지불 할 금액
        int Changes = 1000 - pay; // 1000엔 - 지불한 금액
        System.out.println((Changes/500+Changes/100%5+Changes/50%2+Changes/10%5+Changes/5%2+Changes%5));
    }
}