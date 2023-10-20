package com.mycompany.basicsocketserver;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class BasicSocketServer {

    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(3322);
            while(true){
                String msg = JOptionPane.showInputDialog("Server Message to client: ");
                Socket client = serverSocket.accept();

                ObjectOutputStream writerClient = new ObjectOutputStream(client.getOutputStream());
                writerClient.writeUTF("Dados do client:  " + client.getInetAddress().getHostName() + "IP:  " + client.getInetAddress().getHostAddress() +  msg);
                writerClient.close();
                client.close();
            }
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Server error: " + e.getMessage());
        }
    }
}
