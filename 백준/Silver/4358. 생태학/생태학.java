import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> map = new TreeMap<>();

        int count = 0;

        String tree = br.readLine();
        while (tree != null){

            map.put(tree, map.getOrDefault(tree, 0)+1);
            count ++;
            tree = br.readLine();
        }
        StringBuilder sb = new StringBuilder();

        for (var t : map.entrySet()){
            double d = t.getValue() / (double) count * 100;
            sb.append(t.getKey())
                    .append(" ")
                    .append(String.format("%.4f",d))
                    .append("\n");
        }
        System.out.println(sb);

    }

}
