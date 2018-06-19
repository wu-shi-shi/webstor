package com.bdqn.socket.tcp;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketServer {
    @Test
    public void asdasdadsdad(){
        //创建创建服务端的实现类
        ServerSocket serverSocket = null;
        //Socket是TCP/IP协议的封装是进行网络通信的。
        Socket socket = null;
        //创建io流的InputStream用于接收服务器反馈的值
        InputStream is = null;
        //创建io流的OutputStream用于想服务端发送数据
        OutputStream os = null;
        try {
            // 创建serverSocket对象 扫描接口
            serverSocket=new ServerSocket(10001);
            while (true){
                // 建立链接（具有堵塞作用，在没有客户端连接是讲不会执行下面的方法）
                socket=serverSocket.accept();

                new ThreaUser(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
