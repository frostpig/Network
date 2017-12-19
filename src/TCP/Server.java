package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/11/17.
 */
public class Server {
    public static void main(String[] args) {
        //服务端在20006端口监听客户端请求的TCP连接
        try {
            ServerSocket serverSocket = new ServerSocket(20006);
            Socket client = null;
            boolean f = true;
            while (f){
                //等待客户端的连接，如果没有获取连接
                client = serverSocket.accept();
                System.out.println("与客户端链接成功");
                //为每个客户端连接开启一个线程
                new Thread(new ServerThread(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
