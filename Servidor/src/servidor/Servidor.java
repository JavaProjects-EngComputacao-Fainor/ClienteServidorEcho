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
            // Criando novo servidor na porta 8900
            ServerSocket server = new ServerSocket(8900);
            System.out.println("Servidor iniciado na porta " + server.getLocalPort() + " " + server.getInetAddress().getHostAddress());
            
            // Esperando conexão de algum cliente
            Socket cliente = server.accept();
            System.out.println("clente: " + cliente.getInetAddress().getHostAddress());
            
            // Recuperação de dados enviados pelo cliente
            Scanner entrada = new Scanner(cliente.getInputStream());
            while(entrada.hasNextLine()) {
                String palavra = entrada.nextLine();
                System.out.println(palavra);
            }

            cliente.close();
            entrada.close();
            server.close();
        } catch (Exception e) {
            System.out.println("erro ao iniciar o servidor " + e.getMessage());
        }
    }
    
}
