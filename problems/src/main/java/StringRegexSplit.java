import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
* https://www.hackerrank.com/challenges/java-string-tokens/problem?isFullScreen=true
* */
public class StringRegexSplit {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        try {
            StringTokenizer tok = new StringTokenizer(br.readLine(), " !,?._'@");
            pw.println(tok.countTokens());
            while(tok.hasMoreTokens()) {
                pw.println(tok.nextToken());
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
