import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우와 해시맵을 이용하여 최대 과일 수 계산
        System.out.println(maxFruit(arr, n));
    }

    // 두 종류 이하의 과일을 사용하여 만들 수 있는 최대 과일 개수 구하기
    public static int maxFruit(int[] arr, int n) {
        // 과일 종류와 그 개수를 저장할 맵
        Map<Integer, Integer> fruitCount = new HashMap<>();
        
        int maxCount = 0; // 최대 과일 개수
        int left = 0; // 슬라이딩 윈도우의 왼쪽 끝

        for (int right = 0; right < n; right++) {
            // 현재 과일을 맵에 추가
            fruitCount.put(arr[right], fruitCount.getOrDefault(arr[right], 0) + 1);

            // 과일 종류가 2개를 초과하면 슬라이딩 윈도우의 크기를 줄이기
            while (fruitCount.size() > 2) {
                fruitCount.put(arr[left], fruitCount.get(arr[left]) - 1);
                
                // 과일 개수가 0이 되면 맵에서 제거
                if (fruitCount.get(arr[left]) == 0) {
                    fruitCount.remove(arr[left]);
                }
                left++; // 윈도우의 왼쪽 끝을 이동
            }

            // 두 종류 이하의 과일을 사용한 최대 길이 갱신
            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}
