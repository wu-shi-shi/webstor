package com.bdqn.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * extends Thread 继承线程类
 */
public class ThreaUser extends Thread {
    //声明一个Socket类
    private Socket socket;
    //够着方法用于初始化Socket类
    public ThreaUser(Socket socket){
        this.socket=socket;
        //启动线程（会自己去执行run()  需要重写run方法）
        start();
    }

    @Override
    public void run() {
        //创建io流的InputStream用于接收服务器反馈的值
        InputStream is = null;
        //创建io流的OutputStream用于想服务端发送数据
        OutputStream os = null;
        try {
            //接收客户端发送内容
            is = socket.getInputStream();
            //创建一个byte数组用于接收
            byte[] b = new byte[2048];
            //接收数据长度
            int n = is.read(b);
            /**
             * @parameter b 用于存放的数组
             * @parameter 0 重下标0开始取值
             * @parameter n 重0开始到n结束
             */
            //然后把数据转换为字符串
            String pram=new String(b,0,n);
            //输出反馈数据
            System.out.println("客户端发送内容为：" + pram);
            //反馈
            os = socket.getOutputStream();
            //把接收到的数据解析并赋给respones（byteArrayCopy方法在下面）
            byte[] respones=byteArrayCopy(b,0,n);
            //把数据反馈给客户端
            os.write(respones);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                is.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param b 客户端发送数据缓冲区
     * @param off 开始下标
     * @param len 有效数据长度
     * @return
     */
    public byte[] byteArrayCopy(byte[] b,int off,int len){
        //创建一个resones数组用于接收数据  长度为有效数据的长度
        byte[] response=new byte[len];
        //将数据copy到response中
        /**
         * b 原数组
         * 0（srcPos） 原数组要copy的开始下标
         * response 接收b数组数据的数组
         * 0（destPos） copy的数据从response那个下标开始
         * len copy旧数组的长度
         */
        System.arraycopy(b,0,response,0,len);
        //返回
        return response;
    }
}
