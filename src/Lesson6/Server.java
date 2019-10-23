package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static Socket socket;
    public static DataInputStream in;
    public static DataOutputStream out;

    public static int flag = 0;

    public static Thread startWriteThread = new Thread(Server::startWrite);

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try /*(ServerSocket serverSocket = new ServerSocket(8189))*/ {
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Подключено!");

            startWriteThread.start();

            while (true) {
                String str = in.readUTF();
                System.out.println("Клиент: " + str);
                if (str.equals("/end") /*|| startWriteThread.isInterrupted() */|| flag == 1) {
                    break;
                }
            }
            System.out.println("Сервер завершился по команде клиента");
            flag = 1;
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startWrite() {
        Scanner consoleIn = new Scanner(System.in);
        System.out.println("Чат открыт:");
        while (true) {
            String message = consoleIn.nextLine();

            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (message.equals("/end") || flag == 1){
                break;
            }
        }
        System.out.println("Сервер завершился по команде /end");

        flag = 1;

        //startWriteThread.interrupt();
    }
}
