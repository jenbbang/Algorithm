import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap <String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            bw.write(map.get(str) + "\n");
        }
        bw.flush();
        bw.close();
    }
   }
/*
* 메모장에서 비밀번호를 찾는 프로그램을 만들기로 함
* 각 줄에 사이트 주소와 비밀번호가 공백으로 구분되어 주어짐
* 사이트 주소는 알파벳 대문자, 대시('-'), 마침표('.')로 이루어져짐
* 비밀번호를 찾으려는 사이트 주소의 비밀번호를 차례대로 각 줄에 하나씩 출력
 */