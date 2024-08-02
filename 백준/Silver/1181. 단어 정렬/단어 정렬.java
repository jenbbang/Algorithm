import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Set<Pair> set = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            set.add(new Pair(s.length(), s));
        }

        for (Pair pair : set) {
            System.out.println(pair.str);
        }
    }
}

class Pair implements Comparable<Pair> {
    int len;
    String str;

    Pair(int len, String str) {
        this.len = len;
        this.str = str;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.len != o.len) {
            return this.len - o.len;
        } else {
            return this.str.compareTo(o.str);
        }
    }
}
