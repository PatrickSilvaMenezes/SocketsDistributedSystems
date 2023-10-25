package com.mycompany.basicsocketclient;

import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class BasicSocketClient {

    public static void main(String[] args) {
    try{
        Socket client = new Socket("127.0.0.1", 3322);
        ObjectInputStream reader = new ObjectInputStream(client.getInputStream());
        
        JOptionPane.showMessageDialog(null, "Server message: " + reader.readUTF());
        reader.close();
        client.close();
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,"Client error: " + e.getMessage());

    }


    }
}
