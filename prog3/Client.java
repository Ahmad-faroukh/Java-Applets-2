package Archive.prog3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public Client(){
        try {
            Socket socket = new Socket("127.0.0.1",4444);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            boolean stop = true;
            while (stop){
                pw.println("hello server");
                pw.flush();
                Thread.sleep(2000);
            }
            pw.close();
            os.close();
            //socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Client();
    }
}