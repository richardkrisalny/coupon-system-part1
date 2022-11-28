package Tests.thredsForConnectionPoolTest;

import connectionsAndDaos.ConnectionPool;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class Thred5 extends Thread{
    @Override
    public void run() {
        Connection c= ConnectionPool.getInstance().getConnection();
        System.out.println("5 get connection");
        try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ConnectionPool.getInstance().restoreConnection(c);
        System.out.println("5 restore connection");
    }
}