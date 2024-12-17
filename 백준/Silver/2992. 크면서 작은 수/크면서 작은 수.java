import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 숫자를 문자열로 변환 후, 각 자리수를 배열로 저장
        char[] digits = Integer.toString(n).toCharArray();
        
        // 자리수를 오름차순으로 정렬
        Arrays.sort(digits);
        
        // 원래 수보다 큰 수를 찾기 위한 변수
        String result = null;
        
        // 다음 조합을 생성하여 원래 수보다 큰 수를 찾기
        do {
            String current = new String(digits);
            if (Integer.parseInt(current) > n) {
                result = current;
                break;
            }
        } while (nextPermutation(digits));
        
        // 결과 출력
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("0");
        }
    }

    // 다음 조합을 생성하는 간단한 함수
    private static boolean nextPermutation(char[] array) {
        int i = array.length - 1;
        
        // 1. 가장 큰 i 찾기
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        
        // 만약 i가 0이면 더 이상 순열이 없음
        if (i <= 0) {
            return false;
        }
        
        // 2. j 찾기
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }
        
        // 3. 스왑
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;
        
        // 4. 뒤의 수들을 뒤집기
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        
        return true;
    }
}
