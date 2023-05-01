
// https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BitsetOps {

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);

    private StringTokenizer st;

    String next(boolean line) {
        try {
            while(st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return line ? st.nextToken("\n") : st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next(false));
    }

    public static void main(String[] args) {
        BitsetOps s = new BitsetOps();
        s.demo();
    }

    public void demo() {
        int n = nextInt(), m = nextInt();

        BitSet[] arr = new BitSet[2];

        arr[0] = new BitSet(n);
        arr[1] = new BitSet(n);

        for(int i=0; i<m; i++) {
            String op = next(false);
            int x = nextInt(), y = nextInt();

            switch(op) {
                case "AND": {
                    arr[x-1].and(arr[y-1]);
                    break;
                }
                case "OR": {
                    arr[x-1].or(arr[y-1]);
                    break;
                }
                case "XOR": {
                    arr[x-1].xor(arr[y-1]);
                    break;
                }
                case "FLIP": {
                    arr[x-1].flip(y);
                    break;
                }
                case "SET": {
                    arr[x-1].set(y);
                    break;
                }
            }

            pw.println(arr[0].cardinality() + " " + arr[1].cardinality());
            pw.flush();
        }

        pw.close();
    }
}
