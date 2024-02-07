import java.io.*; 
import java.net.*; 
import java.util.*; 

public class Server
{
    ServerSocket server = null; 
    Socket client = null; 
    String stringaRicevuta = null; 
    String stringaModificata = null; 
    BufferedReader inDalClient; 
    DataOutputStream outVersoServer; 


    public Socket attendi()
    {
        try{
            System.out.println("1 SERVER partito in esecuzione ..."); 

            server = new ServerSocket(6789); 

            client = server.accept(); 

            server.close(); 

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            outVersoServer = new DataOutputStream(client.getOutputStream()); 
        }catch(Exception e)
        {
            System.out.println(e.getMessage()); 
            System.out.println("Errore durante l'istanza del server !");
        }
        return client; 
    }

    public void comunica()
    {
        try{
            System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiuscolo, Attendo ..."); 
            stringaRicevuta = inDalClient.readLine(); 
            System.out.println("6 Ricevuta la stringa dal cliente : "+stringaRicevuta);

            stringaModificata=stringaRicevuta.toUpperCase(); 
            System.out.println("7 invio la stringa modificata al client ...");
            outVersoServer.writeBytes(stringaModificata+'\n');

            System.out.println("9 SERVER: fine elaborazione ... buona notte!"); 
        }catch(Exception e)
        {
            System.out.println(e.getMessage()); 
            System.out.println("Errore durante la comunicazione!");
        }
    }
}