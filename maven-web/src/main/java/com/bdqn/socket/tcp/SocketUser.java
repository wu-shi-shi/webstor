package com.bdqn.socket.tcp;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 *  客户端
 */
public class SocketUser {
    @Test
    public void asdasdadsdad(){
        //创建客户端的实现类
        Socket socket = null;
        //创建io流的InputStream用于接收服务器反馈的值
        InputStream is = null;
        //创建io流的OutputStream用于想服务端发送数据
        OutputStream os = null;
        //服务器端IP地址
        String serverIP = "127.0.0.1";
        //服务器端端口号
        int port = 10001;
        //发送内容
        String data = "1234567890";
        try {
            /**
             * 链接服务端
             * @parameter serverIp 服务端的ip地址
             * @parameter port 服务端的端口
             */
            socket = new Socket(serverIP,port);
            //获取OutputStream
            os = socket.getOutputStream();
            //把要发送的数据转换为二进制发送给服务端
            os.write(data.getBytes());
            //获取InputStream
            is = socket.getInputStream();
            //创建一个byte数组用于存储服务端发送的数据
            byte[] b = new byte[2048];
            //获取反馈数据的长度
            int n = is.read(b);
            /**
             * @parameter b 用于存放的数组
             * @parameter 0 重下标0开始取值
             * @parameter n 重0开始到n结束
             */
            //然后把数据转换为字符串
            String pram=new String(b,0,n);
            //输出反馈数据
            System.out.println("服务器反馈：" + pram);

        } catch (Exception e) {
            e.printStackTrace(); //打印异常信息
        }finally{

            try {

                //关闭流和连接

                is.close();

                os.close();

                socket.close();

            } catch (Exception e2) {}

        }
    }
}
