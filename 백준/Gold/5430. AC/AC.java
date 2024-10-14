import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayInput = br.readLine();
            
            Deque<Integer> deque = new LinkedList<>();
            if (n > 0) {
                StringTokenizer st = new StringTokenizer(arrayInput.substring(1, arrayInput.length() - 1), ",");
                while (st.hasMoreTokens()) {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                }
            }
            
            boolean isReversed = false;
            boolean error = false;
            
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }
            
            if (error) {
                result.append("error\n");
            } else {
                result.append("[");
                if (isReversed) {
                    while (!deque.isEmpty()) {
                        result.append(deque.removeLast());
                        if (!deque.isEmpty()) {
                            result.append(",");
                        }
                    }
                } else {
                    while (!deque.isEmpty()) {
                        result.append(deque.removeFirst());
                        if (!deque.isEmpty()) {
                            result.append(",");
                        }
                    }
                }
                result.append("]\n");
            }
        }
        
        System.out.print(result);
    }
}
