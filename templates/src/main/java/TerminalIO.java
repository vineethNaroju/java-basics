package src.main.java;

import java.io.*;
import java.util.*;

public class TerminalIO {

    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st;

    String next(boolean line) {

        while(st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return line ? st.nextToken("\n") : st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next(false));
    }


    public static void main(String[] args) {

        TerminalIO tio = new TerminalIO();

        int lineCount = tio.nextInt();

        int total_sum = 0, total_cnt = 0;
        double avg;

        for(int i=0; i<lineCount; i++) {
            int cnt = 0, curr_sum = 0;

            cnt = tio.nextInt();

            for(int j=0; j<cnt; j++) {
                curr_sum += tio.nextInt();
            }

            total_cnt += cnt;
            total_sum += curr_sum;

            avg = cnt <= 0 ? -1: curr_sum / cnt ;

            tio.pw.println(avg);
            tio.pw.flush();
        }

        avg = total_cnt <= 0 ? -1 : total_sum / total_cnt;

        tio.pw.println(avg);
        tio.pw.flush();
    }

}


//            String res;
//            if(line) {
//                if(st == null || !st.hasMoreTokens()) {
//                    res = br.readLine();
//                } else {
//                    res = st.nextToken("\n");
//                }
//            } else {
//                while(st == null || !st.hasMoreTokens()) {
//                    st = new StringTokenizer(br.readLine());
//                }
//
//                res = st.nextToken();
//            }
//        return res;

//        long start = System.nanoTime();
//
//
//        BigInteger b = BigInteger.ONE;
//
//        for(int i=0; i<25; i++) {
//            b = b.multiply(BigInteger.valueOf(i));
//        }
//
//        long end = System.nanoTime();
//
//        pw.print(b);
//        pw.print((end - start));
//        pw.flush();
//        pw.close();
