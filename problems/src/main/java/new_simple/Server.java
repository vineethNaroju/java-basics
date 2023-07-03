package src.main.java.new_simple;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

    PrintWriter terminal = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.solve();

    }

    public void solve() throws  Exception {
        ServerSocketChannel listeningChannel = ServerSocketChannel.open();

        listeningChannel.socket().bind(new InetSocketAddress(4321));

        SocketChannel clientChannel = listeningChannel.accept();


        ByteBuffer byteBuffer = ByteBuffer.allocate(100); // 100 bytes


        int bytesRead = clientChannel.read(byteBuffer);

        terminal.println("bytes read:" + bytesRead);

        int val = byteBuffer.getInt();

        terminal.println("server got:" + val);

        terminal.flush();

        ByteBuffer res = ByteBuffer.wrap(new byte[] {(byte) (val << 1)});

        int bytesWritten = 0;

        while(res.hasRemaining()) {
            bytesWritten += clientChannel.write(res);
        }

        terminal.println("bytes written:" + bytesWritten);

        clientChannel.close();
    }
}
