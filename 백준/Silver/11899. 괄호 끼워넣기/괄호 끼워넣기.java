import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        // Stack을 사용하여 괄호를 추적
        Stack<Character> stack = new Stack<>();

        // 열림 괄호와 닫힘 괄호를 추적하는 변수 초기화
        int open = 0;
        int close = 0;

        // 문자열의 각 문자에 대해 반복
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // 현재 문자가 '('인 경우 스택에 푸시
            if (c == '(') {
                stack.push(c);
            }
            // 현재 문자가 ')'인 경우
            else if (c == ')') {
                // 스택이 비어 있지 않고 스택의 맨 위가 '('인 경우
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // 스택에서 '('를 팝
                    stack.pop();
                } else {
                    // 스택이 비어 있거나 스택의 맨 위가 '('가 아닌 경우 닫힘 괄호 개수 증가
                    close++;
                }
            }
        }

        // 스택에 남아있는 '('의 개수를 열림 괄호 개수로 설정
        open = stack.size();

        // 열림 괄호와 닫힘 괄호의 합을 출력
        System.out.println(open + close);
    }
}