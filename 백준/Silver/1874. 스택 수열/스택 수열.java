import java.io.*;
import java.util.Stack;

/*

push연산 :  +
pop 연산 :  -
불가능한 경우 : NO

push하는 순서는 반드시 오름차순을 지킬것

 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(); 
        int N = Integer.parseInt(br.readLine()); // 입력 수열의 길이를 읽음
        Stack<Integer> stack = new Stack<>(); // 정수를 저장할 스택 생성
        int last = 0; // 마지막으로 push된 숫자를 기록하기 위한 변수

        // 수열의 길이만큼 반복
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine()); // 현재 수열에서 목표로 하는 숫자

            // 목표 숫자가 last보다 크다면, 목표 숫자까지 스택에 push
            if (n > last) {
                for (int j = last + 1; j <= n; j++) {
                    stack.push(j); // j를 스택에 push
                    sb.append("+\n"); // push 연산 기록
                }
                last = n; // 마지막으로 push된 숫자 업데이트
            }

            // 스택의 top이 목표 숫자와 같다면 pop
            if (stack.get(stack.size() - 1) == n) {
                stack.pop(); // 스택의 top을 pop
                sb.append("-\n"); // pop 연산 기록
            }
        }
        
        if (stack.size() > 0) {
            bw.write("NO\n");
        } else {
            bw.write(sb + "\n");
        }

        bw.flush(); 
        bw.close(); 
    }
}