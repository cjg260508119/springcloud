package com.chen.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName:MultiplexerTimeServer
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/9 22:00
 * @Version: v1.0
 */
public class MultiplexerTimeServer implements  Runnable{

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile  boolean stop;

    public MultiplexerTimeServer(int port){
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("the server is start in port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while(!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> ite = selectionKeys.iterator();
                SelectionKey key = null;
                while(ite.hasNext()) {
                    key = ite.next();
                    ite.remove();
                    //事件
                }
            } catch (IOException e) {
                e.printStackTrace();;
            }
        }

        //关闭
        if(selector != null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer bf = ByteBuffer.allocate(1024);
                int readBytes = sc.read(bf);
                if(readBytes > 0){
                    bf.flip();
                    byte[] bytes = new byte[bf.remaining()];
                    bf.get(bytes);
                    String body = new String(bytes, "utf-8");
                    System.out.println("the time server receive order :" + body);

                    String currentTime = "Query Time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad Order";
                    doWrite(sc, currentTime);
                }else if(readBytes < 0){
                    key.cancel();
                    sc.close();
                }else {
                    ;
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String resp) throws IOException {
        if(resp != null && resp.trim().length() > 0){
            byte[] bytes = resp.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
