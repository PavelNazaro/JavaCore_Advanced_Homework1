package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static Socket socket;
    public static DataInputStream in;
    public static DataOutputStream out;

    public static volatile boolean flagStop = false;

    public static Thread startWriteThread = new Thread(Client::startWrite);
    public static Thread startReadThread = new Thread(Client::startRead);

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String str = in.readUTF();
            System.out.println("Сервер: " + str);

            startReadThread.setDaemon(true);
            startReadThread.start();

            startWriteThread.setDaemon(true);
            startWriteThread.start();

            while (!flagStop) {
                Thread.onSpinWait();
            }
            System.out.println("Client stopped!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startRead() {
        WriteRead.messageFromClient(in, "Клиент");

        flagStop =true;
    }

    private static void startWrite() {
        WriteRead.messageForClient(out, "Клиент");

        flagStop =true;
    }
}
