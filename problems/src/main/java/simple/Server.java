package src.main.java.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {

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
        Server server = new Server();
        server.solve();
    }

    public void solve() throws Exception {
        ServerSocket listeningSocket = new ServerSocket(3421);
        Socket clientSocket = listeningSocket.accept();

        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        pw = new PrintWriter(clientSocket.getOutputStream());

        while(true) {
            int input = nextInt();
            if(input == -2) break;
            pw.println(input << 1);
            pw.flush();
            if(clientSocket.isClosed()) {
                System.out.println("client is closed");
                break;
            }
        }

        clientSocket.close();
    }
}
