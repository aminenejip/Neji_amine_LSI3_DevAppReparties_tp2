package clientPackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class client {
public static void main(String[] args) {
    try{
        System.out.println("Je suis un client pas encore connecté");
        //creation d'une socket
    Socket socket=new Socket("localhost",12345);
        System.out.println("Je suis un client connecté");
       
        //tapez une valeur x
        Scanner scanner = new Scanner(System.in);
        int x;
        do{ // utilise do while pour envoyer plusieurs valeurs au serveur et pour arreter la connexion si x=0
        System.out.print("donner une valeur x : ");
        x = scanner.nextInt();
        //envoyer x au serveur
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeInt(x); 
        //recevoir le resultat du serveur apres multiplication par 5       
        DataInputStream in = new DataInputStream(socket.getInputStream());
        int result = in.readInt();
        System.out.println("le resultat est : "+result);}
        while(x!=0);
        // fermer la connexion
        socket.close();
        scanner.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
