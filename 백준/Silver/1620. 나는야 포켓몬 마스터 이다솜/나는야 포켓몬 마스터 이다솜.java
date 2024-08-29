import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> reverseMap = new HashMap<>(); // 숫자로 이름 찾기 위한 맵 추가

        // 포켓몬 도감 채우기
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, i + 1);
            reverseMap.put(i + 1, name); // 숫자로 이름을 찾기 위해 추가
        }

        // 문제 맞추기
        for (int i = 0; i < m; i++) {
            String query = br.readLine();

            // 숫자인지 문자인지 확인하여 처리
            if (query.chars().allMatch(Character::isDigit)) { // 입력이 숫자인 경우
                int index = Integer.parseInt(query);
                System.out.println(reverseMap.get(index)); // 숫자에 해당하는 포켓몬 이름 출력
            } else { // 입력이 문자인 경우
                System.out.println(map.get(query)); // 포켓몬 이름에 해당하는 번호 출력
            }
        }
    }
}
