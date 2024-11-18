import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int goodWordCount = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char c : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop(); // 같은 문자가 있으면 쌍 제거
                } else {
                    stack.push(c); // 쌍이 없으면 스택에 추가
                }
            }

            if (stack.isEmpty()) {
                goodWordCount++; // 스택이 비어 있으면 좋은 단어
            }
        }

        System.out.println(goodWordCount);
    }
}
