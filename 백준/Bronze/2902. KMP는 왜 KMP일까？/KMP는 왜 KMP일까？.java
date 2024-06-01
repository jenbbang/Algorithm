import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
코드 작성 방법
1. 입력받아서 문자열 n에 저장
2. StringTokenizer 객체 생성: 입력받은 문자열을 "-"를 기준으로 토큰화
3. 토근이 없을때까지 반복
4. 각 토큰의 첫 글자 출력 

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        String n = bf.readLine();

        StringTokenizer str = new StringTokenizer(n, "-");

        while (str.hasMoreTokens())
            System.out.print(str.nextToken().substring(0,1));
    }

}
