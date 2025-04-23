package socket2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClientUser {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String message = "";
            while (!message.equals("exit")) {
                System.out.print("Enter your message: ");
                message = scanner.nextLine();
                dout.writeUTF(message);
                dout.flush();
            }

            dout.close();
            s.close();
            scanner.close();
            System.out.println("Client connection closed.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
