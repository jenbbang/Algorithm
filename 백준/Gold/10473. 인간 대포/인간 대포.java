import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 시작점과 목표점 입력
        st = new StringTokenizer(br.readLine());
        double myX = Double.parseDouble(st.nextToken());
        double myY = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double targetX = Double.parseDouble(st.nextToken());
        double targetY = Double.parseDouble(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        // 좌표들 입력
        double[][] points = new double[N + 2][2];
        points[0][0] = myX;
        points[0][1] = myY;
        points[N + 1][0] = targetX;
        points[N + 1][1] = targetY;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
        }

        // 시간 행렬 계산
        double[][] timeMatrix = new double[N + 2][N + 2];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = calculateDistance(points[i], points[j]);
                if (i == 0) {
                    timeMatrix[i][j] = distance / 5;
                } else {
                    timeMatrix[i][j] = distance / 5;
                    if (distance > 50.0) {
                        timeMatrix[i][j] = Math.min(timeMatrix[i][j], 2 + (distance - 50) / 5);
                    } else if (distance == 50.0) {
                        timeMatrix[i][j] = 2.0;
                    } else {
                        timeMatrix[i][j] = Math.min(timeMatrix[i][j], 2 + (50 - distance) / 5);
                    }
                }
                timeMatrix[j][i] = timeMatrix[i][j];
            }
        }

        // 다익스트라 알고리즘 사용
        double[] distance = new double[N + 2];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[0] = 0;

        PriorityQueue<double[]> heap = new PriorityQueue<>(Comparator.comparingDouble(o -> o[0]));
        heap.add(new double[] {0, 0});

        while (!heap.isEmpty()) {
            double[] curr = heap.poll();
            double currTime = curr[0];
            int currNode = (int) curr[1];

            if (distance[currNode] < currTime) continue;

            for (int i = 0; i < points.length; i++) {
                if (currNode == i) continue;
                double newDist = currTime + timeMatrix[currNode][i];
                if (distance[i] > newDist) {
                    distance[i] = newDist;
                    heap.add(new double[] {newDist, i});
                }
            }
        }

        System.out.printf("%.6f%n", distance[N + 1]);
    }

    // 두 점 사이의 거리 계산 함수
    public static double calculateDistance(double[] src, double[] dest) {
        return Math.sqrt(Math.pow(src[0] - dest[0], 2) + Math.pow(src[1] - dest[1], 2));
    }
}
