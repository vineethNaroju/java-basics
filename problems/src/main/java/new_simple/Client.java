package src.main.java.new_simple;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    PrintWriter terminal = new PrintWriter(System.out);
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.solve();
    }

    public void solve() throws Exception {
        SocketChannel serverChannel = SocketChannel.open();

        serverChannel.connect(new InetSocketAddress(4321));

        int x = 20;

        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[]{(byte) x});

        byteBuffer.flip();

        int bytesWritten = 0;

        while(byteBuffer.hasRemaining()) {
            bytesWritten += serverChannel.write(byteBuffer);
        }

        terminal.println("bytes written:" + bytesWritten);

        ByteBuffer res = ByteBuffer.allocate(100);

        serverChannel.read(res);

        int y = res.getInt();

        terminal.println("server says:" + y);
    }
}
