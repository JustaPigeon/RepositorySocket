import java.io.*;
import java.util.*;
import java.net.*;

public class Server {
  public static void main(String[] args) throws IOException {
    int port = 12345; // porta sulla quale il server ascoltaù
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("Server in ascolto sulla porta " + port);

    try {
      while (true) {

        Socket clientSocket = serverSocket.accept();

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Ciao client");
        clientSocket.close();
      }
    } catch (IOException e) {
      e.printStackTrace(); // printStackTrace() is used to print the exception details to the console
    }finally{
      serverSocket.close();
    }
  }
}
