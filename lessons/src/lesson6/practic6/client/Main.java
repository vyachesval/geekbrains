package lesson6.practic6.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String IP_ADRESS = "127.0.0.1";
        final int PORT = 8189;

        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        try {
            socket = new Socket(IP_ADRESS, PORT);
            out = new DataOutputStream(socket.getOutputStream());

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            new Thread(() -> {
                try {
                    while (true) {
                        while (!input.ready()) ;

                        String str = input.readLine();
                        System.out.println("From server: " + str.trim());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            Scanner scLoc = new Scanner(System.in);
            while (true) {
                try {
                    String str = scLoc.nextLine();
                    out.writeUTF(str + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("socket.close");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
