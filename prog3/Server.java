package Archive.prog3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public Server(){

        try {
            ServerSocket soket = new ServerSocket(4444);//chose a port that's not busy
            System.out.println("Server is Running ...");
            while(true) {
                Socket socket = soket.accept();
                System.out.println("Server is Connecting ...");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        InputStream is = null;
                        try {
                            is = socket.getInputStream();
                            Scanner scanner = new Scanner(is);
                            while (scanner.hasNextLine()) {
                                System.out.println(scanner.nextLine());
                            }
                            scanner.close();
                            is.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}