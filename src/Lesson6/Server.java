package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static Socket socket;
    public static DataInputStream in;
    public static DataOutputStream out;

    public static volatile boolean flagStop = false;

    public static Thread startWriteThread = new Thread(Server::startWrite);
    public static Thread startReadThread = new Thread(Server::startRead);

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Подключено!");

            startWriteThread.setDaemon(true);
            startWriteThread.start();

            startReadThread.setDaemon(true);
            startReadThread.start();

            while (!flagStop) {
                Thread.onSpinWait();
            }

            System.out.println("Server stopped!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startRead() {
        WriteRead.messageFromClient(in, "Сервер");

        flagStop =true;
    }

    private static void startWrite() {
        WriteRead.messageForClient(out, "Сервер");

        flagStop =true;
    }
}
