package serverPackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) {
     try{ServerSocket serverSocket =new ServerSocket(12345);
     System.out.println("Je suis un serveur en attente la connexion d'un client ");
     Socket socket=serverSocket.accept();
        System.out.println("Un client est connecté");
        int x;
        do{//utilise do while pour recevoir plusieurs valeurs du client et pour arreter la connexion si x=0
        DataInputStream in = new DataInputStream(socket.getInputStream());
         x = in.readInt();
        //multiplier x par 5
        int result = x*5;
        //envoyer le resultat au client
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(result);}
        while(x!=0);
        // fermer la connexion
        serverSocket.close();
    socket.close();
    }catch(IOException e){
            e.printStackTrace();
    }
    
}}
