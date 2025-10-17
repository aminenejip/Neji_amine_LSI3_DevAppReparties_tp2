package serverPackage;

import operationPackage.Operation;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Serveur en attente d'un client...");

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connecté.");

                
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                while (true) {
                    try {
                        Object obj = in.readObject(); 
                        if (!(obj instanceof Operation)) {
                            System.out.println("Objet inattendu, on ignore.");
                            continue;
                        }

                        Operation op = (Operation) obj;
                        int resultat = 0;
                        switch (op.getOperateur()) {
                            case "+": resultat = op.getNb1() + op.getNb2(); break;
                            case "-": resultat = op.getNb1() - op.getNb2(); break;
                            case "*": resultat = op.getNb1() * op.getNb2(); break;
                            case "/":
                                if (op.getNb2() != 0) {
                                    resultat = op.getNb1() / op.getNb2(); // division entière
                                } else {
                                    System.out.println("Erreur : division par zéro");
                                    resultat = 0;
                                }
                                break;
                            default:
                                System.out.println("Opérateur invalide: " + op.getOperateur());
                        }

                       
                        out.writeObject(resultat);
                        out.flush();

                    } catch (EOFException e) {
                        System.out.println("Client déconnecté.");
                        break;
                    } catch (StreamCorruptedException e) {
                        System.out.println("Flux corrompu (probablement multiple headers). Fin de connexion.");
                        break;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Classe non trouvée: " + e.getMessage());
                    }
                }
            }

            System.out.println("Serveur terminé.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}