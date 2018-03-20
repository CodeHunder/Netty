package com.ai;

import com.ai.handler.MyWebSocketChannelHandler;
import com.ai.handler.MyWebSocketHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.UnsupportedEncodingException;

/**
 * @Author ZINING
 * @Description 程序入口，负责启动应用
 * @Date Create in 2018/2/26 15:43
 */
public class Main {

    /*public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
        System.out.println(System.getProperty("java.vm.name"));
        System.out.println(System.getProperty("java.vm.info"));
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new MyWebSocketChannelHandler());
            System.out.println("服务端开启等待客户端链接");
            Channel channel = b.bind(8888).sync().channel();
            channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //优雅的退出程序
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }*/
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = new byte[16];
        bytes[0] = 125;
        bytes[1] = 20;
        bytes[2] = 119;
        bytes[3] = 38;
        for (int i = 4; i < bytes.length; i++) {
            bytes[i] = 0;
        }
        System.out.println("byte值" + bytes.toString());
        String s=new String(bytes,"ISO-8859-1");
        String s2=new String(bytes,"UTF-8");
        System.out.println( "s"+s);
        System.out.println( "s1"+s2);
    }
}
