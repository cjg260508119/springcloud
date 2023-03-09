package com.chen.netty;

/**
 * @ClassName:TimeServer
 * @Auther: 26050
 * @Description:
 * @Date: 2023/3/9 21:54
 * @Version: v1.0
 */
public class TimeServer {

    public static void main(String[] args){
        int port = 8080;
        if(args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }
    }
}
