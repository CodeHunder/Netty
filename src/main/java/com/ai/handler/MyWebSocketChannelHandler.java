package com.ai.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * @Author ZINING
 * @Description 初始化链接时候的各个组件
 * @Date 2018/2/26 15:30
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel>{
    protected void initChannel(SocketChannel e) throws Exception {
        e.pipeline().addLast("http_codec",new HttpServerCodec());
        e.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
        e.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
        e.pipeline().addLast("handler",new MyWebSocketHandler());
    }
}
