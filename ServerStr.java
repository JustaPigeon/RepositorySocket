import java.io.*;
import java.util.*;
import java.net.*;

public class ServerStr{
  ServerSocket server = null;
  Socket client = null;
  String stringaRicevuta= null;
  String stringaModificata= null;
  BufferedReader inDalClient;
  DataOutputStream outVersoClient;

  public Socket attendi(){
    try{
      System.out.println("Server partito in esecuzione...");
      server = new ServerSocket(12345);
      client = server.accept();
      server.close();
      inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
      outVersoClient = new DataOutputStream(client.getOutputStream());
    }catch(IOException e){
      System.out.println(e.getMessage());
      System.out.println("Errore durante l'accettazione della connessione");
      System.exit(1);
    }
    return client;
  }
  public void comunica(){
    try{
      System.out.println("3 Server in attesa di una stringa da inviare al client...");
      stringaRicevuta = inDalClient.readLine();
      System.out.println("6 Server riceve: " + stringaRicevuta);
      stringaModificata = stringaRicevuta.toUpperCase();
      System.out.println("7 Server invia: " + stringaModificata);
      outVersoClient.writeBytes(stringaModificata + '\n');
      System.out.println("9...Chiusura della connessione"); 
      client.close();
    }catch(IOException e){
      System.out.println(e.getMessage());
      System.out.println("Errore durante la comunicazione col client!");
      System.exit(1);
    }
  }
}