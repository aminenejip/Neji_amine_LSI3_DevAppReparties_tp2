package clientPackage;

import java.net.Socket;

public class client {
public static void main(String[] args) {
    try{
        System.out.println("Je suis un client pas encore connecté");
    Socket socket=new Socket("localhost",12345);
        System.out.println("Je suis un client connecté");
        socket.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}
}
