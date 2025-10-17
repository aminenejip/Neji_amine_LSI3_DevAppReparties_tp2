package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Je suis un serveur en attente de la connexion d'un client...");

            Socket socket = serverSocket.accept();
            System.out.println("Un client est connecté");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                try {
                    String operation = in.readUTF();
                    if (operation.equalsIgnoreCase("exit")) break; // optionnel

                    operation = operation.replaceAll("\\s+", "");
                    String[] parts = operation.split("[+\\-*/]");
                    int nb1 = Integer.parseInt(parts[0]);
                    int nb2 = Integer.parseInt(parts[1]);
                    String operateur = operation.replaceAll("\\d+", "").trim();

                    int resultat = 0;
                    switch (operateur) {
                        case "+":
                            resultat = nb1 + nb2;
                            break;
                        case "-":
                            resultat = nb1 - nb2;
                            break;
                        case "*":
                            resultat = nb1 * nb2;
                            break;
                        case "/":
                            if (nb2 != 0)
                                resultat = nb1 / nb2;
                            else
                                System.out.println("Erreur: Division par zéro");
                            break;
                        default:
                            System.out.println("Opérateur invalide");
                            break;
                    }

                    out.writeInt(resultat);
                    out.flush();
                } catch (IOException e) {
                    System.out.println("Le client s'est déconnecté.");
                    break;
                }
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
