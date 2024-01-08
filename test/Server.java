/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** 
 *
 * @author basib
 */  
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server gestartet, auf Port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Verbindung von " + socket.getInetAddress().getHostAddress());
            // Hier kannst du den Input- und Outputstream des Sockets verwenden, um Daten mit dem Client auszutauschen
            socket.close();
        }
    }
}
