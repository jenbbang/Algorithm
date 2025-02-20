import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		boolean visit[] = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for(int j = 0 ; j < N ; j++) {
				if(!visit[j]) {
					if(cnt == n) {
						visit[j] = true;
						arr[j] = i+1;
						break;
					}
					cnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++)
			sb.append(arr[i]+" ");
		System.out.println(sb);
	}

}