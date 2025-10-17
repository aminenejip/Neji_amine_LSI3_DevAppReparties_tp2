package clientPackage;

import operationPackage.Operation;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Client connecté au serveur.");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Donnez l'opération (ex: 5*3) :");
                String input = scanner.nextLine().replaceAll("\\s+", "");

                while (!input.matches("\\d+[+\\-*/]\\d+")) {
                    System.out.println("Entrée invalide, réessayez :");
                    input = scanner.nextLine().replaceAll("\\s+", "");
                }

                int nb1 = Integer.parseInt(input.split("[+\\-*/]")[0]);
                int nb2 = Integer.parseInt(input.split("[+\\-*/]")[1]);
                String operateur = input.replaceAll("\\d+", "");

                Operation op = new Operation(nb1, nb2, operateur);

                out.writeObject(op);
                out.flush();

                try {
                    Integer result = (Integer) in.readObject();
                    System.out.println("Résultat : " + result);
                } catch (ClassNotFoundException e) {
                    System.out.println("Réponse inattendue du serveur.");
                }

                System.out.println("Faire une autre opération ? (1 = oui / 2 = non)");
                if (!scanner.nextLine().trim().equals("1")) {
                    System.out.println("Fin du programme.");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   