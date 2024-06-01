import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
코드 작성 방법
1. 입력 저장
   - BufferedReader를 사용하여 콘솔로부터 입력을 받음.
   - StringTokenizer를 사용하여 입력된 문자열을 공백을 기준으로 나눔.
   - 첫 번째 토큰을 N에 저장 (변환할 숫자 문자열).
   - 두 번째 토큰을 B에 저장 (기수).
   - 더 이상 입력을 받지 않으므로 BufferedReader를 닫음.
   
2. 숫자 변환
   - result 변수를 사용하여 각 자리수의 가중치를 계산.
   - sum 변수를 사용하여 결과값을 저장.
   - 숫자의 맨 오른쪽 자리부터 계산하기 위해 역순으로 for문을 돌림.
     a. 현재 자리의 문자를 가져옴.
     b. 문자가 'A'에서 'Z' 사이일 경우 (10진수로 변환).
     c. 문자가 '0'에서 '9' 사이일 경우.
     d. 다음 자리수로 넘어갈 때마다 가중치(기수의 거듭제곱)를 증가시킴.
   
3. 결과 출력
   - 최종 결과를 출력.

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int result = 1;
        int sum = 0;

        for(int i = N.length()-1 ; i >= 0; i--){ // 여기서, 맨오른쪽 부터 계산!
            char C = N.charAt(i);
            if ('A' <= C && C<= 'Z') {
                sum += (C - 'A' + 10) * result;
            } else {
                sum += (C - '0') * result;
            }
            result *= B;
        }

        System.out.println(sum);
    }
}
