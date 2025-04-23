package socket2;

import java.io.*;
import java.net.*;

public class MyServerUser {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server started. Waiting for clients...");

            Socket s = ss.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(s.getInputStream());

            String str = "";
            while (!str.equals("exit")) {
                str = dis.readUTF(); // Waits for message
                System.out.println("Client says: " + str);
            }

            dis.close();
            s.close();
            ss.close();
            System.out.println("Server connection closed.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
