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
            // Criando conexão com servidor da porta 8900
            Socket cliente = new Socket("0.0.0.0", 8900);
            String s1 = new String();
            
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            
            while(teclado.hasNextLine()) {
                s1 = teclado.nextLine();
                saida.println(s1);
                                
                if(s1.equals("bye")) {
                    System.out.println("tchau");
                    break;
                }
                
            }
            
            teclado.close();
            saida.close();
           
        } catch (Exception e) {
            System.out.println("erro de conexão " + e.getMessage());
        }
    }
    
}
