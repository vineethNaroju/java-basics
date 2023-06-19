package src.main.java;

import java.io.*;
import java.math.*;
import java.util.*;

public class Rough {

     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     PrintWriter pw = new PrintWriter(System.out);
     StringTokenizer st;

    String next(boolean line) {
        while(st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        return line ? st.nextToken("\n") : st.nextToken();
    }


    int nextInt() {
        return Integer.parseInt(next(false));
    }


    void solve() {
        int n = nextInt(), v;
        int l = 100, r = -1;
        for(int i=0; i<n; i++) {
            v = nextInt();
            l = Math.min(l, v);
            r = Math.max(r, v);
        }

        pw.println(2 * (r - l));
        pw.flush();
    }


    public static void main(String[] args) {
        Rough r = new Rough();

        int t = r.nextInt();

        while(t-- > 0) r.solve();
    }
}




































