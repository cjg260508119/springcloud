package com.chen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName:SocketServer
 * @Auther: 26050
 * @Description:
 * @Date: 2023/2/24 15:01
 * @Version: v1.0
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {

        ExecutorService servicePool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8090);
        serverSocket.setSoTimeout(3000);
        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("3s超时处理");
                continue;
            }

            servicePool.execute(new MyTask(socket));
        }

    }

    static class MyTask implements Runnable {

        private Socket socket;

        public MyTask(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            //处理socket
        }
    }
}
