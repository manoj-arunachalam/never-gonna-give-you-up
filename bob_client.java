/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 5442
 */
public class bob_client {
    public static void main(String[] args) throws IOException {
        final String HOST = "127.0.0.2";
        final int PORT = 4040;

        System.out.println("Client-2 started.");

        try (Socket socket = new Socket(HOST, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());
                Scanner s = new Scanner(System.in);) {
            while (true) {
                System.out.print("Input: ");
                String input = s.nextLine();
                out.println(input);
                if (input.equalsIgnoreCase("exit"))
                    break;
                System.out.println("Echoed from server: " + in.nextLine());
            }
        }
    }

}