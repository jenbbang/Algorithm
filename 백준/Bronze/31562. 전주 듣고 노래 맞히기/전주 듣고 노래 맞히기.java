import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt(); // N:4
        int M = sc.nextInt(); // M:4
        sc.nextLine();

        // 노래 정보를 저장할 해시테이블 선언
        Hashtable<String,String> table = new Hashtable<>();

        // N개의 노래 정보를 입력받아 해시테이블에 저장
        //TwinkleStar[1] C[2] C[3] G[4] G A A G
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            String key = input[1];
            String value = input[2] + input[3]+ input[4];
            // 동일한 첫 세 음을 가진 노래가 이미 있는 경우 "?"로 저장
            table.put(value, table.containsKey(value) ?  "?" : key);
        }

        // M개의 맞혀야 할 노래의 첫 세 음을 입력받고 검색
        for (int i = 0; i < M; i++) {
            String[] song = sc.nextLine().split(" ");
            String melody = song[0] + song[1] + song[2];  // 맞혀야 할 노래의 첫 세 음

            // 첫 세 음으로 노래를 찾아 출력 (찾을 수 없으면 "!" 출력)
            System.out.println(table.getOrDefault(melody, "!"));
        }

        sc.close();
    }
}