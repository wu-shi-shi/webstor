package com.bdqn.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ThreaUserUDP extends Thread {
    private DatagramPacket dp;
    private DatagramSocket ds;
    public ThreaUserUDP(DatagramPacket dp,DatagramSocket ds){
        this.dp=dp;
        this.ds=ds;
        start();
    }

    @Override
    public void run() {

    }
}
