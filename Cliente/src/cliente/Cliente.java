/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Megsoft
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            InetAddress end = InetAddress.getLocalHost();
            Socket s = new Socket(end, 9000);
            Scanner entrada = new Scanner(s.getInputStream());
            PrintWriter saida = new PrintWriter(s.getOutputStream(), true);
            String msg, msgRecebida;

            do {
                System.out.println("Digite um texto");
                msg = teclado.nextLine();
                saida.println(msg);
                msgRecebida = entrada.nextLine();
                System.out.println(msgRecebida);            
            } while(!msg.equals("bye"));

            entrada.close();
            saida.close();
            s.close();
           
        } catch (Exception e) {
            System.out.println("erro de conexão " + e.getMessage());
        }
    }
    
}
