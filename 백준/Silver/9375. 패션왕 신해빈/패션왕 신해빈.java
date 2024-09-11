import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 테스트 케이스 개수 받기
        int testCases = Integer.parseInt(br.readLine());
        
        // 테스트 케이스별로 처리
        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(br.readLine()); // 의상 수
            HashMap<String, Integer> categories = new HashMap<>(); // 카테고리별 의상 수
            
            // 의상 정보 입력 받기
            for (int i = 0; i < n; i++) {
                String[] clothInfo = br.readLine().split(" ");
                String category = clothInfo[1]; // 의상의 카테고리
                
                // 카테고리별 의상 수 카운트
                categories.put(category, categories.getOrDefault(category, 0) + 1);
            }
            
            // 모든 카테고리에서 한 가지 의상만 입지 않는 경우를 계산
            int combinations = 1;
            for (int count : categories.values()) {
                combinations *= (count + 1); // 각 카테고리별로 입지 않는 경우 포함
            }
            
            // 입지 않는 경우는 제외하고 출력
            System.out.println(combinations - 1);
        }
    }
}
