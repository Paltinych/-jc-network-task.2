package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 53254;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println(in.readLine());
            Scanner input = new Scanner(System.in);
            String name = input.nextLine().toUpperCase();
            out.println(name);

            String resp = in.readLine();
            System.out.println(resp);

            while (true) {
                String message = input.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    out.println(message);
                    break;
                }
                out.println(message);
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
