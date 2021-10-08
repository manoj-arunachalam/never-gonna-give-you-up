/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import java.math.*;

/**
 *
 * @author 5442
 */
public class darth_server {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        final int PORT = 8080; // host server is listening for requests

        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started...");
        System.out.println("Wating for clients...");

        switch (choice) {
            case 1:
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    Thread t = new Thread() {
                        public void run() {
                            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                                    Scanner in = new Scanner(clientSocket.getInputStream());) {
                                while (in.hasNextLine()) {
                                    String name;
                                    String addr = clientSocket.getLocalAddress().toString();
                                    String input = in.nextLine();
                                    if (input.equalsIgnoreCase("exit")) {
                                        break;
                                    }
                                    // if (addr.substring(9) == "1") {
                                    // name = "Alice ";
                                    // } else {
                                    // name = "Bob ";
                                    // }
                                    name = "";
                                    switch (addr.substring(9)) {
                                        case "1":
                                            name = "Alice";
                                            break;
                                        case "2":
                                            name = "Bob";
                                        default:
                                            break;
                                    }
                                    System.out.println("Received radius from " + name + input);
                                    System.out.println(addr.substring(9));

                                    double radius = Double.valueOf(input);
                                    double area = Math.PI * radius * radius;
                                    out.println(area);
                                }
                            } catch (IOException e) {
                            }
                        }
                    };
                    t.start();
                }
            case 2:
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    Thread t = new Thread() {

                        public void run() {
                            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                                    Scanner in = new Scanner(clientSocket.getInputStream());) {
                                while (in.hasNextLine()) {
                                    String name;
                                    String addr = clientSocket.getLocalAddress().toString();
                                    String input = in.nextLine();
                                    if (input.equalsIgnoreCase("exit")) {
                                        break;
                                    }
                                    // if (addr.substring(9) == "1") {
                                    // name = "Alice ";
                                    // } else {
                                    // name = "Bob ";
                                    // }
                                    name = "";
                                    switch (addr.substring(9)) {
                                        case "1":
                                            name = "Alice";
                                            break;
                                        case "2":
                                            name = "Bob";
                                        default:
                                            break;
                                    }
                                    System.out.println("Received radius from " + name + input);
                                    System.out.println(addr.substring(9));

                                    double radius = Double.valueOf(input);
                                    double area = Math.PI * radius * radius;
                                    out.println(area);
                                }
                            } catch (IOException e) {
                            }
                        }
                    };
                    t.start();
                }
            default:
                break;
        }
    }
}
