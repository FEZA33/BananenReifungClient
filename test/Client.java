/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  
 * @author basib
 */
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("Connected to server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter message: ");
            String request = userIn.readLine();
            out.println(request);
            if (request.equals("quit")) {
                break;
            }
            String response = in.readLine();
            System.out.println("Response: " + response);
        }
        socket.close();
    }
}
