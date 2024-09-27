import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
목적 : 좌표 압축
1. Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 함
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];  // 원본 배열
        int[] sortedArr = new int[n];  // 정렬을 위한 복사본 배열

        // 배열의 값들 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 원본 배열에 값 저장
            sortedArr[i] = arr[i];  // 정렬을 위해 복사
        }

        Arrays.sort(sortedArr);

        // 각 값의 압축된 좌표(순위)를 저장할 맵 생성
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;

        // 정렬된 배열에서 중복을 제거하고 순위를 매김
        for (int value : sortedArr) {
            if (!rankMap.containsKey(value)) {  // 해당 값이 아직 순위에 할당되지 않은 경우
                rankMap.put(value, rank++);  // 해당 값에 순위를 할당하고 rank를 증가시킴
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rankMap.get(arr[i])).append(" ");  // 원본 배열의 값을 순위로 변환하여 출력
        }
        System.out.println(sb.toString().trim());
    }
}