package br.ifpr.jogo.principal;

import javax.swing.JFrame;

public class Principal extends JFrame{
    public Principal(){
        setVisible(true);
        setSize(500, 500);
        setTitle("JOGO 2D");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) throws Exception {
        Principal principal = new Principal();
    }
}
