import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <=n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            queue.poll(); //맨 앞 버림 
            queue.offer(queue.poll()); // 맨 앞 버림 + 버린 숫자를 맨 뒤에 넣음 
        }
        System.out.println(queue.poll()); // 마지막에 남은 수 출력 
    }
}