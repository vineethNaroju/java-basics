package src.main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class MoreDs {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String next(boolean line) {
        try {
            while(st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line ? st.nextToken("\n"): st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next(false));
    }

    PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        MoreDs mds = new MoreDs();
        mds.solve();
    }


    int V, E;
    ArrayList<ArrayList<Integer>> adj;


    public void solve() {
        int m = 3, n = 5;


        int[][] mn = new int[m][n];


        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                mn[i][j] = j + n*i;
            }
        }

        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                pw.println(String.format("[%d,%d]=%d",i,j,mn[i][j]));
            }
        }

        pw.flush();



        V = nextInt();
        E = nextInt();

//        if(adj != null) {
//            adj.forEach(ArrayList::clear);
//            adj.clear();
//        }

        adj = new ArrayList<>(V);

        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        int x , y;

        for(int i=0; i<E; i++) {
            x = nextInt();
            y = nextInt();

            adj.get(x).add(y);
            adj.get(y).add(x);
        }


        Deque<Integer> dq = new LinkedList<>();

        BitSet visit = new BitSet(V);

        for(int i=0; i<V; i++) {
            pw.println(visit.get(i));
        }

        dq.push(0);

        while(!dq.isEmpty()) {
            int u = dq.removeFirst();

            pw.println(u);
            visit.set(u);

            adj.get(u).forEach(v -> {
                if(!visit.get(v)) {
                    dq.addLast(v);
                    visit.set(v);
                }
            });
        }

        pw.flush();
    }
}
