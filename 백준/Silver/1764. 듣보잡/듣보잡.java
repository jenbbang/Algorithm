import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
첫째 줄에 듣도 못한 사람의 수 N,
보도 못한 사람의 수 M

듣보잡의 수와 그 명단을 사전순으로 출력한다.

 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Set<String> noname = new HashSet<>();
        Set<String> nobodo = new HashSet<>();

        for (int i = 0; i < n; i++) {
            noname.add(br.readLine());
        }
        for (int j = 0; j < m; j++) {
            nobodo.add(br.readLine());
        }
        // 듣보잡 리스트 생성
        List<String> resultList = new ArrayList<>();
        for (String name : nobodo) {
            if (noname.contains(name)) {
                resultList.add(name);
            }
        }

        // 사전순으로 정렬
        Collections.sort(resultList);

        // 듣보잡 수 출력
        System.out.println(resultList.size());

        // 듣보잡 명단 출력
        for (String name : resultList) {
            System.out.println(name);
        }
    }
}