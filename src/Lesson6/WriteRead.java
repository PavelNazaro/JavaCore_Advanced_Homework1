package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteRead {
    public static void messageForClient(DataOutputStream out, String serverOrClient){
        Scanner consoleIn = new Scanner(System.in);
        System.out.println("Чат открыт:");
        while (true) {
            String message = consoleIn.nextLine();

            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (message.equals("/end")){
                break;
            }
        }
        System.out.println(serverOrClient + " завершился по команде /end");
    }

    public static void messageFromClient(DataInputStream in, String serverOrClient){
        while (true) {
            String str = null;
            try {
                str = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            if (serverOrClient.equals("Сервер")){
                System.out.println("Клиент: " + str);
            }
            else {
                System.out.println("Сервер: " + str);
            }
            if (str.equals("/end")) {
                break;
            }
        }
        System.out.println(serverOrClient + " завершился по команде клиента");
    }
}
