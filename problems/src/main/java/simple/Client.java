package src.main.java.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Client {

    BufferedReader br;
    StringTokenizer st;

    PrintWriter pw;

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

    int nextInt() {return Integer.parseInt(next(false));}
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.solve();
    }

    public void solve() throws  Exception {
        Socket serverSocket = new Socket("localhost", 3421);

        Scanner sc = new Scanner(System.in);

        br = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        pw = new PrintWriter(serverSocket.getOutputStream());

        while(true) {
            int terminal = sc.nextInt();
            if(terminal == -1) break;
            pw.println(terminal);
            pw.flush();
            if(serverSocket.isClosed()) {
                System.out.println("server is closed");
                break;
            }
            int res = nextInt();
            System.out.println("server says:" + res);
        }

        serverSocket.close();
    }
}
