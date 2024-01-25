import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server 
{
    public static void main(String[] args) throws IOException {
        int port = 12345; 
        ServerSocket serverSocket = new ServerSocket(port); 
        System.out.println("Server in ascolto sulla porta "+ port); 

        try{
            while(true){
                Socket clientSocket = serverSocket.accept(); 

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
                out.println("Ciao clienti"); 
                clientSocket.close(); 
            }
        }catch(IOException e){
            e.printStackTrace(); 
        } finally {
            serverSocket.close(); 
        }
    }
}