package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public static DataInputStream in;
    public static DataOutputStream out;

    public static int flag = 0;

    public static Thread startReadThread = new Thread(Client::startRead);

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String str = in.readUTF();
            System.out.println("Сервер: " + str);

            startReadThread.start();

            Scanner consoleIn = new Scanner(System.in);
            System.out.println("Чат открыт:");
            while (true) {
                String message = consoleIn.nextLine();

                try {
                    out.writeUTF(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (message.equals("/end") || flag == 1/*|| startReadThread.isInterrupted()*/){
                    break;
                }
            }
            System.out.println("Клиент завершился по команде /end");
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

    private static void startRead() {
        while (true) {
            String str = null;
            try {
                str = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Клиент: " + str);
            if (str.equals("/end") || flag == 1) {
                break;
            }
        }
        System.out.println("Клиент завершился по команде сервера");
        flag = 1;
        //startReadThread.interrupt();
    }
}
