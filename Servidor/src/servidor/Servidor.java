/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Megsoft
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9000);

            while(true) {
                System.out.println("Aguardando cliente");
                Socket cliente = server.accept();
                Scanner entrada = new Scanner(cliente.getInputStream());
                PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
                String msg;

                do {
                    msg = entrada.nextLine();
                    saida.println(msg.toUpperCase());
                } while(!msg.equals("bye"));

                entrada.close();
                saida.close();
                cliente.close();
            }
        } catch (Exception e) {
            System.out.println("erro ao iniciar o servidor " + e.getMessage());
        }
    }
    
}
