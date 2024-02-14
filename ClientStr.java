import java.io.*;
import java.util.*;
import java.net.*;

public class ClientStr {
  String nameServer = "localhost";
  int portaServer= 12345;
  Socket miosocket;
  BufferedReader tastiera;
  String stringaUtente;
  String stringaRicevutaDalServer;
  DataOutputStream outVersoServer;
  BufferedReader inDalServer;

  public Socket connetti(){
    System.out.println("2 Client partito in esecuzione...");
    try{
      tastiera = new BufferedReader(new InputStreamReader(System.in));
      miosocket = new Socket(nameServer, portaServer);
      outVersoServer = new DataOutputStream(miosocket.getOutputStream());
      inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
    }catch(UnknownHostException e){
      System.err.println("Host sconosciuto");
    }catch(Exception e){
      System.err.println("Errore durante la connessione");
    }
    return miosocket;
  }

  public void comunica(){
    try{
      System.out.println("4...In attesa di una stringa da inviare al server...");
      stringaUtente = tastiera.readLine();
      System.out.println("5...Invio la stringa al server e attendo...");
      outVersoServer.writeBytes(stringaUtente + '\n');
      stringaRicevutaDalServer = inDalServer.readLine();
      System.out.println("8...Risposta dal server " + stringaRicevutaDalServer);
      System.out.println("9...Chiusura della connessione");
      miosocket.close();
    }catch(Exception e){
      System.out.println(e.getMessage()); 
      System.err.println("Errore durante la comunicazione col server!");
      System.exit(1);
    }
  }
}
