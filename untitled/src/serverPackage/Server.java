package serverPackage;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) {
     try{ServerSocket serverSocket =new ServerSocket(12345);
     System.out.println("Je suis un serveur en attente la connexion d'un client ");
     Socket socket=serverSocket.accept();
        System.out.println("Un client est connecté");
        serverSocket.close();
    socket.close();
    }catch(IOException e){
            e.printStackTrace();
    }
    
}}
