/**
 * Урок 6. Работа с сетью
 * 1. Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения, как на клиентской стороне,
 * так и на серверной. Т.е. если на клиентской стороне написать "Привет", нажать Enter то сообщение должно передаться на сервер и там отпечататься в консоли.
 * Если сделать то же самое на серверной стороне, сообщение соответственно передается клиенту и печатается у него в консоли. Есть одна особенность,
 * которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд, такую ситуацию необходимо корректно обработать
 * <p>
 * Разобраться с кодом с занятия, он является фундаментом проекта-чата
 * ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл, который будет ожидать второго/третьего/n-го клиентов
 */

package lesson6.practic6.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        DataOutputStream out;
        try {
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        while (!input.ready()) ;

                        String str = input.readLine();
                        System.out.println("From client: " + str.trim());
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
            try {
                System.out.println("server.close");
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
