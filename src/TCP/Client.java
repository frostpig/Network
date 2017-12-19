package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/11/17.
 */
public class Client {
    public static void main(String[] args) {
        //客户端请求与本机在20006端口建立TCP连接
        try {

            Socket client = new Socket("127.0.0.1",20006);
            client.setSoTimeout(10000);

            //获取键盘输入
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            //获取socket的输出流，用来发送数据到服务器
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取socket的输入流，用来接收从服务端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                System.out.println("输入信息");
                String str = input.readLine();
                //发送数据到服务器
                out.println(str);
                if("bye".equals(str)) {
                    flag = false;
                }else {
                    //从服务端接收数据有个时间限制（系统自设，也可以自己设置）
                    String echo = buf.readLine();
                    System.out.println(echo);
                }
            }
            input.close();
            if (client != null){
                //如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，不关闭
                client.close();  //只关闭socket,其关联的输入输出流也会被关闭
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取键盘输入

        //获取socket的输出流，用来发送数据到服务器

        //获取socket的输入流，用来接收从服务端发送过来的数据

        //发送数据到服务器

        //从服务端接收数据有个时间限制（系统自设，也可以自己设置）
    }
}
