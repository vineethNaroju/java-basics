package src.main.java;

import java.io.*;
import java.math.*;
import java.util.*;

public class Rough {

     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     PrintWriter pw = new PrintWriter(System.out);
     StringTokenizer st;

     String next(boolean line) {
         try {
             while(st == null || !st.hasMoreTokens()) {
                 st = new StringTokenizer(br.readLine());
             }
         } catch (Exception e) {
             e.printStackTrace();
         }

         return line ? st.nextToken("\n") : st.nextToken();
     }

     int nextInt() {
         return Integer.parseInt(next(false));
     }

     void solve() {

     }

     public static void main(String[] args) {
         Rough r = new Rough();

         int t = r.nextInt();

         while(t-- > 0) r.solve();
     }
}




































