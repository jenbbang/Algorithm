import java.io.*;
import java.util.*;

public class Main {
    
    private static int n;
    private static int[][] map;
    private static int[][] visited;
    private static int check = 0;
    private static ArrayList<Integer> list = new ArrayList<>();
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        map = new int[n][n];
        visited = new int[n][n];
        
        for(int i=0; i<n; i++){
            String line = sc.next();
            for(int j=0; j<n; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        execute();
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    
    static void execute(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && visited[i][j] == 0){
                    check = 1;
                    map[i][j] = 0;
                    visited[i][j] = 1;
                    dfs(i, j);
                    list.add(check);
                }
            }
        }
    }
    
    static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<n){
                if(map[nx][ny] == 1 && visited[nx][ny] == 0){
                    map[nx][ny] = 0;
                    visited[nx][ny] = 1;
                    check++;
                    dfs(nx, ny);
                }
            }
        }
    }
}