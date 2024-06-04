import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] splitIPv6Address = input.split("::", -1); // "::"로 분리, "::"가 없으면 -1로 원래 배열 유지


        String[] left = splitIPv6Address.length > 0 && !splitIPv6Address[0].isEmpty() ? splitIPv6Address[0].split(":") : new String[0];
        String[] right = splitIPv6Address.length > 1 && !splitIPv6Address[1].isEmpty() ? splitIPv6Address[1].split(":") : new String[0];


        // 완전한 IPv6 주소는 8개의 그룹이 있어야 함
        String[] IPv6 = new String[8];

        int left_ouput = 0;
        for (; left_ouput < left.length; left_ouput++) {
            IPv6[left_ouput] = left[left_ouput];
        }

        int rightOutput = right.length - 1;
        for (int i = IPv6.length - 1; i >= IPv6.length - right.length; i--) {
            IPv6[i] = right[rightOutput--];
        }

        // 빈 부분을 "0000"으로 채움
        for (int i = 0; i < IPv6.length; i++) {
            if (IPv6[i] == null) {
                IPv6[i] = "0000";
            } else {
                // 4자리 16진수로 채움
                IPv6[i] = String.format("%1$4s", IPv6[i]).replace(' ', '0');
            }
        }

        // 완전한 IPv6 주소 출력
        System.out.println(String.join(":", IPv6));
    }
}
